package org.cutm.lms.Lms_Backend.Dto;
import java.util.Set;

import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Course;
import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Entity.Student;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {
    private Long schoolId;
    private String schoolName;
    private String schoolEmail;
    private Student student;
    private Management management;
}

