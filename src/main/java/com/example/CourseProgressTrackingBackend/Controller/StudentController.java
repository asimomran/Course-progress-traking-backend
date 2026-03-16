package com.example.CourseProgressTrackingBackend.Controller;

import com.example.CourseProgressTrackingBackend.Model.Student;
import com.example.CourseProgressTrackingBackend.Service.StudentService;
//import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public  StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public Student regiStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }
    @GetMapping
    public List<Student> getStudentService(){
        return studentService.getStudents();
    }

    @PostMapping("/login")
    public Student login(@RequestBody Student student){
        return studentService.Login(student.email,student.password);
    }
}
