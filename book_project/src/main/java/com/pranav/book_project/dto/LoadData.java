/*
package com.pranav.book_project.dto;

import com.pranav.book_project.entity.Cart;
import com.pranav.book_project.entity.User;
import com.pranav.book_project.repository.AddressRepo;
import com.pranav.book_project.repository.CartRepo;
import com.pranav.book_project.repository.FeedBackRepo;
import com.pranav.book_project.repository.ItemRepo;
import com.pranav.book_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadData {

  @Autowired
  private AddressRepo repo;

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private CartRepo cartRepo;
  @Autowired
  private ItemRepo itemRepo;

  @Autowired
  private FeedBackRepo feedBackRepo;

  @EventListener
  public void appReady(ApplicationReadyEvent event) {

//    Customer customer = new Customer();

   */
/* Set<Item> item = new HashSet<>();
    Item it1 = new Item();
    it1.setName("pen");
    it1.setPrice(50.00);
    Item it2 = new Item();
    it2.setName("laptop");
    it2.setPrice(50000.00);
    item.add(it1);
    item.add(it2);
    itemRepo.saveAll(item);*//*

    */
/*Cart cart = new Cart();
    cart.setItems(item);
    cartRepo.save(cart);
    Address add = new Address();
    add.setPermanentAddress("shahada");
    add.setTempAddress("shahada");
    add.setPincode(425409);*//*

    */
/*itemRepo.findById(1).get().setCart(cartRepo.findById(1).get());
    itemRepo.findById(2).get().setCart(cartRepo.findById(1).get());*//*

   */
/* customer.setBalance(5000.00);
    customer.setLoginTime(new Date());
    customer.setEmail("prod@gmail.com");
    customer.setPassword("prod123");
    customer.setUsername("prod");
    Role role = new Role();
    role.setName(ERole.ROLE_ADMIN);
    Set<Role> rol = new HashSet<>();
    rol.add(role);
    customer.setRoles(rol);
    FeedBack f= new FeedBack();
    f.setComment("this project is good");
    f.setRating(4);
    customer.setFeedBack(f);*//*

    //   userRepo.save(customer);
    */
/*Address add = new Address();
    add.setPermanentAddress("shahada");
    add.setTempAddress("shahada");
    add.setPincode(425409);
    repo.save(add);
    FeedBack f = new FeedBack();
    f.setComment("this project is good");
    f.setRating(4);
    feedBackRepo.save(f);*//*

   */
/* Customer c = new Customer();
    c.setFeedBack(feedBackRepo.findById(1).get());
    c.setUsername("pranav");
    c.setPassword("prod");
    c.setEmail("prod@gmail.com");
    c.setBalance(5000.00);
    c.setCart(cartRepo.findById(1).get());
    c.setAddress(repo.findById(1).get());
    userRepo.save(c);*//*

    */
/*Item item1 = itemRepo.findById(1).get();
    Item item2 = itemRepo.findById(2).get();
    Cart cart = cartRepo.findById(1).get();
    item1.setCart(cart);
    itemRepo.save(item1);
    item2.setCart(cart);
    itemRepo.save(item2);*//*

    User user = userRepo.findById(1l).get();
    Cart cart = cartRepo.findById(1).get();
    user.setCart(cart);
    userRepo.save(user);




  }
}
*/
