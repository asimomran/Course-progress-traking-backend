package com.example.CourseProgressTrackingBackend.Service;

import com.example.CourseProgressTrackingBackend.Model.Course;
import com.example.CourseProgressTrackingBackend.Model.Student;
import com.example.CourseProgressTrackingBackend.Service.CourseService;
import com.example.CourseProgressTrackingBackend.Model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EnrollmentService {
    List<Enrollment> enrollments = new ArrayList<>();
    int idCounter = 1;
    public Enrollment enrollStudent(int studentId,int courseId){
        Enrollment e = new Enrollment();
        e.id = idCounter++;
        e.studentId = studentId;
        e.courseId = courseId;
        enrollments.add(e);
        return e;
    }
    public List<Enrollment> getEnrollments(){
        return enrollments;
    }

    @Autowired
    CourseService courseService;
    public List<Course> getCourseByStudentId(int studentId){
        List<Course> result = new ArrayList<>();
        for(Enrollment e: enrollments){
            if(e.studentId==studentId) {
                Course c = courseService.getCourseById(e.courseId);
                if(c!=null){
                    result.add(c);
                }
            }
        }
        return result;
    }

    @Autowired
    StudentService studentService;
    public List<Student> getStudentByCourseId(int courseid){
        List<Student> result = new ArrayList<>();
        for(Enrollment e:enrollments){
            if(e.courseId==courseid){
                Student s = studentService.getStudentById(e.studentId);
                if(s!=null){
                    result.add(s);
                }
            }
        }
        return result;
    }
}
