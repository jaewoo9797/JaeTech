package com.jaetech.article.exception;

import com.jaetech.common.error.ErrorCode;
import com.jaetech.common.error.exception.EntityNotFoundException;

public class ArticleNotFound extends EntityNotFoundException {

    public ArticleNotFound(ErrorCode errorCode) {
        super(errorCode);
    }
}
