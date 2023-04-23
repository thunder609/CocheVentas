package com.project.coches.projectcoche.persistence.repository;

import com.project.coches.projectcoche.domain.dto.CarDto;
import com.project.coches.projectcoche.domain.repository.ICarRepository;
import com.project.coches.projectcoche.persistence.crud.ICarCrudRepository;
import com.project.coches.projectcoche.persistence.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class CarRepository implements ICarRepository {
    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;


    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarMapper.toCarDto(iCarCrudRepository.findAllByBrandCarId(idBrandCar));
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return null;
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarCrudRepository.findById(idCar)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {

        return iCarMapper.toCarDto(iCarCrudRepository.save(iCarMapper.toCarEntity(newCar))) ;
    }

    @Override
    public void delete(Integer idCar ) {
        iCarCrudRepository.deleteById(idCar);    }
      }

