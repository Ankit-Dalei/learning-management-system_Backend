package org.cutm.lms.Lms_Backend.Dto;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.School;
import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Management {
    private Long managementId;
    private String managementEmail;
    private String managementPasswd;
    private Set<School> schools;

}

