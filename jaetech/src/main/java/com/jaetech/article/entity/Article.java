package com.jaetech.article.entity;

import com.jaetech.article.exception.ArticleInvalidException;
import com.jaetech.common.BaseTimeEntity;
import com.jaetech.common.error.ErrorCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "articles")
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", updatable = false)
    private Long id;

    @Column(nullable = false, length = 55)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    protected Article() {
    }

    public Article(String title, String content) {
        validate(title, content);
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        validate(title, content);
        this.title = title;
        this.content = content;
    }

    private void validate(String title, String content) {
        if (Objects.isNull(title) || title.isBlank()) {
            throw new ArticleInvalidException(ErrorCode.ARTICLE_REQUIRED_TITLE);
        }

        if (Objects.isNull(content) || content.isBlank()) {
            throw new ArticleInvalidException(ErrorCode.ARTICLE_REQUIRED_CONTENT);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
