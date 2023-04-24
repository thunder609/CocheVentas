package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mappings;

/*
Entidad carros Compras
 */

@Entity
@Getter
@Setter
@Table(name="coches_compras")
public class CarPurchaseEntity {
    @EmbeddedId
    private CarPurchasePK  id;
    @Column(name="cantiad")
    private Integer quantityCars;

    private Integer total;

       @ManyToOne
       @MapsId(value="purchaseNumberBill")
    @JoinColumn(name="compras_numero_factura",insertable = false,updatable = false)
    private  PurchaseEntity purchaseEntity;
    @ManyToOne
    @JoinColumn(name="coches_codigo_coche",insertable = false,updatable = false)
    private CarEntity carEntity;


}
