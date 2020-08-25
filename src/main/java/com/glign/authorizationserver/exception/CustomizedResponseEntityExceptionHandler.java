package com.glign.authorizationserver.exception;

import com.glign.authorizationserver.common.ResponseCode;
import com.glign.authorizationserver.common.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InternalServerException.class)
    public final ResponseEntity<ResponseMessage> handleAllExceptions(InternalServerException ex, WebRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(ResponseCode.GENERAL_ERROR.getStatus());
        responseMessage.setMessage(ex.getMessage());

        return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ResponseMessage> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(ResponseCode.NOT_DATA_FOUND.getStatus());
        responseMessage.setMessage(ex.getMessage());

        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ResponseMessage> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(ResponseCode.PRECONDITION_REQUERID.getStatus());
        responseMessage.setMessage(ex.getMessage());

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthUserException.class)
    public ResponseEntity<ResponseMessage> authUserExceptionHandler(AuthUserException e, HttpServletRequest request) {
        return e.getResponseEntity();
    }
}
