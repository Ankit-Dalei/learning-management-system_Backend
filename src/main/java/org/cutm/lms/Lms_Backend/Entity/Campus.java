package org.cutm.lms.Lms_Backend.Entity;

import jakarta.persistence.*;

@Entity
public class Campus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long campusId;
	private String campusName;
	private String campusEmail;
	private String campusPasswd;
	@ManyToOne
	@JoinColumn(name = "stateId")
	private State state;
	@OneToOne
	private Management management;
}
