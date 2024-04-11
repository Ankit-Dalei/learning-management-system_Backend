package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
        @Id
        private String UserId;
        private String UserEmail;
        private String UserPasswd;

//        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//        private Set<UserRole> roles = new HashSet<>();


}
