package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long UserId;
        private String UserName;
        private String UserEmail;
        private String UserPasswd;
        //one  to one unidirectional mapping
        @OneToOne(cascade = CascadeType.ALL)
        private UserRole userRole;
        public User(String email,String userPasswd){
            UserEmail = email;
            UserPasswd = userPasswd;
        }
}
