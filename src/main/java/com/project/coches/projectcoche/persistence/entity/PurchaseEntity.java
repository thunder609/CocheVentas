package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity de Compra
 */
@Entity
@Getter
@Setter
@Table(name = "compras")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero_factura")
    private Integer numberBill;
    @Column(name="cliente_cedula")
    private String cardIdCustomer;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha")
    private LocalDateTime date;
    private Double total;
    @Column(name="medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name="liente_cedula",insertable = false,updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity" ,cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carsPurchase;

}
