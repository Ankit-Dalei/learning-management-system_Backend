package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import jakarta.persistence.OneToOne;
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;
    private String branchName;
    @OneToMany
    private Set<Student> students;
    @OneToMany
    private Set<Faculty> faculties;


}
