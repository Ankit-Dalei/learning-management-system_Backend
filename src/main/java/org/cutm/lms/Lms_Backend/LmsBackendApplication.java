package org.cutm.lms.Lms_Backend;

import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class LmsBackendApplication implements CommandLineRunner {
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(LmsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserRole admin = UserRole.builder().RoleId("01").RoleName("admin").build();
		UserRole management = UserRole.builder().RoleId("02").RoleName("management").build();
		UserRole hod = UserRole.builder().RoleId("03").RoleName("hod").build();
		UserRole faculty = UserRole.builder().RoleId("04").RoleName("faculty").build();
		UserRole student = UserRole.builder().RoleId("99").RoleName("student").build();
		roleRepo.save(admin);
		roleRepo.save(management);
		roleRepo.save(hod);
		roleRepo.save(student);
		roleRepo.save(faculty);


	}
}
