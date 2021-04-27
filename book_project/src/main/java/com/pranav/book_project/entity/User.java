package com.pranav.book_project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class User implements Serializable {

  @Id
  @GeneratedValue
  @Column(nullable = false, updatable = false)
  private long id;

  private String userId;
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String email;
  private Date lastActiveTime;
  private Date JoinDate;
  private String[] authorities;
  private String[] roles;
  private String profileUrl;
  private boolean active;
  private boolean isNotLocked;
}
