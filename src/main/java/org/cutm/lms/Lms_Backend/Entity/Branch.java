package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

//import jakarta.persistence.OneToOne;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Branch {
    @Id
    private String branchId;
    private String branchName;
    @OneToMany
    private Set<Student> students;
    @OneToMany
    private Set<Faculty> faculties;


}
