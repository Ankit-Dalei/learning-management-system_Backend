package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    UserDto findByEmailAndPassword(String email, String password);
    Boolean existByEmail(String email);
}
