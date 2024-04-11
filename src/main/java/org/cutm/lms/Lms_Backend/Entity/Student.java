package org.cutm.lms.Lms_Backend.Entity;

import java.util.Set;
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
public class Student {
    @Id
    private String stId;
    private String stName;
    private String stEmail;
    private String stPasswd;
    private String stPhone;
    private String stBranch;
    private String stSection;
    private String stBatch;


}
