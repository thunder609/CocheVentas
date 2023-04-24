package com.project.coches.projectcoche.persistence.mapper;

import com.project.coches.projectcoche.domain.dto.CarDto;
import com.project.coches.projectcoche.persistence.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {
    CarDto toCarDto(CarEntity carEntity);
    @Mapping(target ="brandCarEntity", ignore = true)
    @Mapping(target ="carPurchaseEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDto(List<CarEntity> carEntityList);


    List<CarDto> toCarDto(List<CarEntity> allByBrandCarId);
}


