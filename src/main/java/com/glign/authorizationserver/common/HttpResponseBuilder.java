package com.glign.authorizationserver.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class HttpResponseBuilder {

    private HttpResponseBuilder(){}

    public static ResponseEntity<ResponseMessage> buildHttpResponse(ResponseMessage responseMessage){

        if(responseMessage.getStatus().equals(ResponseCode.SUCCESSFUL.getStatus())){
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else if(responseMessage.getStatus().equals(ResponseCode.CREATED.getStatus())){
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        }else if(responseMessage.getStatus().equals(ResponseCode.NOT_DATA_FOUND.getStatus())){
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        }else if(responseMessage.getStatus().equals(ResponseCode.PRECONDITION_REQUERID.getStatus())){
            return new ResponseEntity<>(responseMessage, HttpStatus.PRECONDITION_REQUIRED);
        }else if(responseMessage.getStatus().equals(ResponseCode.GENERAL_ERROR.getStatus())){
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(responseMessage, HttpStatus.PRECONDITION_REQUIRED);
        }
    }
}
