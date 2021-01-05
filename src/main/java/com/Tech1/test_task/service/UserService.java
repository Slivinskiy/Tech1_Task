package com.Tech1.test_task.service;

import com.Tech1.test_task.entity.User;
import com.Tech1.test_task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

    public User saveUser(User user){

        return userRepository.save(user);
    }

    public List<User> findUsersOlderThan(int age){

        return userRepository.findByAgeGreaterThan(age);

    }

    public List<User> findAllUsers(){

        return userRepository.findAll();

    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }





}
