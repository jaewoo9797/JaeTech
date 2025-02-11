package com.jaetech.common.error;

public enum ErrorCode {
    NOT_FOUND(404, "해당하는 정보는 없습니다."),
    ;

    private final int status;
    private final String description;

    ErrorCode(int status, String description) {
        this.description = description;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
