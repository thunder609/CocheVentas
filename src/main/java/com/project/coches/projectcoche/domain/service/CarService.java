package com.project.coches.projectcoche.domain.service;

import com.project.coches.projectcoche.domain.dto.CarDto;
import com.project.coches.projectcoche.domain.repository.ICarRepository;
import com.project.coches.projectcoche.domain.useCase.ICarServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CarService implements ICarServiceUseCase {
       private final ICarRepository iCarRepository;


    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idCar) {
        return iCarRepository.getByIdBrandCar(idCar);
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarRepository.getCarsByPriceLessThan(price);
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {

        return iCarRepository.getCar(idCar);
    }

    @Override
    public CarDto save(CarDto newCard) {
        return iCarRepository.save(newCard);
    }

    @Override
    public boolean delete(Integer idCar) {

       if (iCarRepository.getCar(idCar).isEmpty()) {
        return false;
    }

        iCarRepository.delete(idCar);
        return true;
}
}
