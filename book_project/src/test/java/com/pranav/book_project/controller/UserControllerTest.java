package com.pranav.book_project.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pranav.book_project.constants.ERole;
import com.pranav.book_project.entity.Address;
import com.pranav.book_project.entity.Cart;
import com.pranav.book_project.entity.FeedBack;
import com.pranav.book_project.entity.Role;
import com.pranav.book_project.entity.User;
import com.pranav.book_project.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private UserService userService;

  @Test
  public void getAllUsers() throws Exception {
    List<User> userList = new ArrayList<>();
    Role role = new Role(ERole.ROLE_ADMIN);
    Set<Role> roles = new HashSet<>();
    roles.add(role);
    Address address = new Address("shahada", "shahada", 425409);
    LocalDateTime ldt = LocalDateTime.now();
    Cart cart = new Cart(1, true);
    FeedBack feedBack = new FeedBack(1, "project looks good", 1);
    User user = new User(1l, "pranav", "pranav@gamil.com", "prod", roles, address, 50000.00,
        ldt, cart, feedBack);
    userList.add(user);

    when(userService.findAllUsers()).thenReturn(userList);

    mockMvc.perform(get("/user/users")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));

  }

  @Test
  public void saveUser()
  {

    Role role = new Role(ERole.ROLE_ADMIN);
    Set<Role> roles = new HashSet<>();
    roles.add(role);
    Address address = new Address("shahada", "shahada", 425409);
    LocalDateTime ldt = LocalDateTime.now();
    Cart cart = new Cart(1, true);
    FeedBack feedBack = new FeedBack(1, "project looks good", 1);
    User user = new User(1l, "pranav", "pranav@gamil.com", "prod", roles, address, 50000.00,
        ldt, cart, feedBack);

   // when(userService.saveUser(user)).thenReturn(userList);

  }

}
