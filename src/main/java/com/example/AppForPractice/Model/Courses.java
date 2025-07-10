package com.example.AppForPractice.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@Table(name="COURSE_DTLS")
public class Courses {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String duration;
        private Double price;
        private String imageUrl;
        private String description;
        private String instructor;
}
