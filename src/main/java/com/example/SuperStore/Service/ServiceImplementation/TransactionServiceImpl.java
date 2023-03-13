package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.BuyReturn;
import com.example.SuperStore.Model.Transaction;
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
import java.util.List;

@Service
public class TransactionServiceImpl {

    @Autowired
    TransactionRepository transactionRepository;

    public void buyProduct(int custId, int productId, int employeeId, int quantity) {
        Transaction newTxn= new Transaction();
        newTxn.setProductId(productId);
        newTxn.setQuantity(quantity);
        newTxn.setCustId(custId);
        newTxn.setEmpId(employeeId);
        newTxn.setBuyReturn(BuyReturn.BUY);
        newTxn.setTxnPaid(false);
        transactionRepository.save(newTxn);
    }

    public void returnProduct(int custId, int productId, int employeeId, int quantity){
        Transaction newTxn= new Transaction();
        newTxn.setProductId(productId);
        newTxn.setQuantity(quantity);
        newTxn.setCustId(custId);
        newTxn.setEmpId(employeeId);
        newTxn.setBuyReturn(BuyReturn.RETURN);
        newTxn.setTxnPaid(false);
        transactionRepository.save(newTxn);
    }

    public List<CustomerResponseDTO> getListOfCustomersByEmployee(int empId) {
        List<CustomerResponseDTO> customerResponseDTOList= new ArrayList<>();
        for(Transaction txn: transactionRepository.findAll())
        {
            if(txn.getEmpId()==empId)
            {
                CustomerResponseDTO cust=
            }
        }
    }

    public Double generateBill(int custId){

    }

    public List<TxnProductResponseDTO> getListOfProductsBoughtByCustomer(int id) {

    }

    public List<TxnProductResponseDTO> getListOfProductsReturnedByCustomer(int id) {

    }
}
