package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.LoginDto;
import org.cutm.lms.Lms_Backend.Dto.RegisterDto;
import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Exception.UserNotFoundException;
import org.cutm.lms.Lms_Backend.Repository.UserRepository;
import org.cutm.lms.Lms_Backend.Repository.UserRoleRepository;
import org.cutm.lms.Lms_Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
  private UserRoleRepository userRoleRepository;
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserRoleRepository userRoleRepository) {
        super();
        this.userRepository= userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByUserEmailAndPassword(email,password);
        return null;
    }

    @Override
    public Boolean existByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public boolean createUserWithRoles(RegisterDto registerDto) {
        if(registerDto != null){
            //getting the Role
            UserRole role = userRoleRepository.findByRoleName(registerDto.getRolename());
            //creating a Set object of role
            Set<UserRole> roles = new HashSet<>();
            //adding extracted role object into Set object
            roles.add(role);
            //creating the user object
            User user = new User(
                    registerDto.getEmail(),
                    registerDto.getPassword(),
                    registerDto.getUsername(),
                    roles
            );
//            User user = new User();
//            user.setUserEmail(registerDto.getEmail());
//            user.setUserPasswd(registerDto.getPassword());
//            user.setUserName(registerDto.getUsername());
//            user.setRoles(roles);
            userRepository.save(user);

            return true;
        }else{
            return false;
        }

    }

    @Override
    public Set<String> login(LoginDto loginDto) {
        User user = userRepository.findByUserEmailAndPassword(loginDto.getUsernameOrEmail(), loginDto.getPassword());
//       Set<UserRole> roles= user.getRoles();
//        return roles;
        if(user != null){
            return user.getRoles().stream().map(UserRole::getRoleName).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
