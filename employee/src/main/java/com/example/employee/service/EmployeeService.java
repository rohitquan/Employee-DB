package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import java.util.List;

public interface EmployeeService{

    void createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeModel> getAllEmployees();
    EmployeeModel GetEmployeeById(int id);
    EmployeeModel updateEmployee(int id,EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
}
