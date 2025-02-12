package com.jaetech.article.controller;

import com.jaetech.article.dto.ArticleCreateRequest;
import com.jaetech.article.dto.ArticleResponse;
import com.jaetech.article.dto.ArticleUpdateRequest;
import com.jaetech.article.entity.Article;
import com.jaetech.article.service.ArticleService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(
            ArticleService articleService
    ) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(
            @PathVariable(name = "id") Long articleId
    ) {
        Article article = articleService.findArticleById(articleId);
        return ResponseEntity.ok(ArticleResponse.toDto(article));
    }

    @PostMapping("")
    public ResponseEntity<Void> addArticle(
            @RequestBody ArticleCreateRequest request
    ) {
        Long articleId = articleService.createArticle(request.toArticle());
        return ResponseEntity.created(URI.create("article/" + articleId)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticle(
            @PathVariable(name = "id") Long articleId,
            @RequestBody ArticleUpdateRequest request
    ) {
        //TODO PARTIAL update OR FULL update
        articleService.updateArticle(articleId,request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(
            @PathVariable("id") Long articleId
    ) {
        articleService.deleteArticleById(articleId);
        return ResponseEntity.ok().build();
    }
}
