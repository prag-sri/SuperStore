package com.example.SuperStore.Service;

import com.example.SuperStore.RequestResponseDTO.CustomerRequestDTO;
import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    public void registerCustomer(CustomerRequestDTO customerRequestDTO);
    public CustomerResponseDTO getCustomerById(int id);
    public CustomerResponseDTO getCustomerByName(String name);
    public List<CustomerResponseDTO> getAllCustomers();
}
