package com.example.employee.repositoryImpl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.model.rowmapper.EmployeeRowMapper;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private  JdbcTemplate jdbcTemplate;


    @Override
    public void save(EmployeeDTO employeeDTO) {
        String sql = "INSERT INTO employees(first_name,last_name,email) VALUES (?,?,?)";
        jdbcTemplate.update(sql,employeeDTO.getFirstName(),employeeDTO.getLastName(),employeeDTO.getEmail());
    }

    @Override
    public List<EmployeeModel> GetAllEmployee() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public EmployeeModel getEmployeeById(int id) {
        String sql="Select * FROM employees WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),id);
    }

    @Override
    public EmployeeModel update(int id, EmployeeDTO employeeDTO) {
        String sql = "UPDATE employees SET first_name = ?,last_name= ?,email= ? WHERE id= ?";
        jdbcTemplate.update(sql,employeeDTO.getFirstName(),employeeDTO.getLastName(),employeeDTO.getEmail(),id);
        return getEmployeeById(id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

}
