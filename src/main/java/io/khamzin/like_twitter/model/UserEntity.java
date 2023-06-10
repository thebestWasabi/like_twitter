package io.khamzin.like_twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "t_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "c_first_name")
    private String firstName;

    @Column(name = "c_last_name")
    private String lastName;

    @Column(name = "c_email", unique = true)
    private String email;

    @Column(name = "c_phone")
    private String phone;

    @Column(name = "c_dob")
    private Date dateOfBirth;

    @Column(name = "c_username", unique = true)
    private String username;

    @Column(name = "c_password")
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_user_role_junction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> authorities;

    public UserEntity() {
        this.authorities = new HashSet<>();
    }
}
