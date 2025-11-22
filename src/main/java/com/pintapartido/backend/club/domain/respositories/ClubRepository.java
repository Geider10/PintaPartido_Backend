package com.pintapartido.backend.club.domain.respositories;

import com.pintapartido.backend.club.domain.models.ClubModel;
import java.util.List;
import java.util.Optional;

public interface ClubRepository {
  void save(ClubModel club);
  Optional<ClubModel> findById(Long id);
  List<ClubModel> findAll();
  void deleteById(Long id);
  boolean existsByNameAndAddress(String name, String address);
  boolean existsByNameAndAddressAndIdNot(String name, String address, Long id);
  List<ClubModel> findByStatus(String status);
}