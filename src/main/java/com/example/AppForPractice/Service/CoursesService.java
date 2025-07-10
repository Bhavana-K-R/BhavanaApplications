
package com.example.AppForPractice.Service;
import com.example.AppForPractice.Model.Courses;
import com.example.AppForPractice.Repository.CoursesRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CoursesService {

        private final CoursesRepository coursesRepository;
        private final S3Service s3Service;

        public CoursesService(CoursesRepository repository, S3Service s3Service) {
            this.coursesRepository = repository;
            this.s3Service = s3Service;
        }

        public List<Courses> getAllCourses() {
            return coursesRepository.findAll();
        }

        public Courses getCourseById(Long id) {
            return coursesRepository.findById(id).orElse(null);
        }

        public Courses createCourse(Courses course, MultipartFile image) throws IOException {
            String imageUrl = s3Service.uploadFile(image);
            course.setImageUrl(imageUrl);
            return coursesRepository.save(course);
        }

        public Courses updateCourse(Long id, Courses updatedCourse,  MultipartFile image) throws IOException {
            String imageUrl = s3Service.uploadFile(image);
            updatedCourse.setImageUrl(imageUrl);
            return coursesRepository.findById(id).map(course -> {
                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                course.setInstructor(updatedCourse.getInstructor());
                course.setDuration(updatedCourse.getDuration());
                course.setPrice(updatedCourse.getPrice());
                course.setImageUrl(updatedCourse.getImageUrl());
                return coursesRepository.save(course);
            }).orElse(null);
        }

        public void deleteCourse(Long id) {
            coursesRepository.deleteById(id);
        }


}

