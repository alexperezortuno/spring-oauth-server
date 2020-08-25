package com.glign.authorizationserver.common;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    private Long status;
    private String message;
    private T data;
}
