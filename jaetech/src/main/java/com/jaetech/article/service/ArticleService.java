package com.jaetech.article.service;

import com.jaetech.article.dto.ArticleCreateRequest;
import com.jaetech.article.dto.ArticleResponse;
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

    public Long addArticle(ArticleCreateRequest request) {
        Article savedArticle = articleRepository.save(request.toArticle());
        return savedArticle.getId();
    }

    public ArticleResponse findArticleById(Long articleId) {
        Article foundArticle = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException());
        return ArticleResponse.toDto(foundArticle);
    }
}
