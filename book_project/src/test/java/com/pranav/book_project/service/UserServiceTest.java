package com.pranav.book_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pranav.book_project.constants.ERole;
import com.pranav.book_project.entity.Address;
import com.pranav.book_project.entity.Cart;
import com.pranav.book_project.entity.FeedBack;
import com.pranav.book_project.entity.Role;
import com.pranav.book_project.entity.User;
import com.pranav.book_project.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserServiceTest {

  @InjectMocks
  UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  @Test
  public void findAllUsers() throws Exception {

    List<User> userList = new ArrayList<>();
    Role role = new Role(ERole.ROLE_ADMIN);
    Set<Role> roles = new HashSet<>();
    roles.add(role);
    Address address = new Address("shahada", "shahada", 425409);
    LocalDateTime ldt = LocalDateTime.now();
    Cart cart = new Cart(1, true);
    FeedBack feedBack = new FeedBack(1, "project looks good", 1);
    User user = new User(1l, "pranav", "pranav@gamil.com", "prod", roles, address, 50000.00,
        null, cart, feedBack);
    userList.add(user);

    when(userRepository.findAll()).thenReturn(userList);

    List<User>  usrs = userService.findAllUsers();

    assertEquals(1,usrs.size());
    verify(userRepository,times(1)).findAll();
  }
}