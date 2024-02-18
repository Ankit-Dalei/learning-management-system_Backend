package org.cutm.lms.Lms_Backend.Entity;
import jakarta.persistence.*;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;
    private String facultyEmail;
    private String facultyPasswd;
    @OneToOne
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

}
