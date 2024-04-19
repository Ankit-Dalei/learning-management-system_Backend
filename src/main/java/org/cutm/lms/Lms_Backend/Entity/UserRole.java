package org.cutm.lms.Lms_Backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long RoleId;
    private String RoleName;
@ManyToMany(mappedBy = "roles")
    private Set<User> users;
    public UserRole(String roleName){
        RoleName = roleName;
    }
}
