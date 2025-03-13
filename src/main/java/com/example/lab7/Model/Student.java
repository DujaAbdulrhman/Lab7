/*
package com.example.lab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty
    @Size(min = 1, max = 10)
    private String id;
    @Email
    private String email;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;
    @NotNull
    @Min(5)
    private double GBA;
    @NotEmpty @Size(min = 1, max = 200)
    private String academicPlan;
    @NotEmpty @Size(min = 1, max = 20)
    private String advaisorName;
    @NotEmpty
    private ArrayList<String> sCourses;

}
*/
package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty
    @Size(min = 1, max = 10)
    private String id;

    @Email
    private String email;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    @Min(0) @Max(4) // GPA should be between 0 and 4
    private Double gpa;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String academicPlan;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String advisorName;

    @NotEmpty
    private ArrayList<String> courses;
}