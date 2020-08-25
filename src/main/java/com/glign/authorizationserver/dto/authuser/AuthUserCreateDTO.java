package com.glign.authorizationserver.dto.authuser;

import lombok.Data;

@Data
public class AuthUserCreateDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
