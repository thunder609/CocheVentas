package com.project.coches.projectcoche.persistence.repository;

import com.project.coches.projectcoche.domain.dto.BrandCarDto;
import com.project.coches.projectcoche.domain.repository.IBrandCarRepository;
import com.project.coches.projectcoche.persistence.entity.BrandCarEntity;
import com.project.coches.projectcoche.persistence.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * repositorio Marca coche
 */
@RequiredArgsConstructor // crea constructor con los atributos final
@Repository
public class BradCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
        // brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity) - LAMBDA
        // iBrandCarMapper::toMarcaCochePojo - Metodo por REFERENCIA
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
