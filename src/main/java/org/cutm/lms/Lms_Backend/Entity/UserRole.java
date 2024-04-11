package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Designation")
public class UserRole {
    @Id
    private String RoleId;
    private String RoleName;
}
