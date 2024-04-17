package org.cutm.lms.Lms_Backend.Dto;

import lombok.Data;
import org.cutm.lms.Lms_Backend.Entity.UserRole;

@Data
public class UserDto {
    private long UserId;
    private String UserName;
    private String UserEmail;
    private String UserPasswd;
    private UserRole userRole;

    public UserDto(String userEmail, String userName, UserRole userRole) {
        UserEmail = userEmail;
        UserName = userName;
        this.userRole = userRole;
    }

    public UserDto() {

    }
}
