package com.Tech1.test_task.repository;

import com.Tech1.test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAgeGreaterThan(int age);

    User findByName(String name);

}
