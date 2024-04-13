package org.cutm.lms.Lms_Backend.Dto;
import java.util.HashSet;
import java.util.Set;

import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.UserRole;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private String stId;
    private String stName;
    private String stEmail;
    private String stPasswd;
    private String stPhone;
    private String stBranch;
    private String stSection;
    private String stBatch;
    private Set<UserRole> roles = new HashSet<>();
}

