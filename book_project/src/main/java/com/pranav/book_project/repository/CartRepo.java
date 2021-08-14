package com.pranav.book_project.repository;

import com.pranav.book_project.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo  extends JpaRepository<Cart,Integer> {

}
