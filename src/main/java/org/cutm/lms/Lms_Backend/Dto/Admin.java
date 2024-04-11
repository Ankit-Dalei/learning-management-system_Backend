package org.cutm.lms.Lms_Backend.Dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Admin {
    private Long adminId;
    private String adminEmail;
    private String adminPasswd;

}

