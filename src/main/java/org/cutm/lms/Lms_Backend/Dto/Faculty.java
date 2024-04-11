package org.cutm.lms.Lms_Backend.Dto;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Course;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Faculty {
    private Long facultyId;
    private String facultyEmail;
    private String facultyPasswd;
    private Branch branch;
    private Course course;
}

