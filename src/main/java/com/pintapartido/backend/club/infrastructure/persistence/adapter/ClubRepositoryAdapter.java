package com.pintapartido.backend.club.infrastructure.persistence.adapter;

import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.club.infrastructure.persistence.entity.ClubEntity;
import com.pintapartido.backend.club.infrastructure.persistence.jpa.ClubJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ClubRepositoryAdapter implements ClubRepository {
  private final ClubJpaRepository jpa;
  public ClubRepositoryAdapter(ClubJpaRepository jpa){
    this.jpa = jpa;
  }

  @Override
  public void save(ClubModel club) {
    ClubEntity entity = new ClubEntity(
        club.getId(),
        club.getName(),
        club.getAddress(),
        club.getLocation(),
        club.getStatus(),
        club.getOwnerId()
    );
    this.jpa.save(entity);
  }

  @Override
  public Optional<ClubModel> findById(Long id) {
    Optional<ClubEntity> entity = this.jpa.findById(id);
    return entity.map(e -> new ClubModel(
        e.getId(),
        e.getName(),
        e.getAddress(),
        e.getLocation(),
        e.getStatus(),
        e.getOwnerId()
    ));
  }

  @Override
  public List<ClubModel> findAll() {
    return this.jpa.findAll().stream()
        .map(e -> new ClubModel(
            e.getId(),
            e.getName(),
            e.getAddress(),
            e.getLocation(),
            e.getStatus(),
            e.getOwnerId()
        )).toList();
  }

  @Override
  public void deleteById(Long id) {
    this.jpa.deleteById(id);
  }

  @Override
  public boolean existsByNameAndAddress(String name, String address) {
    return this.jpa.existsByNameAndAddress(name, address);
  }

  @Override
  public boolean existsByNameAndAddressAndIdNot(String name, String address, Long id) {
    return this.jpa.existsByNameAndAddressAndIdNot(name, address, id);
  }

  @Override
  public List<ClubModel> findByStatus(String status) {
    return this.jpa.findByStatus(status).stream()
        .map(e -> new ClubModel(
            e.getId(),
            e.getName(),
            e.getAddress(),
            e.getLocation(),
            e.getStatus(),
            e.getOwnerId()
        )).toList();
  }
}
