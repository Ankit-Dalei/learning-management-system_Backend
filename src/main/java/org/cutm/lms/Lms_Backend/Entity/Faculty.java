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
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;
    private String facultyEmail;
    private String facultyPasswd;
    private String ftName;
    private String ftPhone;
    private String ftBranch;
    private String ftRole;


}
