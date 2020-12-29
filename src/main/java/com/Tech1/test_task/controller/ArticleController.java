package com.Tech1.test_task.controller;


import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.Color;
import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.request.CreateArticleRequest;
import com.Tech1.test_task.service.ArticleService;
import com.Tech1.test_task.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;



    @PostMapping("/save")
    public ResponseEntity <Article> saveArticle(@RequestBody CreateArticleRequest createArticleRequest){

        Article article = new Article();

        article.setText(createArticleRequest.getText());

        article.setColor(createArticleRequest.getColor());

        User user = userService.getUserById(createArticleRequest.getUser_id());
        article.setUser(user);

        articleService.saveArticle(article);

        return ResponseEntity.ok(article);
    }




    @GetMapping("/color/{color}")
    public List<Article> findAllUsersByColor(@PathVariable Color color){

        return articleService.findUsersWithColor(color);

    }







}
