package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.Customer;
import com.example.SuperStore.Model.Employee;
import com.example.SuperStore.Repository.EmployeeRepository;
import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeRequestDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerServiceImpl customerService;

    public void createEmployee(EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee= new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setMobileNo(employeeRequestDTO.getMobileNo());
        employeeRepository.save(employee);
    }

    public EmployeeResponseDTO getEmployeeById(int id)
    {
        Employee employee= employeeRepository.findById(id).get();
        EmployeeResponseDTO employeeResponseDTO= new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setMobileNo(employee.getMobileNo());
        return employeeResponseDTO;
    }

    public List<EmployeeResponseDTO> getAllEmployees()
    {
        List<Employee> employeeList= employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList= new ArrayList<>();
        for(Employee e: employeeList)
        {
            EmployeeResponseDTO employeeResponseDTO= new EmployeeResponseDTO();
            employeeResponseDTO.setId(e.getId());
            employeeResponseDTO.setName(e.getName());
            employeeResponseDTO.setMobileNo(e.getMobileNo());
            employeeResponseDTOList.add(employeeResponseDTO);
        }
        return employeeResponseDTOList;
    }

    public List<CustomerResponseDTO> getListOfCustomersByEmployee(int id)
    {
        Employee employee= employeeRepository.findById(id).get();
        List<Customer> customerList= employee.getCustomerList();
        List<CustomerResponseDTO> customerResponseDTOList= new ArrayList<>();
        for(Customer c: customerList)
        {
            CustomerResponseDTO customerResponseDTO= customerService.getCustomerById(c.getId());
            customerResponseDTOList.add(customerResponseDTO);
        }
        return customerResponseDTOList;
    }
}
