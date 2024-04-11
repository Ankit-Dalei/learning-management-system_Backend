package org.cutm.lms.Lms_Backend.Dto;
import java.util.Set;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Faculty;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private String courseId;
    private String courseName;
    private String courseCategory;
    private Set<Faculty> faculty;
}

