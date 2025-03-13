/*
package com.example.lab7.Controller;

import com.example.lab7.Model.student;
import com.example.lab7.Service.studentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {

    private final studentService studentService;
    ArrayList<student> students = new ArrayList<>();

    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity addStudnt(@Valid student student, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        students.add(student);
        return ResponseEntity.status(200).body(students);
    }

    @PutMapping("/update")
    public ResponseEntity updateStudent(@Valid student student, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/gethoner")
    public ResponseEntity classHoner(){
        return ResponseEntity.status(200).body(studentService.classHonor());
    }

    //اكتبي كود كونترولر لحساب كم الفرق بينه وبين الفيرست كلاس اونر


}
*/
package com.example.lab7.Controller;

import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        String result = studentService.addStudent(student);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @GetMapping("/gethighesgba")
    public ResponseEntity gethighesGBA() {
        return ResponseEntity.status(200).body(studentService.gethighesGBA());
    }

    @PutMapping("/update-courses/{studentId}")
    public ResponseEntity updateStudentCourses(@PathVariable String studentId, @RequestBody ArrayList<String> newCourses) {
        String result = studentService.updateStudentCourses(studentId, newCourses);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/firstclasshonors/{studentId}")
    public ResponseEntity firstClassHonors(@PathVariable String studentId) {
        Double difference = studentService.firstClassHonors(studentId);
        if (difference != null) {
            return ResponseEntity.status(200).body("GPA difference to first class honors: " + difference);
        }
        return ResponseEntity.status(400).body("Student not found!");
    }

    @GetMapping("/isvalidcourse/{studentId}/{courseNumber}")
    public ResponseEntity isValidCourse(@PathVariable String studentId, @PathVariable String courseNumber) {
        String result = studentService.isValidCourse(studentId, courseNumber);
        return ResponseEntity.status(200).body(result);
    }


    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable String studentId) {
        String result = studentService.deleteStudent(studentId);
        if (result.equals("Student deleted successfully!")) {
            return ResponseEntity.status(200).body(result);
        }
        return ResponseEntity.status(404).body(result);
    }

}