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
public class Course {
    @Id
    private String csId;
    private String csName;
    private String csCategory;
    private String csDesc;
    private String csDuration;

}
