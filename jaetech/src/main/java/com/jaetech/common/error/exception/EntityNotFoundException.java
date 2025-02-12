package com.jaetech.common.error.exception;

import com.jaetech.common.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public EntityNotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
