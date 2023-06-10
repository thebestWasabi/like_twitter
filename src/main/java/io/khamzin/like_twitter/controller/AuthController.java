package io.khamzin.like_twitter.controller;

import io.khamzin.like_twitter.exception.EmailAlreadyTakenException;
import io.khamzin.like_twitter.model.RegistrationObject;
import io.khamzin.like_twitter.model.UserEntity;
import io.khamzin.like_twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<String> handleEmailTaken() {
        return new ResponseEntity<>("The email you provided is already in use", HttpStatus.CONFLICT);
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody RegistrationObject ro) {
        return userService.registerUser(ro);
    }
}
