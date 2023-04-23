package com.project.coches.projectcoche.domain.useCase;

import com.project.coches.projectcoche.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarServiceUseCase {
    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer carId);

    List<CarDto> getCarsByPriceLessThan(Double price);



    /**
     *
     * @param idCar Id decoche
     * @return Optional del  coche encontrado
     */
    Optional<CarDto> getCar(Integer idCar);

    /**
     *
     * @param newCard Marca coche a guardar
     * @return  marca coche guardado
     */
    CarDto save (CarDto newCard);

    /**
     *
     * @param  idCar del marca coche a eliminar
     */
boolean delete(Integer idCar);
}
