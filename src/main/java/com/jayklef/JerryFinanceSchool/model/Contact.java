package com.jayklef.JerryFinanceSchool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be 3 or more character")
    public String name;

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 11 digits")
    public String phoneNumber;

    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Subject cannot be blank")
    public String subject;

    @NotBlank(message = "Message cannot be blank")
    @Size(min = 5, message = "Message mast have above 5 characters")
    public String message;

}
