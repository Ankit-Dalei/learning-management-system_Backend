package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentPasswd;
    @OneToMany
    private Set<Course> courses;

    @OneToOne
    @JoinColumn(name = "branchId")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;

}
