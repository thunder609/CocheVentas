package com.project.coches.projectcoche.persistence.mapper;

import com.project.coches.projectcoche.domain.dto.PurchaseRequestDto;
import com.project.coches.projectcoche.domain.dto.PurchaseResponseDto;
import com.project.coches.projectcoche.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Maper de Compras
 */
@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore=true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchasesDto(List<PurchaseEntity> purchaseEntityList);


}
