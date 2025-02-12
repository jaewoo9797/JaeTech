package com.jaetech.article.service;

import com.jaetech.article.dto.ArticleUpdateRequest;
import com.jaetech.article.entity.Article;
import com.jaetech.article.repository.ArticleRepository;
import com.jaetech.common.error.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(
            ArticleRepository articleRepository
    ) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public Long createArticle(Article article) {
        Article savedArticle = articleRepository.save(article);
        return savedArticle.getId();
    }

    public Article findArticleById(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void updateArticle(Long articleId, ArticleUpdateRequest request) {
        Article foundArticle = articleRepository.findById(articleId)
                .orElseThrow(EntityNotFoundException::new);
        foundArticle.update(request.title(),request.content());
    }

    @Transactional
    public void deleteArticleById(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
