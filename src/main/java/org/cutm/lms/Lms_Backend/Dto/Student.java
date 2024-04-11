package org.cutm.lms.Lms_Backend.Dto;
import java.util.Set;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Course;
import org.cutm.lms.Lms_Backend.Entity.School;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentPasswd;
    private Branch branch;
    private School school;
}

