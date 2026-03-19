package com.example.CourseProgressTrackingBackend.Service;

import com.example.CourseProgressTrackingBackend.Model.Course;
import com.example.CourseProgressTrackingBackend.Model.Progress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProgressService {
    @Autowired
    CourseService courseService;

    List<Progress> progressList = new ArrayList<>();
    int idCounter = 1;

    public Progress updateProgress(Progress progress) {
        for (Progress p : progressList) {
            if (p.studentId == progress.studentId &&
                    p.courseId == progress.courseId) {
                p.completedModules = progress.completedModules;
                return p;
            }
        }
        progress.id = idCounter++;
        progressList.add(progress);

        return progress;
    }

    public int calculateProgress(int studentId, int courseId) {

        for (Progress p : progressList) {

            if (p.studentId == studentId && p.courseId == courseId) {

                Course c = courseService.getCourseById(courseId);

                if (c != null && c.totalModules != 0) {

                    return (p.completedModules * 100) / c.totalModules;
                }
            }
        }

        return 0;
    }
}
