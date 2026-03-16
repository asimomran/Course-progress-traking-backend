package com.example.CourseProgressTrackingBackend.Service;

import com.example.CourseProgressTrackingBackend.Model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    List<Student> students = new ArrayList<>();
    public Student registerStudent(Student student){
        students.add(student);
        return student;
    }
    public Student Login(String email,String password){
        for(Student s:students){
            if(s.email.equals(email) && s.password.equals(password)){
                return s;
            }
        }
        return null;
    }
    public List<Student> getStudents(){
        return students;
    }
}
