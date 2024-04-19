package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Dto.LoginDto;
import org.cutm.lms.Lms_Backend.Dto.RegisterDto;
import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Optional<User> findByEmail(String email);
    UserDto findByEmailAndPassword(String email, String password);
    Boolean existByEmail(String email);
    boolean createUserWithRoles(RegisterDto registerDto);
    Set<String> login(LoginDto loginDto);
}
