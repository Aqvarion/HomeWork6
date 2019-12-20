package com.blackapple.hw.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String middleName;

    @NotEmpty
    private int age;

    @NotEmpty
    private double salary;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String workPlace;
}
