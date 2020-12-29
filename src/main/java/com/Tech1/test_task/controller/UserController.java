package com.Tech1.test_task.controller;

import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.request.CreateUserRequest;
import com.Tech1.test_task.service.ArticleService;
import com.Tech1.test_task.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getUsername());

        user.setAge(createUserRequest.getAge());

        Article article = new Article();
        List <Article> articles = new ArrayList<>();
        articles.add(article);
        user.setArticles(articles);

        user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));

        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/age/{age}")
    public List<User> findOlderThan(@PathVariable int age){
        return userService.findUsersOlderThan(age);
    }

    @GetMapping("/articles")
    public List<String> findNamesWithMoreThan3Articles(){

        List<User> allUsers = userService.findAllUsers();

        List<User> filtered =  allUsers.stream()
                .filter(user -> user.getArticles().size() > 3)
                .collect(Collectors.toList());

        List<String> names = new ArrayList<>();

        for(User user : filtered){
           names.add(user.getName());
        }

        return names;
    }

}
