package com.example.CourseProgressTrackingBackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CourseProgressTrackingBackend.Service.ProgressService;
@RestController
@RequestMapping("/progress")
public class ProgressController {
    public final ProgressService progressService;
    public ProgressController(ProgressService progressService){
        this.progressService=progressService;
    }
    @GetMapping("/student/{studentId}/course/{courseId}")
    public int getProgress(@PathVariable int studentId,@PathVariable int courseId) {
        return progressService.calculateProgress(studentId, courseId);
    }
}
