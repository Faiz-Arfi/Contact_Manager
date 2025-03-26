package com.contactmanager.contactmanager.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.contactmanager.contactmanager.entities.User;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @Size(min = 3, max = 20, message = "Name must be between 3 to 20 characters")
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter a valid email")
    private String email;
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password must contain 1 uppercase, 1 lowercase, 1 digit and 1 special character")
    @Size(min = 6, message = "Password must be atleast 6 characters")
    private String password;
    private String about;
    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAbout(about);
        user.setProfilePic("/images/default-profile-pic.svg");
        return user;
    }
}
