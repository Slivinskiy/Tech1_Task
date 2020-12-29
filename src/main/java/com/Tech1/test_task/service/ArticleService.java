package com.Tech1.test_task.service;

import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.Color;
import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.repository.ArticleRepository;
import com.Tech1.test_task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;


    public Article saveArticle(Article article) {

        Article returnedArticle = articleRepository.save(article);
        User user = returnedArticle.getUser();
        user.addArticle(returnedArticle);
        userRepository.save(user);
        return returnedArticle;

    }

    public List<Article> findUsersWithColor(Color color){

        return articleRepository.findUsersByColor(color);

    }

    public Article getArticle(Long id) {
        return articleRepository.getOne(id);
    }




}
