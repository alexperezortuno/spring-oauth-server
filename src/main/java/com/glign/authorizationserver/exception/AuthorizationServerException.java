package com.glign.authorizationserver.exception;

import com.glign.authorizationserver.common.HttpResponseBuilder;
import com.glign.authorizationserver.common.ResponseMessage;
import org.springframework.http.ResponseEntity;

public class AuthorizationServerException extends Exception {
    ResponseMessage responseMessage;

    public AuthorizationServerException(String message) {
        super(message);
    }

    public AuthorizationServerException(ResponseMessage responseMessage) {
        super(String.valueOf(responseMessage.getStatus()));
    }

    public ResponseEntity getResponseEntity() {
        return HttpResponseBuilder.buildHttpResponse(this.responseMessage);
    }
}
