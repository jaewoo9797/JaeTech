package com.jaetech.article.dto;

public record ArticleUpdateRequest(
        String title,
        String content
) {
}
