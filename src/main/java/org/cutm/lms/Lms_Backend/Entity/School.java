package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;
    private String schoolName;
    private String schoolEmail;
    @OneToMany
    private Set<Course> courses;
    @OneToMany
    private Set<Student> students;
    @OneToMany
    private Set<Faculty> faculties;
    @OneToMany
    private Set<Branch> branchList;

    @OneToOne(mappedBy = "school")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "managementId")
    private Management management;
}
