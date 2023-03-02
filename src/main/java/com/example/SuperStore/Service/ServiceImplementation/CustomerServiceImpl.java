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
        Employee employee= employeeRepository.findById(customerRequestDTO.getEmployeeId()).get();
        customer.setName(customerRequestDTO.getName());
        customer.setMobile(customerRequestDTO.getMobile());
        customer.setEmployee(employee);

        List<Customer> customerList= employee.getCustomerList();
        customerList.add(customer);
        employee.setCustomerList(customerList);

        customerRepository.save(customer);
    }

    public CustomerResponseDTO getCustomerById(int id)
    {
        Customer customer= customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO= new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setMobile(customer.getMobile());
        customerResponseDTO.setBillDt(customer.getBillDt());
        customerResponseDTO.setBillAmount(customer.getBillAmount());

        EmployeeResponseDTO employeeResponseDTO= employeeService.getEmployeeById(customer.getEmployee().getId());

        customerResponseDTO.setEmployeeResponseDTO(employeeResponseDTO);

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

    public void buyProduct(int custId, int productId, int employeeId, int quantity) throws Exception {
        Customer customer= customerRepository.findById(custId).get();
        Product product= productRepository.findById(productId).get();
        Employee employee= employeeRepository.findById(employeeId).get();

        int currentQuantity= product.getQuantity();
        if(currentQuantity<quantity)
            throw new Exception("Product out of Stock!");
        int newQuantity= currentQuantity-quantity;

        if(newQuantity==0)
            product.setInStock(false);
        product.setQuantity(newQuantity);

        List<Product> productList= customer.getBoughtItemsList();
        productList.add(product);
        customer.setBoughtItemsList(productList);

        customer.setEmployee(employee);

        List<Customer> customerList= employee.getCustomerList();
        customerList.add(customer);
        employee.setCustomerList(customerList);

        customerRepository.save(customer);
    }

    public void returnProduct(int custId, int productId, int quantity){
        Customer customer= customerRepository.findById(custId).get();
        Product product= productRepository.findById(productId).get();

        int currentQuantity= product.getQuantity();
        if(currentQuantity==0)
            product.setInStock(true);
        int newQuantity= currentQuantity+quantity;
        product.setQuantity(newQuantity);

        List<Product> productList= customer.getReturnedItemsList();
        productList.add(product);
        customer.setReturnedItemsList(productList);

        customerRepository.save(customer);
    }

    public double generateBill(int custId){
        Customer customer= customerRepository.findById(custId).get();
        List<Product> productList= customer.getBoughtItemsList();
        double billAmount= 0;
        for(Product p: productList)
        {
            billAmount+= p.getPrice()*
        }
    }
}
