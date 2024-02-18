package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	private String adminEmail;
	private String adminPasswd;

//	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//	private Set<Sub_admin> subadmins;

	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private Set<State> states;

}
