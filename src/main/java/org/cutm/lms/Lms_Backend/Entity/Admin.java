package org.cutm.lms.Lms_Backend.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
//	@GenericGenerator(name = "UUID", strategy = "org.cutm.lms.Lms_Backend.CustomIdGenerator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	private String adminEmail;
	private String adminPasswd;

}
