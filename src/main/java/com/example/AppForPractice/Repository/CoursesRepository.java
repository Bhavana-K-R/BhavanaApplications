package com.example.AppForPractice.Repository;
import com.example.AppForPractice.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
    public interface CoursesRepository extends JpaRepository<Courses, Long> {
    }


