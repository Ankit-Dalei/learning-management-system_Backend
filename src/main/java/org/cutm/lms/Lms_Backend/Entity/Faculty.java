package org.cutm.lms.Lms_Backend.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    private String facultyId;
    private String facultyEmail;
    private String facultyPasswd;
    private String ftName;
    private String ftPhone;
    private String ftBranch;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();


}
