package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ClubDetailDto;
import com.pintapartido.backend.club.application.dtos.response.ClubListDto;
import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.domain.models.ClubModel;

public class ClubMapper {
  public static ClubModel convertToModel(ClubSaveDto dto){
    return new ClubModel(
        dto.getName(),
        dto.getAddress(),
        dto.getLocation(),
        dto.getOwnerId()
    );
  }
  public static ClubListDto convertToClubList(ClubModel club){
    return new ClubListDto(
        club.getId(),
        club.getName(),
        club.getLocation()
    );
  }
  public static ClubDetailDto convertToClubDetail(ClubModel club){
    return new ClubDetailDto(
        club.getId(),
        club.getName(),
        club.getAddress(),
        club.getLocation()
    );
  }
  public static void updateToModel(ClubUpdateDto dto, ClubModel club){
    club.setName(dto.getName());
    club.setAddress(dto.getAddress());
    club.setLocation(dto.getLocation());
  }
}
