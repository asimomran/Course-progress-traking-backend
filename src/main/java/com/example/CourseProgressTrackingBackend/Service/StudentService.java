package com.example.CourseProgressTrackingBackend.Service;

import com.example.CourseProgressTrackingBackend.Model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    int idCounter = 1;
    List<Student> students = new ArrayList<>();
    public Student registerStudent(Student student){
        student.id=idCounter++;
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
    public Student getStudentById(int id){
        for(Student s:students){
            if(s.id==id){
                return s;
            }
        }
        return null;
    }

    public String deleteStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                return "Student deleted";
            }
        }
        return "Student not found";
    }

}
