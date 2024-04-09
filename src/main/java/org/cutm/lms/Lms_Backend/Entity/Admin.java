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

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private Set<State> states;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPasswd() {
		return adminPasswd;
	}

	public void setAdminPasswd(String adminPasswd) {
		this.adminPasswd = adminPasswd;
	}

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	public Admin() {
	}



}
