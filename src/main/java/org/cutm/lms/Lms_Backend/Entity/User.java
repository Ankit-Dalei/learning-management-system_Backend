package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


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
         @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
         @JoinTable(
                 name = "user_roles",
                 joinColumns = @JoinColumn(name="user_id"),
                 inverseJoinColumns = @JoinColumn(name = "role_id")
         )
        private Set<UserRole> roles;

//one to one mapping with Admins
//    @OneToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;
        public User(String email,String userPasswd){
            UserEmail = email;
            UserPasswd = userPasswd;
        }
        public User(String userEmail,String userPasswd,String userName,Set<UserRole> role){
            UserEmail = userEmail;
            UserPasswd  = userPasswd;
            UserName = userName;
            roles = role;
        }

}
