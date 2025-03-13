package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Advisor {
    @NotEmpty
    @Size(min = 2, max = 50)
    private String advisorName;

    @NotNull
    @Min(0)
    private Integer numberOfStudents;

    @Email
    private String advisorEmail;

    private double hoursWorked;
    @Min(0)@NotNull
    private double salary;
    @NotEmpty
    private ArrayList<String> courses;
}
