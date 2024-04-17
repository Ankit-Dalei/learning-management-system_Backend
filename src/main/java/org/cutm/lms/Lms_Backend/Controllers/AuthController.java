package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.LoginDto;
import org.cutm.lms.Lms_Backend.Dto.LoginResponseDto;
import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Repository.UserRepository;
import org.cutm.lms.Lms_Backend.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/login")
@RestController
@CrossOrigin("*")
public class AuthController {

    public ModelMapper modelMapper;
    private UserRepository userRepository;
    @Autowired
    public AuthController(UserRepository userRepository,ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper =  new ModelMapper();
    }


@PostMapping
        public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
//                System.out.println(loginDto.getUsernameOrEmail());
//                userService.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail());
//              UserDto userDto = new UserDto();
//              userDto.setUserEmail(loginDto.getUsernameOrEmail());
//              userDto.setUserPasswd(loginDto.getPassword());
        User user = userRepository.findByUserEmailAndPassword(loginDto.getUsernameOrEmail(), loginDto.getPassword());

//      UserDto userDto = modelMapper.map(user,UserDto.class);
        // Use the user object

//           UserDto userDto = new UserDto();
//           userDto.setUserRole(user.getUserRole());
           LoginResponseDto loginDto1 = new LoginResponseDto();
           loginDto1.setRole(user.getUserRole());

                return ResponseEntity.ok(loginDto1);
        }
}
