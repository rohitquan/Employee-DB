package com.example.employee.repository;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeRepository {

    void save(EmployeeDTO employeeDTO);
    List<EmployeeModel> GetAllEmployee();
    EmployeeModel getEmployeeById(int id);
    EmployeeModel update(int id,EmployeeDTO employeeDTO);
    void delete(int id);

}
