package com.project.coches.projectcoche.domain.repository;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {
    /**
     * devuelve una lista contodas las marcas coche
     * @return Lista con marca de coche
     */
    List<BrandCarDto> getAll();

    /**
     *
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     *
     * @param newBrandCard Marca coche a guardar
     * @return  marca coche guardado
     */
    BrandCarDto save (BrandCarDto newBrandCard);

    /**
     *
     * @param idBrandCar id del marca coche a eliminar
     */
    void delete(Integer idBrandCar);
}
