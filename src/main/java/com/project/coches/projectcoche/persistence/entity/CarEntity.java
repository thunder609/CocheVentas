package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "coches")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Integer codeCar;
    @Column(name = "marca_coche_id")
    private Integer brandCarId;
    @Column(name = "referencia")
    private String reference;
    @Column(name = "precio")
    private Double price;
    @Column(name = "anio_modelo")
    private Double modelYear;
    private String color;
    @Column(name = "numero_caballos_fuerza")
    private Double horsepower;
    @Column(name = "cantidad_puertas")
    private Integer numberDoor;
    @Column(name = "cilindraje")
    private Double engineDisplacement;
    @Column(name = "transmision")
    private String tramission;
    @Column(name= "tipo_combustible")
    private String fuelType;
    @Column(name = "cantidad_asientos")
    private Integer numberSeat;
    @Column(name = "traccion")
    private Integer traction;
    @Column(name = "direccion")
    private String sterering;
    @Column(name = "categoria")
    private String category;
    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;
    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;

}
