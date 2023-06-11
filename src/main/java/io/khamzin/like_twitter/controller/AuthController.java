package io.khamzin.like_twitter.controller;

import io.khamzin.like_twitter.exception.EmailAlreadyTakenException;
import io.khamzin.like_twitter.exception.UserDoesNotExistException;
import io.khamzin.like_twitter.model.RegistrationObject;
import io.khamzin.like_twitter.model.UserEntity;
import io.khamzin.like_twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<String> handleEmailTaken() {
        return new ResponseEntity<>("The email you provided is already in use", CONFLICT);
    }

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody RegistrationObject ro) {
        return userService.registerUser(ro);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<String> handleUserDoesntExist() {
        return new ResponseEntity<>("The user you are looking for doesn't exist", NOT_FOUND);
    }

    @PutMapping("/update/phone")
    public UserEntity updatePhoneNumber(@RequestBody LinkedHashMap<String, String> body) {
        String username = body.get("username");
        String phone = body.get("phone");
        UserEntity user = userService.getUserByUsername(username);
        user.setPhone(phone);
        return userService.updateUser(user);
    }
}
