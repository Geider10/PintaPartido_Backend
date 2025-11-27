package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubSaveDTO;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.club.domain.exceptions.DuplicateClubNameAndAddressException;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class UpdateClubUseCase {
  private final ClubRepository clubRepository;
  public UpdateClubUseCase(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public void execute(Long id, ClubSaveDTO dto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club cannot be get by ID because was not found.");

    boolean existsClub = this.clubRepository.existsByNameAndAddressAndIdNot(dto.getName(), dto.getAddress(),id);
    if(existsClub) throw new DuplicateClubNameAndAddressException();

    ClubMapper.updateToModel(dto, club.get());
    this.clubRepository.save(club.get());
  }
}
