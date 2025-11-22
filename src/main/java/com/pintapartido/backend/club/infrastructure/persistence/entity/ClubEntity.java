package com.pintapartido.backend.club.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clubs")
public class ClubEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name",nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 200)
  private String address;

  @Column(nullable = false, length = 100)
  private String location;

  @Column(nullable = false, length = 20)
  private String status;
}
