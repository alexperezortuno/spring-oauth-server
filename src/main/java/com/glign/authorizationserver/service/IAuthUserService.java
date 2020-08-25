package com.glign.authorizationserver.service;

import com.glign.authorizationserver.common.ResponseMessage;
import com.glign.authorizationserver.dto.authuser.AuthUserCreateDTO;
import com.glign.authorizationserver.exception.AuthorizationServerException;

public interface IAuthUserService {
    ResponseMessage create(AuthUserCreateDTO user) throws AuthorizationServerException;
}
