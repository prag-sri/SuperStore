package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.BuyReturn;
import com.example.SuperStore.Model.Product;
import com.example.SuperStore.Model.Transaction;
import com.example.SuperStore.Repository.ProductRepository;
import com.example.SuperStore.Repository.TransactionRepository;
import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.TxnProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TransactionServiceImpl {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ProductRepository productRepository;

    public void buyProduct(int custId, int productId, int employeeId, int quantity) {
        Product product= productRepository.findById(productId).get();
        int currQuantity= product.getQuantity();
        if(currQuantity<quantity)
            throw new RuntimeException("Product out of stock!");

        Transaction newTxn= new Transaction();
        newTxn.setProductId(productId);
        newTxn.setQuantity(quantity);
        newTxn.setCustId(custId);
        newTxn.setEmpId(employeeId);
        newTxn.setBuyReturn(BuyReturn.BUY);
        newTxn.setTxnPaid(false);
        transactionRepository.save(newTxn);

        if(currQuantity==quantity)
            product.setInStock(false);

        product.setQuantity(currQuantity-quantity);
        productRepository.save(product);
    }

    public void returnProduct(int custId, int productId, int employeeId, int quantity){
        Product product= productRepository.findById(productId).get();
        int currQuantity= product.getQuantity();

        Transaction t= null;
        for(Transaction txn: transactionRepository.findAll())
        {
            if(txn.getCustId()==custId && txn.getProductId()==productId)
            {
                System.out.println("yes");
                if(txn.getQuantity()<quantity)
                    throw new RuntimeException("Quantity bought by customer mismatches!");
                if(txn.getBuyReturn()==BuyReturn.BUY && txn.isTxnPaid()==true)
                {
                    System.out.println("yesyes");
                    t= txn;
                    break;
                }
            }
        }

        if(t==null)
            throw new RuntimeException("Product not bought by the customer!");

        t.setTxnPaid(false);
        transactionRepository.save(t);

        Transaction newTxn = new Transaction();
        newTxn.setProductId(productId);
        newTxn.setQuantity(quantity);
        newTxn.setCustId(custId);
        newTxn.setEmpId(employeeId);
        newTxn.setBuyReturn(BuyReturn.RETURN);
        newTxn.setTxnPaid(false);
        transactionRepository.save(newTxn);

        if(product.isInStock()==false)
            product.setInStock(true);

        product.setQuantity(currQuantity+quantity);
        productRepository.save(product);
    }

    public List<CustomerResponseDTO> getListOfCustomersByEmployee(int empId) {
        List<CustomerResponseDTO> customerResponseDTOList= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(Transaction txn: transactionRepository.findAll())
        {
            if(txn.getEmpId()==empId)
            {
                CustomerResponseDTO cust= customerService.getCustomerById(txn.getCustId());
                if(!map.containsKey(cust.getId()))
                    customerResponseDTOList.add(cust);
                map.put(cust.getId(),1);
            }
        }
        return customerResponseDTOList;
    }

    public Double generateBill(int custId){
        double totalAmount= 0;
        for(Transaction txn: transactionRepository.findAll())
        {
            if (txn.getCustId() == custId)
            {
                Product product= productRepository.findById(txn.getProductId()).get();
                if (txn.getBuyReturn().equals(BuyReturn.BUY))
                    totalAmount += product.getPrice() * txn.getQuantity();
                else
                    totalAmount -= product.getPrice() * txn.getQuantity();

                txn.setTxnPaid(true);
                transactionRepository.save(txn);

//              System.out.println(txn.isTxnPaid());
            }
        }
        return totalAmount;
    }

    public List<TxnProductResponseDTO> getListOfProductsBoughtByCustomer(int custId) {
        List<TxnProductResponseDTO> txnProductResponseDTOList= new ArrayList<>();
        for(Transaction txn: transactionRepository.findAll())
        {
            if (txn.getCustId()== custId  && txn.getBuyReturn()==BuyReturn.BUY)
            {
                if(txn.isTxnPaid()==true)
                {
                    TxnProductResponseDTO txnProductResponseDTO= new TxnProductResponseDTO();
                    txnProductResponseDTO.setProductId(txn.getProductId());
                    txnProductResponseDTO.setQuantity(txn.getQuantity());
                    txnProductResponseDTO.setCustId(txn.getCustId());
                    txnProductResponseDTO.setEmpId(txn.getEmpId());
                    txnProductResponseDTO.setBuyReturn(txn.getBuyReturn());
                    txnProductResponseDTO.setPurchaseDt(txn.getpurchaseDt());

                    txnProductResponseDTOList.add(txnProductResponseDTO);
                }
            }
        }
        return txnProductResponseDTOList;
    }

    public List<TxnProductResponseDTO> getListOfProductsReturnedByCustomer(int custId) {
        List<TxnProductResponseDTO> txnProductResponseDTOList= new ArrayList<>();
        for(Transaction txn: transactionRepository.findAll())
        {
            if (txn.getCustId() == custId && txn.getBuyReturn()==BuyReturn.RETURN)
            {
                if(txn.isTxnPaid()==true) {
                    TxnProductResponseDTO txnProductResponseDTO = new TxnProductResponseDTO();
                    txnProductResponseDTO.setProductId(txn.getProductId());
                    txnProductResponseDTO.setQuantity(txn.getQuantity());
                    txnProductResponseDTO.setCustId(txn.getCustId());
                    txnProductResponseDTO.setEmpId(txn.getEmpId());
                    txnProductResponseDTO.setBuyReturn(txn.getBuyReturn());
                    txnProductResponseDTO.setPurchaseDt(txn.getpurchaseDt());

                    txnProductResponseDTOList.add(txnProductResponseDTO);
                }
            }
        }
        return txnProductResponseDTOList;
    }
}
