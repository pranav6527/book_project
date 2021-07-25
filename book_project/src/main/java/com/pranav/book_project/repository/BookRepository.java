package com.pranav.book_project.repository;

import com.pranav.book_project.entity.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("FROM Book WHERE book_name = ?1")
  Optional<Book> findByBook_name(String name);

}