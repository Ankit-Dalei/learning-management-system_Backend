package org.cutm.lms.Lms_Backend.Dto;
import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Entity.State;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campus {
    private Long campusId;
    private String campusName;
    private String campusEmail;
    private String campusPasswd;
    private State state;
    private Management management;
}
