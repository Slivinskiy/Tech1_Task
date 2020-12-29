package com.Tech1.test_task.repository;

import com.Tech1.test_task.entity.Color;
import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

   List<Article> findUsersByColor(Color color);


}
