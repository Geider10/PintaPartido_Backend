package com.pintapartido.backend.club.infrastructure.persistence.jpa;

import com.pintapartido.backend.club.infrastructure.persistence.entity.ClubEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubJpaRepository extends JpaRepository<ClubEntity, Long> {
  boolean existsByNameAndAddress(String name, String address);
  boolean existsByNameAndAddressAndIdNot(String name, String address, Long id);
  List<ClubEntity> findByStatus(String status);
}
