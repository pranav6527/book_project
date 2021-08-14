package com.pranav.book_project.service;

import com.pranav.book_project.entity.User;
import com.pranav.book_project.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }
}
