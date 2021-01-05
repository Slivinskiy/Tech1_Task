package com.Tech1.test_task;

import com.Tech1.test_task.controller.ArticleController;
import com.Tech1.test_task.controller.UserController;
import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.Color;
import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.repository.UserRepository;
import com.Tech1.test_task.request.CreateArticleRequest;
import com.Tech1.test_task.request.CreateUserRequest;
import com.Tech1.test_task.service.ArticleService;
import com.Tech1.test_task.service.UserService;
import org.apache.catalina.LifecycleState;
import org.h2.command.ddl.CreateUser;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestTaskApplicationTests {


	@Autowired
	private UserController userController;

	@Autowired
	private ArticleController articleController;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ArticleService articleService;


	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	public void create_user_test(){
		CreateUserRequest createUserRequest = new CreateUserRequest();
		createUserRequest.setUsername("Arcadiy");
		createUserRequest.setPassword("newPassword");
		createUserRequest.setConfirmPassword("newPassword");
		createUserRequest.setAge(34);

		ResponseEntity<User> responce = userController.createUser(createUserRequest);
		assertNotNull(responce);
		assertEquals(200, responce.getStatusCodeValue());

		User u = responce.getBody();
		assertNotNull(u);
		assertEquals("Arcadiy", u.getName());
		assertEquals(createUserRequest.getUsername(), u.getName());
		assertTrue(u.getId() > 0);
	}

	@Test
	@Order(2)
	public void find_users_older_than_test(){
		List<User> Users = userController.findOlderThan(30);

		assertNotNull(Users);
		assertEquals(4, Users.size());
		assertTrue(Users.stream().allMatch(user -> user.getAge() > 30));
	}

	@Test
	@Order(3)
	public void find_names_with_more_than_3_articles_test(){
		List<String> names = userController.findNamesWithMoreThan3Articles();

		assertNotNull(names);
		assertTrue(names.stream().allMatch(s -> userRepository.findByName(s).getArticles().size() > 3 ));
		assertEquals(1, names.size());
	}

	@Test
	@Order(4)
	public void create_article_test(){
		CreateUserRequest createUserRequest = new CreateUserRequest();
		createUserRequest.setUsername("Mykola");
		createUserRequest.setPassword("newPassword");
		createUserRequest.setConfirmPassword("newPassword");
		createUserRequest.setAge(20);

		ResponseEntity<User> responceUser = userController.createUser(createUserRequest);

		CreateArticleRequest createArticleRequest = new CreateArticleRequest();
		createArticleRequest.setText("Article for test");
		createArticleRequest.setColor(Color.RED);
		createArticleRequest.setUser_id(userRepository.findByName("Mykola").getId());

		ResponseEntity<Article> responceArticle = articleController.saveArticle(createArticleRequest);
		assertNotNull(responceArticle);
		assertEquals(200, responceArticle.getStatusCodeValue());

		Article a = responceArticle.getBody();
		assertEquals(createArticleRequest.getColor(), a.getColor());
		assertEquals("Article for test", a.getText());
		assertTrue(a.getId() > 0);
	}

	@Test
	@Order(5)
	public void	find_users_by_color(){
		List<Article> byColor = articleController.findAllUsersByColor(Color.BLUE);

		assertNotNull(byColor);
		assertTrue(byColor.stream().allMatch(article -> article.getColor().equals(Color.BLUE)));
		assertEquals(2, byColor.size());
	}


}
