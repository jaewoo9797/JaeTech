package com.jaetech.article.service;

import com.jaetech.article.entity.Article;
import com.jaetech.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(
        ArticleRepository articleRepository
    ) {
        this.articleRepository = articleRepository;
    }

    public void write() {
        Article createdArticle = new Article("test", "test");
        articleRepository.save(createdArticle);
    }
}
