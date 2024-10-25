package com.example.employee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
}
