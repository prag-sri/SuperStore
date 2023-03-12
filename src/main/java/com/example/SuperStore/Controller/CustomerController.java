package com.example.SuperStore.Controller;

import com.example.SuperStore.RequestResponseDTO.CustomerRequestDTO;
import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.Service.ServiceImplementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/register_customer")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerRequestDTO customerRequestDTO)
    {
        customerService.registerCustomer(customerRequestDTO);
        return new ResponseEntity<>("New customer registered successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/get_customer_by_id")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@RequestParam("id")int id)
    {
        CustomerResponseDTO customerResponseDTO= customerService.getCustomerById(id);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_customer_by_name")
    public ResponseEntity<CustomerResponseDTO> getCustomerByName(@RequestParam("name")String name)
    {
        CustomerResponseDTO customerResponseDTO= customerService.getCustomerByName(name);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_all_customers")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers()
    {
        List<CustomerResponseDTO> customerResponseDTOList= customerService.getAllCustomers();
        return new ResponseEntity<>(customerResponseDTOList, HttpStatus.OK);
    }

//    @PutMapping("/buy_product")
//    public ResponseEntity<String> buyProduct(@RequestParam("custId")int custId, @RequestParam("productId")int productId, @RequestParam("employeeId")int employeeId, @RequestParam("quantity")int quantity) throws Exception {
//        customerService.buyProduct(custId,productId,employeeId,quantity);
//        return new ResponseEntity<>("Customer bought the product!", HttpStatus.OK);
//    }
//
//    @PutMapping("/return_product")
//    public ResponseEntity<String> returnProduct(@RequestParam("custId")int custId, @RequestParam("productId")int productId, @RequestParam("quantity")int quantity){
//        customerService.returnProduct(custId,productId,quantity);
//        return new ResponseEntity<>("Customer returned the product!",HttpStatus.OK);
//    }
}
