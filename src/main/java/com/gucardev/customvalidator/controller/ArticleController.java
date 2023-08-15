package com.gucardev.customvalidator.controller;

import com.gucardev.customvalidator.dto.CreateArticleRequest;
import com.gucardev.customvalidator.model.Article;
import com.gucardev.customvalidator.service.ArticleService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping
  public List<Article> getAllArticles() {
    return articleService.getAllArticles();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
    Optional<Article> user = articleService.getArticleById(id);
    return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Article> createArticle(@RequestBody CreateArticleRequest request) {
    Article createdArticle = articleService.createArticle(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Article> updateArticle(
      @PathVariable Long id, @RequestBody Article updatedArticle) {
    Article user = articleService.updateArticle(id, updatedArticle);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
    articleService.deleteArticle(id);
    return ResponseEntity.noContent().build();
  }
}
