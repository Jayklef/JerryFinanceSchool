package com.jayklef.JerryFinanceSchool.model;

import lombok.Data;

@Data
public class Contact {

    public String name;
    public String phoneNumber;
    private String email;
    public String subject;
    public String message;

}
