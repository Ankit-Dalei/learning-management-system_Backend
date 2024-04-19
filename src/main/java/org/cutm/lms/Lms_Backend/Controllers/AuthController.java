package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.LoginDto;
import org.cutm.lms.Lms_Backend.Dto.LoginResponseDto;
import org.cutm.lms.Lms_Backend.Dto.RegisterDto;
import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Repository.UserRepository;
import org.cutm.lms.Lms_Backend.Repository.UserRoleRepository;
import org.cutm.lms.Lms_Backend.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class AuthController {

    private UserService userService;
  private UserRoleRepository userRoleRepository;
    public ModelMapper modelMapper;
    private UserRepository userRepository;
    @Autowired
    public AuthController(UserRepository userRepository,ModelMapper modelMapper,UserRoleRepository userRoleRepository,UserService userService){
        this.userRepository = userRepository;
        this.modelMapper =  new ModelMapper();
        this.userRoleRepository = userRoleRepository;
        this.userService = userService;

    }

@PostMapping("/login")
        public ResponseEntity<Set<String>> login(@RequestBody LoginDto loginDto){
Set<String> role =
        userService.login(loginDto);
                return ResponseEntity.ok(role);
        }
        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
      boolean check =  userService.createUserWithRoles(registerDto);
if(check) return ResponseEntity.ok("User Registered Successfully");
else return ResponseEntity.ok("Request terminated Abnormally");
        }
}
