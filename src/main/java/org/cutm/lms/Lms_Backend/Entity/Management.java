package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managementId;
    private String managementEmail;
    private String managementPasswd;
    @OneToMany
    private Set<School> schools;
    @OneToOne
    private Campus campus;
}
