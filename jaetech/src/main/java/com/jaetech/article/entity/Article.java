package com.jaetech.article.entity;

import com.jaetech.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "article")
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articles_id", updatable = false)
    private Long id;

    @Column(nullable = false, length = 55)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    protected Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    private void validate(String title, String content) {
        if (Objects.isNull(title) || title.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (Objects.isNull(content) || content.isBlank()) {
            throw new IllegalArgumentException();
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
