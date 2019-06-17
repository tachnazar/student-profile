package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SuperBuilder
@Builder
@NoArgsConstructor

public class Admin extends Person {
//    @OneToMany(mappedBy = "admin")
//    @Builder.Default
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonManagedReference
//    Set<Course> courses = new HashSet<>();
//    @OneToMany(mappedBy = "admin")
//    @Builder.Default
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonManagedReference
//    Set<Student> students = new HashSet<>();
}
