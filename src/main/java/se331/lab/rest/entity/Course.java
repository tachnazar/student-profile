package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    Long id;
    @ManyToMany
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    List<Student> students = new ArrayList<>();
    @ManyToOne
    @JsonBackReference
    Lecturer lecturer;
//    @ManyToOne
//    @JsonBackReference
//    Admin admin;
    String content;
    String courseId;
    String courseName;
}
