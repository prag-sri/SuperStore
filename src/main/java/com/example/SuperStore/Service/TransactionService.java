package com.example.SuperStore.Service;

import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.TxnProductResponseDTO;

import java.util.List;

public interface TransactionService {

    public void buyProduct(int custId, int productId, int employeeId, int quantity);
    public void returnProduct(int custId, int productId, int employeeId, int quantity);
    public List<CustomerResponseDTO> getListOfCustomersByEmployee(int empId);
    public Double generateBill(int custId);
    public List<TxnProductResponseDTO> getListOfProductsBoughtByCustomer(int custId);
    public List<TxnProductResponseDTO> getListOfProductsReturnedByCustomer(int custId);
}
