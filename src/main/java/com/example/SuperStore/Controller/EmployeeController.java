package com.example.SuperStore.Controller;

import com.example.SuperStore.RequestResponseDTO.CustomerResponseDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeRequestDTO;
import com.example.SuperStore.RequestResponseDTO.EmployeeResponseDTO;
import com.example.SuperStore.Service.ServiceImplementation.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/register_employee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        employeeService.createEmployee(employeeRequestDTO);
        return new ResponseEntity<>("New employee registered!", HttpStatus.CREATED);
    }

    @GetMapping("/get_employee_by_id")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@RequestParam("id")int id)
    {
        EmployeeResponseDTO employee= employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/get_all_employees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees()
    {
        List<EmployeeResponseDTO> employeeResponseDTOList= employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeResponseDTOList, HttpStatus.OK);
    }

//    @GetMapping("get_list_of_customers_by_employee")
//    public ResponseEntity<List<CustomerResponseDTO>> getListOfCustomersByEmployee(@RequestParam("id")int id)
//    {
//        List<CustomerResponseDTO> customerResponseDTOList= employeeService.getListOfCustomersByEmployee(id);
//        return new ResponseEntity<>(customerResponseDTOList,HttpStatus.ACCEPTED);
//    }
}
