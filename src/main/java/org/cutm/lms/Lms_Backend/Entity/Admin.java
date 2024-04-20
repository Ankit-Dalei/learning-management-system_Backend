package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;
    @Column(nullable = false)
    private String adminFirstName;
    @Column(nullable = false)
    private String  adminLastName;
    @Column(nullable = false)
    private String gender;
    private String address;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
