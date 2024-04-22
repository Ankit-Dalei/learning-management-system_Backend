package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserMethods {
    @Autowired
    private UserRepo userRepo;

    @Override
    public ApiResponse login(String userId, String password) {
        Optional<User> byUserIdAndUserPasswd = userRepo.findByUserIdAndUserPasswd(userId, password);
        if (byUserIdAndUserPasswd.isPresent()) {
            ApiResponse loginSucessfully = new ApiResponse("login sucessfully", true, HttpStatus.ACCEPTED, byUserIdAndUserPasswd.get());
            return loginSucessfully;
        }else {
            return new ApiResponse("login failed", false, HttpStatus.NOT_FOUND, null);
        }
    }
}
