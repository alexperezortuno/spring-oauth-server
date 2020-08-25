package com.glign.authorizationserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "auth_user")
public class AuthUser extends BaseEntity<AuthUser> {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;
}
