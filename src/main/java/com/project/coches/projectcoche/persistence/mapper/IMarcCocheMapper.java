package com.project.coches.projectcoche.persistence.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.project.coches.projectcoche.domain.pojo.MarcaCochePojo;
import com.project.coches.projectcoche.persistence.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
/*
*mapper que transforma objectos MarcaCoche a pojos o  entidades
*  */
@Mapper(componentModel = "spring")
public interface IMarcCocheMapper {
    /*
    * convierte una entidad de entidad de marca pojo a coche
    * @param marcaEntity entidad aconvertir
    * @return pojo convertido */
    @Mapping(source = "id" , target = "id")
    @Mapping(source="description", target ="description")
    MarcaCochePojo  toMarcaCochePojo(MarcaCocheEntity marcaEntity);

    /**
     *  convierte un poko a una netidad marca coche
     * @param marcaPojo  Pojo convertir
     * @return  Entity convertida
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);



   List<MarcaCochePojo> toMarcasCochePojo(List<MarcaCocheEntity> marcasCocheEntity);
}
