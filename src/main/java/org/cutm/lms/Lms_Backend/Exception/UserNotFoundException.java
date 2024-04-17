package org.cutm.lms.Lms_Backend.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    // If you want to include the cause of the exception as well


}
