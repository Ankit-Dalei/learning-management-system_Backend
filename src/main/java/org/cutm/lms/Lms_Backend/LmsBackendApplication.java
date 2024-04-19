package org.cutm.lms.Lms_Backend;

import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Repository.UserRepository;
import org.cutm.lms.Lms_Backend.Repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Configuration
public class LmsBackendApplication {



	public LmsBackendApplication() {

	}

	@Bean("modelMapper")
  public ModelMapper getModelMappper(){
	  return new ModelMapper();
  }
	public static void main(String[] args) {
		SpringApplication.run(LmsBackendApplication.class, args);
	}





}




