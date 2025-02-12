package com.jaetech.article.exception;

import com.jaetech.common.error.ErrorCode;
import com.jaetech.common.error.exception.BusinessException;

public class ArticleInvalidException extends BusinessException {

    public ArticleInvalidException(ErrorCode errorCode) {
        super(errorCode);
    }
}
