package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import org.hibernate.validator.constraints.time.DurationMin;

@Entity
@Table (name="cliente")
@Getter
@Setter
/**
 * Entidad de un cliente
 */
public class CustomerEntity {
    @Id

    @Column(name="cedula")
    private String cardId;
    @Column(name="nombre_completo")
    private String fullName;
    @Column(name="correo")
    private String email;
    @Column(name="numero_celular")
    private Integer numberCellphone;
    @Column(name="activo")
    private Integer active;
    @Column(name="contrasenia")
    private String password;
    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntity;
}
