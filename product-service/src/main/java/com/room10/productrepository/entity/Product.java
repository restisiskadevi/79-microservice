package com.room10.productrepository.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private String description;
  private BigDecimal price;
}