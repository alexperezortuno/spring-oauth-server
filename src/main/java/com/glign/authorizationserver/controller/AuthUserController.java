package com.glign.authorizationserver.controller;

import com.glign.authorizationserver.common.HttpResponseBuilder;
import com.glign.authorizationserver.common.ResponseMessage;
import com.glign.authorizationserver.dto.authuser.AuthUserCreateDTO;
import com.glign.authorizationserver.exception.AuthorizationServerException;
import com.glign.authorizationserver.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthUserController {
    private IAuthUserService userService;

    @Autowired
    public void setUserService(IAuthUserService authUserService) {
        this.userService = authUserService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseMessage> create(@RequestBody AuthUserCreateDTO req) throws AuthorizationServerException {
        return HttpResponseBuilder.buildHttpResponse(this.userService.create(req));
    }
}
