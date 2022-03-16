package com.petsos.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "mascotas")
@Getter
@Setter
@Data
public class Mascota {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMascota;

  @NotNull
  @Column(name="tipo", nullable = false, length = 50)
  private String tipo;

  @NotNull
  @Column(name="nombre", nullable = false, length = 50)
  private String nombre;

  @Column(name="Edad", nullable = false)
  private Integer edad;

  @NotNull
  @Column(name="tamano", nullable = false, length = 50)
  private String tamano;

  @NotNull
  @Column(name="sexo", nullable = false, length = 50)
  private String sexo;

  @NotNull
  @Column(name="nivel", nullable = false, length = 250)
  private String nivel;

  @NotNull
  @Column(name="descripcion", nullable = false, length = 1000)
  private String descripcion;

  @NotNull
  @Column(name="foto", nullable = false, length = 500)
  private String foto;

  @NotNull
  @Column(name="estado", nullable = false, length = 1)
  private String estado;
}
