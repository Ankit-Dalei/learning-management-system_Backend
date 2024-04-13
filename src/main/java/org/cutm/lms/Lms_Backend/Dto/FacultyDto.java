package org.cutm.lms.Lms_Backend.Dto;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.UserRole;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyDto {
    private String facultyId;
    private String facultyEmail;
    private String facultyPasswd;
    private String ftName;
    private String ftPhone;
    private String ftBranch;
    private String ftRole;
    private Set<UserRole> roles = new HashSet<>();
}

