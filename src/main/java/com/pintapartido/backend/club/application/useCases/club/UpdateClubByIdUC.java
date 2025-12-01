package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class UpdateClubByIdUC {
  private final ClubRepository clubRepository;
  public UpdateClubByIdUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public void execute(Long id, ClubUpdateDto dto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club not found by id");

    boolean existsClub = this.clubRepository.existsByNameAndAddressAndIdNot(dto.getName(), dto.getAddress(),id);
    if(existsClub) throw new ConflictException("Club name and address already exists");

    ClubMapper.updateToModel(dto, club.get());
    this.clubRepository.save(club.get());
  }
}
