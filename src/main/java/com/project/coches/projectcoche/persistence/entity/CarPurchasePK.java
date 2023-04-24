package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.Column;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CarPurchasePK implements Serializable {
    @Serial
private static final long seriaVersionUID=-214547964343286721L;
    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;

    @Column(name = "coches_codigo_coche")
    private Integer codeCar;
}
