package com.nishant.newsportal.model;


import com.nishant.newsportal.annotation.FieldsMatching;
import com.nishant.newsportal.annotation.PasswordValidators;
import com.nishant.newsportal.baseModel.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@FieldsMatching.List({
        @FieldsMatching(
                field = "password",
                fieldMatch = "confirmPassword",
                message = "Confirm-Password did not matched!"
        )
})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;


    @NotBlank(message = "Please provide your first-name!")
    @Size(min = 3, message = "First-Name must be 3 character long.")
    private String firstName;


    @NotBlank(message = "Please provide your last-name!")
    @Size(min = 3, message = "Last-Name must be 3 character long.")
    private String lastName;

    @NotBlank(message = "Email must be filled!")
    @Email(message = "Please provide a valid email address!")
    private String email;


    @NotBlank(message = "Please provide phone-number!")
    @Pattern(regexp = "^(?:\\+977|977)?9[78]\\d{8}$", message = "Please provide valid phone number!")
    private String phoneNumber;

    @NotBlank(message = "Password must be filled!")
    @Size(min = 5, message = "Password must be 5 character long")
    @PasswordValidators
    private String password;

    @NotBlank(message = "Please fill the confirm-password!")
    @Size(min = 5, message = "Confirm Password must be 5 character long!")
    @Transient
    private String confirmPassword;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id" , referencedColumnName ="user_id" ),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> userRoles = new HashSet<>();

}
