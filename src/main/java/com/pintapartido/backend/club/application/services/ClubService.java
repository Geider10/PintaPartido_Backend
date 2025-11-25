package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.response.ClubDetailDTO;
import com.pintapartido.backend.club.application.dtos.response.ClubListDTO;
import com.pintapartido.backend.club.application.dtos.request.ClubSaveDTO;
import com.pintapartido.backend.club.application.dtos.request.ClubStatusDTO;
import com.pintapartido.backend.club.application.useCases.club.DeleteClubByIdUseCase;
import com.pintapartido.backend.club.application.useCases.club.GetAllClubsUseCase;
import com.pintapartido.backend.club.application.useCases.club.GetClubByIdUseCase;
import com.pintapartido.backend.club.application.useCases.club.SaveClubUseCase;
import com.pintapartido.backend.club.application.useCases.club.UpdateClubSatusUC;
import com.pintapartido.backend.club.application.useCases.club.UpdateClubUseCase;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import jakarta.validation.Valid;
import java.util.List;

public class ClubService {
  private final SaveClubUseCase createUC;
  private final GetAllClubsUseCase getAllUC;
  private final GetClubByIdUseCase getByIdUC;
  private final UpdateClubUseCase updateUC;
  private final UpdateClubSatusUC updateStatusUC;
  private final DeleteClubByIdUseCase deleteByIdUC;

  // Inyectamos el repositorio y construimos los use cases
  public ClubService(ClubRepository clubRepository){
    this.createUC = new SaveClubUseCase(clubRepository);
    this.getAllUC = new GetAllClubsUseCase(clubRepository);
    this.getByIdUC = new GetClubByIdUseCase(clubRepository);
    this.updateUC = new UpdateClubUseCase(clubRepository);
    this.updateStatusUC = new UpdateClubSatusUC(clubRepository);
    this.deleteByIdUC = new DeleteClubByIdUseCase(clubRepository);
  }

  public void createClub(ClubSaveDTO dto){
    this.createUC.execute(dto);
  }
  public ClubDetailDTO getClubById(Long id){
    return this.getByIdUC.execute(id);
  }
  public List<ClubListDTO> getAllClubs(String status){
    return this.getAllUC.execute(status);
  }
  public void updateClub(Long id, ClubSaveDTO dto) {
    this.updateUC.execute(id, dto);
  }
  public void updateClubStatus(Long id, @Valid ClubStatusDTO statusDto) {
    this.updateStatusUC.execute(id, statusDto);
  }
  public void deleteClubById(Long id){
    this.deleteByIdUC.execute(id);
  }
}
