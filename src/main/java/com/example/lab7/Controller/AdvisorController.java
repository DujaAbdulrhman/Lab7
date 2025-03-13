package com.example.lab7.Controller;

import com.example.lab7.Model.Advisor;
import com.example.lab7.Service.AdvisorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/advisor")
public class AdvisorController {
    private final AdvisorService advisorService;

    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @PostMapping("/add")
    public ResponseEntity addAdvisor(@Valid @RequestBody Advisor advisor, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        String result = advisorService.addAdvisor(advisor);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/get")
    public ResponseEntity getAllAdvisors() {
        return ResponseEntity.status(200).body(advisorService.getAllAdvisors());
    }


    @DeleteMapping("/delete/{advisorName}")
    public ResponseEntity deleteAdvisor(@PathVariable String advisorName) {
        String result = advisorService.deleteAdvisor(advisorName);
        if (result.equals("Advisor deleted successfully!")) {
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.status(404).body(result);
    }

    @GetMapping("/getAdvisorStudentNum")
    public ResponseEntity getAdvisorStudentNum() {
        return ResponseEntity.status(200).body(advisorService.getAdvisorStudentNum());
    }

    @PutMapping("/updatecourses/{advisorName}")
    public ResponseEntity updateCourses(@PathVariable String advisorName, @RequestBody ArrayList<String> newCourses) {
        String result = advisorService.updateCourses(advisorName, newCourses);
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/getcalcSalary/{advisorName}")
    public ResponseEntity calcSalary(@PathVariable String advisorName) {
        Double salary = advisorService.calcSalary(advisorName);
        if (salary != null) {
            return ResponseEntity.status(200).body("Advisor salary: " + salary);
        }
        return ResponseEntity.status(404).body("Advisor not found!");
    }


    @GetMapping("/getsafadv")
    public ResponseEntity SAFADV() {
        Double average = advisorService.SAFADV();
        return ResponseEntity.status(200).body("Average students per advisor: " + average);
    }
}