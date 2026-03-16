package com.example.CourseProgressTrackingBackend.Service;

import com.example.CourseProgressTrackingBackend.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    List<Course> courses = new ArrayList<>();
    int idCounter = 1;

    public Course createCourse(Course course) {
        course.id = idCounter++;
        courses.add(course);
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.id == id) {
                return c;
            }
        }
        return null;
    }

    public String deleteCourse(int id) {
        for (Course c : courses) {
            if (c.id == id) {
                courses.remove(c);
                return "Course deleted";
            }
        }
        return "Course not found";
    }

}