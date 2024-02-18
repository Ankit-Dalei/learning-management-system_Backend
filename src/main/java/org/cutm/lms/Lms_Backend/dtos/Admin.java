package org.cutm.lms.Lms_Backend.dtos;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.State;
import org.cutm.lms.Lms_Backend.Entity.Sub_admin;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Admin {
    private Long adminId;
    private String adminEmail;
    private String adminPasswd;
    private Set<Sub_admin> subadmins;
    private Set<State> states;
}
