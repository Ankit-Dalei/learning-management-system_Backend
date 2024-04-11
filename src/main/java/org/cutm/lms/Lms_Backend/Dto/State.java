package org.cutm.lms.Lms_Backend.Dto;

import java.util.Set;

import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Entity.Campus;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {
    private Long stateId;
    private String stateEmail;
    private String statePasswd;
    private Admin admin;
    private Set<Campus> campuses;

}