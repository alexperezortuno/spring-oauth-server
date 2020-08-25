package com.glign.authorizationserver.common;

public enum ResponseCode {

    SUCCESSFUL(0L),
    CREATED(1L),
    NOT_DATA_FOUND(-1L),
    PRECONDITION_REQUERID(-2L),
    GENERAL_ERROR(-3L);
    private final Long status;

    ResponseCode(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

}
