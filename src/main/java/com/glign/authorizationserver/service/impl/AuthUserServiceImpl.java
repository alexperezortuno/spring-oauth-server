package com.glign.authorizationserver.service.impl;

import com.glign.authorizationserver.common.ResponseMessage;
import com.glign.authorizationserver.dto.authuser.AuthUserCreateDTO;
import com.glign.authorizationserver.exception.AuthorizationServerException;
import com.glign.authorizationserver.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements IAuthUserService {
    private IAuthUserService authUserService;

    @Autowired
    private void setAuthUserService(IAuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @Override
    public ResponseMessage create(AuthUserCreateDTO user) throws AuthorizationServerException {
        try {
            ResponseMessage responseMessage = new ResponseMessage();
            return responseMessage;
        } catch (Exception e) {
            throw new AuthorizationServerException("Exception");
        }
    }
}
