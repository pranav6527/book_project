package com.pranav.book_project.service;

import com.pranav.book_project.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UserService {


  List<User> findAllUsers();
}
