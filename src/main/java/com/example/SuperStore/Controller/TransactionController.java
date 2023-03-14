package com.example.SuperStore.Controller;

import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.ProductResponseDTO;
import com.example.SuperStore.RequestResponseDTO.TxnProductResponseDTO;
import com.example.SuperStore.Service.ServiceImplementation.CustomerServiceImpl;
import com.example.SuperStore.Service.ServiceImplementation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;

    @PutMapping("/buy_product")
    public ResponseEntity<String> buyProduct(@RequestParam("custId")int custId, @RequestParam("productId")int productId, @RequestParam("employeeId")int employeeId, @RequestParam("quantity")int quantity) throws Exception {
        transactionService.buyProduct(custId,productId,employeeId,quantity);
        return new ResponseEntity<>("Customer bought the product!", HttpStatus.OK);
    }

    @PutMapping("/return_product")
    public ResponseEntity<String> returnProduct(@RequestParam("custId")int custId, @RequestParam("productId")int productId, @RequestParam("employeeId")int employeeId, @RequestParam("quantity")int quantity){
        transactionService.returnProduct(custId,productId,employeeId,quantity);
        return new ResponseEntity<>("Customer returned the product!",HttpStatus.OK);
    }

    @GetMapping("get_list_of_customers_by_employee")
    public ResponseEntity<List<CustomerResponseDTO>> getListOfCustomersByEmployee(@RequestParam("empId")int empId)
    {
        List<CustomerResponseDTO> customerResponseDTOList= transactionService.getListOfCustomersByEmployee(empId);
        return new ResponseEntity<>(customerResponseDTOList,HttpStatus.ACCEPTED);
    }

    @PutMapping("generate_bill")
    public ResponseEntity<String> generateBill(@RequestParam("custId")int custId){
        double totalAmount= transactionService.generateBill(custId);
        return new ResponseEntity<>("Total Bill Amount: Rs. "+totalAmount,HttpStatus.OK);
    }

    @GetMapping("get_list_of_products_bought_by_customer")
    public ResponseEntity<List<TxnProductResponseDTO>> getListOfProductsBoughtByCustomer(@RequestParam("id")int id)
    {
        List<TxnProductResponseDTO> txnProductResponseDTOList= transactionService.getListOfProductsBoughtByCustomer(id);
        return new ResponseEntity<>(txnProductResponseDTOList,HttpStatus.ACCEPTED);
    }

    @GetMapping("get_list_of_products_returned_by_customer")
    public ResponseEntity<List<TxnProductResponseDTO>> getListOfProductsReturnedByCustomer(@RequestParam("id")int id)
    {
        List<TxnProductResponseDTO> txnProductResponseDTOList= transactionService.getListOfProductsReturnedByCustomer(id);
        return new ResponseEntity<>(txnProductResponseDTOList,HttpStatus.ACCEPTED);
    }
}
