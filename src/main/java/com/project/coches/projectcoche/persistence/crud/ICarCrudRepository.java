package com.project.coches.projectcoche.persistence.crud;

import com.project.coches.projectcoche.domain.dto.CarDto;
import com.project.coches.projectcoche.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ICarCrudRepository extends JpaRepository<CarEntity,Integer> {

   List<CarEntity> findAllByBrandCarId(Integer id);


   List<CarEntity> findAllByPriceLessThanOrderByPriceDesc(Double price);
}
