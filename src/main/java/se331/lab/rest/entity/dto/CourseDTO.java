package se331.lab.rest.entity.dto;

import lombok.Builder;
import lombok.Data;
import se331.lab.rest.entity.Course;

@Builder
@Data
public class CourseDTO {
    Long id;
    String courseName;
    String courseId;
    String content;
    LecturerDTO lecturer;

    public static CourseDTO getCourseListDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseId(course.getCourseId())
                .content(course.getContent())
                .lecturer(LecturerDTO.getLecturerDTO(course.getLecturer()))
                .build();


    }

    public Course getCourse() {
        return Course.builder()
                .id(this.id)
                .courseName(this.courseName)
                .courseId(this.courseId)
                .content(this.content)
                .lecturer(this.lecturer.getLecturer())
                .build();
    }
}
