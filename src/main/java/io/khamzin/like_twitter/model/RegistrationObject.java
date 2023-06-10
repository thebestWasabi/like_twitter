package io.khamzin.like_twitter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationObject {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
}
