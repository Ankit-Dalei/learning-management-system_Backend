package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subadmin")
public class Sub_admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subadminId;
	private String subadminEmail;
	private String subadminPasswd;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
 
	
	
}
