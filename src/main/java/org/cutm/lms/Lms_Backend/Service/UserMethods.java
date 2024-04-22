package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;


public interface UserMethods {
    ApiResponse login(String userid, String password);
//    User forgot(String email);
}
