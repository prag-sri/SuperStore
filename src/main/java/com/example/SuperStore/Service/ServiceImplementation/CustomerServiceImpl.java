package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.Customer;
import com.example.SuperStore.Model.Employee;
import com.example.SuperStore.Model.Product;
import com.example.SuperStore.Repository.CustomerRepository;
import com.example.SuperStore.Repository.EmployeeRepository;
import com.example.SuperStore.Repository.ProductRepository;
import com.example.SuperStore.RequestResponseDTO.CustomerRequestDTO;
import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    ProductRepository productRepository;

    public void registerCustomer(CustomerRequestDTO customerRequestDTO)
    {
        Customer customer= new Customer();
        customer.setName(customerRequestDTO.getName());
        customer.setMobile(customerRequestDTO.getMobile());

        customerRepository.save(customer);
    }

    public CustomerResponseDTO getCustomerById(int id)
    {
        Customer customer= customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO= new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setMobile(customer.getMobile());

        return customerResponseDTO;
    }

    public CustomerResponseDTO getCustomerByName(String name)
    {
        List<Customer> customerList= customerRepository.findAll();
        for(Customer customer: customerList)
        {
            if(customer.getName().equals(name))
            {
                return getCustomerById(customer.getId());
            }
        }
        return null;
    }

    public List<CustomerResponseDTO> getAllCustomers()
    {
        List<CustomerResponseDTO> customerResponseDTOList= new ArrayList<>();
        for(Customer c: customerRepository.findAll())
        {
            CustomerResponseDTO customerResponseDTO= getCustomerById(c.getId());
            customerResponseDTOList.add(customerResponseDTO);
        }
        return customerResponseDTOList;
    }
}
