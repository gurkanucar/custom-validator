package com.gucardev.customvalidator.service;

import com.gucardev.customvalidator.dto.CreateArticleRequest;
import com.gucardev.customvalidator.model.Article;
import com.gucardev.customvalidator.model.User;
import com.gucardev.customvalidator.repository.ArticleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  private final ArticleRepository articleRepository;
  private final UserService userService;

  public ArticleService(ArticleRepository articleRepository, UserService userService) {
    this.articleRepository = articleRepository;
    this.userService = userService;
  }

  public List<Article> getAllArticles() {
    return articleRepository.findAll();
  }

  public Optional<Article> getArticleById(Long id) {
    return articleRepository.findById(id);
  }

  public Article createArticle(CreateArticleRequest request) {
    //    Long userId = request.getUserId();
    //    User user =
    //        userService
    //            .getUserById(userId)
    //            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

    Article article = new Article();
    BeanUtils.copyProperties(request, article, "userId");
    User user = new User();
    user.setId(request.getUserId());
    article.setUser(user);

    //    article.setUser(user);

    return articleRepository.save(article);
  }

  public Article updateArticle(Long id, Article updatedArticle) {
    Optional<Article> optionalArticle = articleRepository.findById(id);
    if (optionalArticle.isPresent()) {
      Article address = optionalArticle.get();
      BeanUtils.copyProperties(updatedArticle, address, "id", "createdDate", "lastModifiedDate");
      return articleRepository.save(address);
    } else {
      throw new IllegalArgumentException("Article not found with id: " + id);
    }
  }

  public void deleteArticle(Long id) {
    articleRepository.deleteById(id);
  }
}
