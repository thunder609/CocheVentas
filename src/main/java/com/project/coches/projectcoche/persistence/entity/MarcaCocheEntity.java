package com.project.coches.projectcoche.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="marca_coche")

/*
*Entidad marca coche
 */
public class MarcaCocheEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @Column(name="descripcion")
    private String description;


}
