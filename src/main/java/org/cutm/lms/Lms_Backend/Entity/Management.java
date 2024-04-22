package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Management {
    @Id
    private String mtId;
    private String mtName;
    private String mtEmail;
    private String mtPasswd;
    private String mtPhone;
    private String universityName;
    private LocalDate dateCreated;


//    I'd
//    Email
//            Password
//    Name
//            Phone
//    Role field predefined
//    University name
//    Date
}

