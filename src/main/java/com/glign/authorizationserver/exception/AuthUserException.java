package com.glign.authorizationserver.exception;

import com.glign.authorizationserver.common.ResponseMessage;

import java.util.HashMap;

public class AuthUserException extends AuthorizationServerException {
    public AuthUserException(String message) {
        super(message);
    }

    public AuthUserException(AuthUserCode authUserCode) {
        super(authUserCode.toString());
        responseMessage = new ResponseMessage();
        responseMessage.setStatus((long) authUserCode.getErrorCode());
    }

    private static final HashMap<Integer, String> codeDescription = new HashMap<Integer, String>() {
        {
            put(1000, "ok");
        }
    };

    public enum AuthUserCode {
        AUTH_USER_OK(1000);

        private final int errorCode;

        AuthUserCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }
}
