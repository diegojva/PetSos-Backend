package com.petsos.api.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "propietarios")
@Data
@Getter
@Setter

public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropietario;

    @NotNull
    @Size(min=4,  message = "Nombre debe tener 8 caracteres")
    @Column(name="nombre",nullable = false, length = 20)
    private String nombres;


    @NotNull
    @Size(min=6,  message = "Apellido debe tener 6 caracteres")
    @Column(name="apellidos",nullable = false, length = 30)
    private String apellidos;

    @NotNull
    @Size(min=8, max=8, message = "DNI debe tener 8 caracteres")
    @Column(name="dni",nullable = false, length = 8, unique = true)
    private String dni;


}
