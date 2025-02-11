package com.jaetech.article.controller;

import com.jaetech.article.dto.ArticleCreateRequest;
import com.jaetech.article.dto.ArticleResponse;
import com.jaetech.article.service.ArticleService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/article")
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
        ArticleResponse response = articleService.findArticleById(articleId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addArticle(
            @RequestBody ArticleCreateRequest request
    ) {
        Long articleId = articleService.addArticle(request);
        return ResponseEntity.created(URI.create("article/" + articleId)).build();
    }
}
