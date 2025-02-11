package com.jaetech.article.dto;

import com.jaetech.article.entity.Article;
import jakarta.validation.constraints.NotBlank;

public record ArticleCreateRequest(
        @NotBlank String title,
        @NotBlank String content
) {

    public Article toArticle() {
        return new Article(title, content);
    }
}
