package com.pranav.book_project.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;
  @OneToMany(mappedBy = "cart")
  @LazyCollection(LazyCollectionOption.FALSE)
  private Set<Item> items;
  private boolean eligibleToBuy;

  public Cart(int id,boolean eligibleToBuy)
  {
    this.id = id;
    this.eligibleToBuy = eligibleToBuy;
  }

  public Cart(boolean eligibleToBuy) {
    this.eligibleToBuy = eligibleToBuy;
  }
}
