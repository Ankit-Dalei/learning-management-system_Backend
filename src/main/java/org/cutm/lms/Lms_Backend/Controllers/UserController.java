package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMethods userMethods;
    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestParam String userid, @RequestParam String password) {
        ApiResponse login = userMethods.login(userid, password);
        return ResponseEntity.ok(login);
    }
}
