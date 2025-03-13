/*
package com.example.lab7.Service;

import com.example.lab7.Model.Advaisor;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AdvaisorService {

    ArrayList<Advaisor>Courses;
    static ArrayList<Advaisor>Advaisors;
    public String addAdvaisor(@Valid Advaisor advaisor) {
        Courses.add(advaisor);
        return "Advaisor added";
    }

    public static String getAllAdvaisors() {
        return Advaisors.toString();
    }

    */
/*public static void getStusentinfo(@){
        if ()
        return Stusents;
    }*//*


    public ArrayList<String> getAdvaisors() {
        for (Advaisor advaisor : Advaisors) {
            ArrayList<String> advaisor10=new ArrayList<>();
            if (advaisor.getNumberOfStudents() >10){
                advaisor10.add(String.valueOf(advaisor));
                return advaisor10;
            }else return null;
        }return null;

    }


}
*/
package com.example.lab7.Service;

import com.example.lab7.Model.Advisor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdvisorService {
    private ArrayList<Advisor> advisors = new ArrayList<>();

    public String addAdvisor(Advisor advisor) {
        advisors.add(advisor);
        return "Advisor added successfully!";
    }

    public ArrayList<Advisor> getAllAdvisors() {
        return advisors;
    }

    public ArrayList<Advisor> getAdvisorStudentNum() {
        ArrayList<Advisor> result = new ArrayList<>();
        for (Advisor advisor : advisors) {
            if (advisor.getNumberOfStudents() > 10) {
                result.add(advisor);
            }
        }
        return result;
    }

    public String updateCourses(String advisorName, ArrayList<String> newCourses) {
        for (Advisor advisor : advisors) {
            if (advisor.getAdvisorName().equals(advisorName)) {
                advisor.setCourses(newCourses);
                return "Courses updated successfully!!";
            }
        }
        return "Advisor not found";
    }

    //نحذف بالاسم مو بالاي دي
    public String deleteAdvisor(String advisorName) {
        for (Advisor advisor : advisors) {
            if (advisor.getAdvisorName().equals(advisorName)) {
                advisors.remove(advisor);
                return "Advisor deleted successfully!";
            }
        }
        return "Advisor not found!";
    }


    public Double calcSalary(String advisorName) {
        for (Advisor advisor : advisors) {
            if (advisor.getAdvisorName().equals(advisorName)) {
                double baseSalary = advisor.getSalary();
                if (advisor.getHoursWorked() > 32) {
                    return baseSalary + 200;
                }
                return baseSalary;
            }
        }
        return null;
    }

    //SAFADV =Students Average Per Advisor
    public Double SAFADV() {
        if (advisors.isEmpty()) {
            return 0.0;
        }
        int totalStudents = 0;
        for (Advisor advisor : advisors) {
            totalStudents += advisor.getNumberOfStudents();
        }
        return (double) totalStudents / advisors.size();
    }
}