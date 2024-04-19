package org.cutm.lms.Lms_Backend.Dto;

import lombok.Data;

@Data
public class RegisterDto {
//    private long userid;
    private String email;
    private String username;
    private String password;
    private String rolename;
}
