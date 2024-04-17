package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.UserDto;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Exception.UserNotFoundException;
import org.cutm.lms.Lms_Backend.Repository.UserRepository;
import org.cutm.lms.Lms_Backend.Service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl() {
        super();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByUserEmailAndPassword(email,password);
        return new UserDto(user.getUserEmail(),user.getUserName(),user.getUserRole());
    }

    @Override
    public Boolean existByEmail(String email) {
        return null;
    }
}
