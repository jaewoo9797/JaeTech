package com.jaetech.common.error;

public enum ErrorCode {
    NOT_FOUND(404, "해당하는 정보는 없습니다."),

    ARTICLE_REQUIRED_TITLE(400, "게시글 제목은 필수값 입니다."),
    ARTICLE_REQUIRED_CONTENT(400, "게시글 본문은 필수값 입니다."),
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
