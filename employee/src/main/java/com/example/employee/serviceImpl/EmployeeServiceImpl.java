package com.example.employee.serviceImpl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
         employeeRepository.save(employeeDTO);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.GetAllEmployee();
    }

    @Override
    public EmployeeModel GetEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public EmployeeModel updateEmployee(int id, EmployeeDTO employeeDTO) {
        return employeeRepository.update(id,employeeDTO);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.delete(id);
    }

}
