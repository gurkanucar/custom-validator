package com.gucardev.customvalidator.repository;

import com.gucardev.customvalidator.model.Article;
import com.gucardev.customvalidator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {}
