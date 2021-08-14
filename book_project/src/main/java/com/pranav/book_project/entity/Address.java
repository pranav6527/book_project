package com.pranav.book_project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@ToString
@Data
public class Address {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;
  private String tempAddress;
  private String permanentAddress;
  private int pincode;

  public Address(String tempAddress, String permanentAddress, int pincode) {
    this.tempAddress = tempAddress;
    this.permanentAddress = permanentAddress;
    this.pincode = pincode;
  }
}
