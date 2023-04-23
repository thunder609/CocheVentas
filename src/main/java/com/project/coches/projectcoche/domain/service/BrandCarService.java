package com.project.coches.projectcoche.domain.service;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;
import com.project.coches.projectcoche.domain.repository.IBrandCarRepository;
import com.project.coches.projectcoche.domain.useCase.IBrandCarServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de Marca Coche
 */
@Service
@RequiredArgsConstructor
public class BrandCarService implements IBrandCarServiceUseCase {
    private final IBrandCarRepository iBrandCarRepository;
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    @Override
    public Optional<BrandCarDto> update(BrandCarDto newBrandCar) {
        if(iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()){
            return  Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(newBrandCar));
    }

    @Override
    public boolean delete(Integer idBrandCar) {
     if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()){
         return false;
     }
     iBrandCarRepository.delete(idBrandCar);
     return  true;
    }
}
