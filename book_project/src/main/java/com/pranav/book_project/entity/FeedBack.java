package com.pranav.book_project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedBack {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;
  private String comment;
  private int rating;  //one to five

}
