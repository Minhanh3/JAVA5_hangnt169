package com.example.Assiment_java5.session03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String fullName;
    private int age;
    private boolean gender;
}
