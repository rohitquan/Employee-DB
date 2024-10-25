package com.example.employee.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeModel{
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
