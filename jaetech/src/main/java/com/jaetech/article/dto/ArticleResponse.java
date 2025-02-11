package com.jaetech.article.dto;

import com.jaetech.article.entity.Article;

public record ArticleResponse(
        Long articleId,
        String title,
        String content
) {

    public static ArticleResponse toDto(Article article) {
        return new ArticleResponse(article.getId(), article.getTitle(), article.getContent());
    }
}
