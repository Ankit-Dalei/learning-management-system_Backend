package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.FacultyRepo;
import org.cutm.lms.Lms_Backend.Repository.StudentRepo;
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

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private FacultyRepo facultyRepo;

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

    @Override
    public ApiResponse forgot(String email,String password) {
        Optional<User> byUserEmail = userRepo.findByUserEmail(email);
        if (byUserEmail.isPresent()) {
            User user = byUserEmail.get();
            user.setUserPasswd(password);
            User save = userRepo.save(user);
            String userId = save.getUserId();
            String substring = userId.substring(0, 2);
//            System.out.println(substring);
            if(substring.equals("ST")) {
                Student stud = studentRepo.findById(userId).orElseThrow(
                        ()->new ResourceNotFound("Student","id",userId));
                stud.setStPasswd(save.getUserPasswd());
                studentRepo.save(stud);
            }else{
                Faculty find=facultyRepo.findById(userId).orElseThrow(
                        ()->new ResourceNotFound("Faculty","id",userId));
//                System.out.println(find);
                find.setFacultyPasswd(save.getUserPasswd());
                facultyRepo.save(find);
            }

            return new ApiResponse("Updated Successfully", true, HttpStatus.ACCEPTED, save);
        } else {
            ApiResponse userNotPresent = ApiResponse.builder()
                    .message("user not present")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
            return userNotPresent;
        }
    }
}
