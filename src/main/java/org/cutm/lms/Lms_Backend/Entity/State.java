package org.cutm.lms.Lms_Backend.Entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stateId;
	private String stateEmail;
	private String statePasswd;
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private Set<Campus> campuses = new HashSet<Campus>();
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getStateEmail() {
		return stateEmail;
	}
	public void setStateEmail(String stateEmail) {
		this.stateEmail = stateEmail;
	}
	public String getStatePasswd() {
		return statePasswd;
	}
	public void setStatePasswd(String statePasswd) {
		this.statePasswd = statePasswd;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Set<Campus> getCampuses() {
		return campuses;
	}
	public void setCampuses(Set<Campus> campuses) {
		this.campuses = campuses;
	}
	public State() {}
	public State(Long stateId, String stateEmail, String statePasswd, Admin admin, Set<Campus> campuses) {

		this.stateId = stateId;
		this.stateEmail = stateEmail;
		this.statePasswd = statePasswd;
		this.admin = admin;
		this.campuses = campuses;
	}
   
} 
