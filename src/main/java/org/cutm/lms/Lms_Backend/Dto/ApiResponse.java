package org.cutm.lms.Lms_Backend.Dto;

import lombok.*;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    private User user;
}

