package com.example.SuperStore.Service;

import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeRequestDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    public void createEmployee(EmployeeRequestDTO employeeRequestDTO);

    public EmployeeResponseDTO getEmployeeById(int id);

    public List<EmployeeResponseDTO> getAllEmployees();
}
