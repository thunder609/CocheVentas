package com.project.coches.projectcoche.domain.repository;

import com.project.coches.projectcoche.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {


    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer idBrandCar);

    List<CarDto> getCarsByPriceLessThan(Double price);

    Optional<CarDto> getCar(Integer idCar);

    CarDto save(CarDto newCar);

    void delete(Integer idCar);
}
