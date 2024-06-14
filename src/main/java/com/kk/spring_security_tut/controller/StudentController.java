package com.kk.spring_security_tut.controller;

import com.kk.spring_security_tut.models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<Student>();

    @GetMapping("/students")
    public List<Student> students(){

        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("John");
        student1.setLastName("Smith");
        Student student2 = new Student();

        student2.setId(2);
        student2.setFirstName("Jane");
        student2.setLastName("Doe");

        students.add(student1);
        students.add(student2);

        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome to Spring Security Tut";
    }
}
