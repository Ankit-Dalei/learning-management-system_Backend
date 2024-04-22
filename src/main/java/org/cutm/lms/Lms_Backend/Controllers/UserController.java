package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMethods userMethods;
    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestParam String userid, @RequestParam String password) {
        ApiResponse login = userMethods.login(userid, password);
        return ResponseEntity.ok(login);
    }
    @PostMapping()
    public ResponseEntity<?>forgetPassword(@RequestParam String email, @RequestParam String password) {
        ApiResponse forgot = userMethods.forgot(email,password);
        return ResponseEntity.ok(forgot);

    }
}
