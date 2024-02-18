package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;

import jakarta.persistence.*;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String courseCategory;
}
