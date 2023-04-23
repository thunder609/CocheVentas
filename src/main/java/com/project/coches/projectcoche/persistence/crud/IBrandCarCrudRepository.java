package com.project.coches.projectcoche.persistence.crud;

import com.project.coches.projectcoche.persistence.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity,Integer> {

}
