package org.cutm.lms.Lms_Backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class LmsBackendApplication {

  @Bean("modelMapper")
  public ModelMapper getModelMappper(){
	  return new ModelMapper();
  }
	public static void main(String[] args) {
		SpringApplication.run(LmsBackendApplication.class, args);
	}
}




