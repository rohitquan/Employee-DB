package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;


    @PostMapping("/add")
    public void createEmpolyee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return  employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable int id){
        EmployeeModel employee = employeeService.GetEmployeeById(id);
        return employee!=null?ResponseEntity.ok(employee):ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        EmployeeModel updatedEmployee= employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
//{
//        package com.example.employee.controller;
//
//import com.example.employee.dto.EmployeeDTO;
//import com.example.employee.service.EmployeeService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//        import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    // Create Employee
//    @PostMapping
//    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        try {
//            employeeService.saveEmployee(employeeDTO);
//            return ResponseEntity.ok("Employee created successfully");
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    // Read All Employees
//    @GetMapping
//    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
//        try {
//            List<EmployeeDTO> employees = employeeService.getAllEmployees();
//            return ResponseEntity.ok(employees);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    // Read Employee by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
//        try {
//            EmployeeDTO employee = employeeService.getEmployeeById(id);
//            return ResponseEntity.ok(employee);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    // Update Employee
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
//        try {
//            employeeService.updateEmployee(id, employeeDTO);
//            return ResponseEntity.ok("Employee updated successfully");
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    // Delete Employee
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
//        try {
//            employeeService.deleteEmployee(id);
//            return ResponseEntity.ok("Employee deleted successfully");
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    // Generic Exception Handler
//    private ResponseEntity<String> handleException(Exception e) {
//        // Log the exception (optional)
//        // logger.error("Error occurred: ", e);
//
//        String errorMessage = "An error occurred: " + e.getMessage();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
//    }
//}
//
//        }