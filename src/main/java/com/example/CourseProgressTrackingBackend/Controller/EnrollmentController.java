package com.example.CourseProgressTrackingBackend.Controller;

import com.example.CourseProgressTrackingBackend.Model.Course;
import com.example.CourseProgressTrackingBackend.Model.Enrollment;
import com.example.CourseProgressTrackingBackend.Model.Student;
import com.example.CourseProgressTrackingBackend.Service.EnrollmentService;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    public final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public Enrollment enrollStudents(@RequestBody Enrollment enrollment){
        return enrollmentService.enrollStudent(enrollment.studentId,enrollment.courseId);
    }

    @GetMapping
    public List<Enrollment> getEnrollments(){
        return enrollmentService.getEnrollments();
    }

    @GetMapping("/student/{id}/courses")
    public List<Course> getCourseByStudent(@PathVariable int id){
        return enrollmentService.getCourseByStudentId(id);
    }

    @GetMapping("/course/{id}/students")
    public List<Student> getStudentsByCourse(@PathVariable int id){
        return enrollmentService.getStudentByCourseId(id);
    }
}
