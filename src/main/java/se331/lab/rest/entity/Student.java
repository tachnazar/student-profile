package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    String studentId;
    Double gpa;
    String image;
    Integer penAmount;
    String description;
    @ManyToMany(mappedBy = "students")
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    Set<Course> enrolledCourses = new HashSet<>();
    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    Lecturer advisor;
//    @ManyToOne
//    @ToString.Exclude
//    @JsonBackReference
//    Admin admin;


}