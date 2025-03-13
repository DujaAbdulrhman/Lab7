/*package com.example.lab7.Service;


import org.springframework.stereotype.Service;


@Service
public class studentService {
    public Object studentService() {
        return studentService.class;
    }


 public Object getAllStudent(@Valid student student) {
        return students;
    }


public String classHoner( Student student,) {
        if (gba < 4.75) {
            double average = 4.75 - gba;
            return "The amount between you and the first class honor is: " + average;
        }
        return null; }




public String classHoner() {
        double gba = student.getGBA();
        if (gba < 4.75) {
            double average = 4.75 - gba;
            return "The amount between you and the first class honor is: " + average;
        }
        return null;
    }*//*


    //اكتبي كود السيرفس لحساب كم الفرق بينه وبين الفيرست كلاس اونر
}


package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    public String classHonor(Student Student) {
        double gba = com.example.lab7.Model.Student.getGBA();
        if (gba < 4.75) {
            double average = 4.75 - gba;
            return "The amount between you and the first class honor is: " + average;
        }
        return "You are already in the first class honor.";
    }


    /*
    public Object getAllStudents(@Valid Student student) {
        return students; // Ensure 'students' is defined within this class
    }
    *//*
}*/
package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public String addStudent(Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student gethighesGBA() {
        Student topStudent = null;
        double maxGPA = 0;
        for (Student student : students) {
            if (student.getGpa() > maxGPA) {
                maxGPA = student.getGpa();
                topStudent = student;
            }
        }
        return topStudent;
    }

    public String updateStudentCourses(String studentId, ArrayList<String> newCourses) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                student.setCourses(newCourses);
                return "Courses updated successfully!";
            }
        }
        return "Student not found!";
    }

    public String deleteStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                students.remove(student);
                return "Student deleted successfully!";
            }
        }
        return "Student not found!";
    }

    //يحسب كم بينه وبين مرتبه الشرف
    public Double firstClassHonors(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                double firstClassHonorsGPA = 4.75;
                return firstClassHonorsGPA - student.getGpa();
            }
        }
        return null;
    }

    //اذا ما اخذ كورس 98 مايقدر ياخذ كورس ال 99
    public String isValidCourse(String studentId, String courseNumber) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                ArrayList<String> courses = student.getCourses();
                if (courses.contains("98")) {
                    return "Student is eligible to take course " + courseNumber;
                } else if (courseNumber.equals("99")) {
                    return "Student cannot take course 99 without completing course 98";
                } else {
                    return "Student is eligible to take course " + courseNumber;
                }
            }
        }
        return "Student not found!";
    }
}
