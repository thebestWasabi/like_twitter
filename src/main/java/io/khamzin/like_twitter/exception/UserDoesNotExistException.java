package io.khamzin.like_twitter.exception;

import java.io.Serial;

public class UserDoesNotExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserDoesNotExistException() {
        super("The user you are looking for does not exist");
    }

}
