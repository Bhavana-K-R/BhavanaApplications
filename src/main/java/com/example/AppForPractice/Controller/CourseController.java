
package com.example.AppForPractice.Controller;
import com.example.AppForPractice.Model.Courses;
import com.example.AppForPractice.Service.CoursesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CoursesService coursesService;

    public CourseController(CoursesService service) {
        this.coursesService = service;
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Courses getCourse(@PathVariable Long id) {
        return coursesService.getCourseById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Courses createCourse(@ModelAttribute Courses course,@ModelAttribute MultipartFile image) throws IOException {
        return coursesService.createCourse(course,image);
    }

    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable Long id, @ModelAttribute Courses course, @ModelAttribute MultipartFile image) throws IOException {
        return coursesService.updateCourse(id, course, image);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
    }


}

