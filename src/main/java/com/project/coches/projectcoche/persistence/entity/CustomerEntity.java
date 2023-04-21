package com.project.coches.projectcoche.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
