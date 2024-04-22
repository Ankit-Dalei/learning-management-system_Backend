package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Entity.User;


public interface UserMethods {
    ApiResponse login(String userid, String password);
    ApiResponse forgot(String email, String password);
}
