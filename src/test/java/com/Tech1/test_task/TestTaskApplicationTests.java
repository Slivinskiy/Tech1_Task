package com.Tech1.test_task;

import com.Tech1.test_task.controller.ArticleController;
import com.Tech1.test_task.controller.UserController;
import com.Tech1.test_task.entity.Article;
import com.Tech1.test_task.entity.Color;
import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.request.CreateArticleRequest;
import com.Tech1.test_task.request.CreateUserRequest;
import com.Tech1.test_task.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestTaskApplicationTests {


	@Autowired
	private UserController userController;


	@Test
	void contextLoads() {
	}

	@Test
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


}
