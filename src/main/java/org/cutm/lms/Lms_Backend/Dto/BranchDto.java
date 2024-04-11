package org.cutm.lms.Lms_Backend.Dto;


import java.util.Set;

import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Entity.Student;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchDto {
    private String branchId;
    private String branchName;
    private Set<Student> students;
    private Set<Faculty> faculties;
}
