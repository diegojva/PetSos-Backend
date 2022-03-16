package com.petsos.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publicaciones")
@Data
@Getter
@Setter
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;

    @NotNull
    @Column(name="nombre", nullable=true, length=150)
    private String nombre;

    @NotNull
    @Column(name="descripcion", nullable=true, length=250)
    private String descripcion;

    @NotNull
    @Column(name="foto", nullable = false)
    private String foto;

    @ManyToOne
    @JoinColumn(name="id_propietario", nullable=false, foreignKey = @ForeignKey(name="FK_publicacion_propietario"))
    private  Propietario propietario;

    @ManyToOne @JoinColumn (name="id_mascota", nullable=false, foreignKey = @ForeignKey(name="FK_publicacion_mascota"))
    private Mascota mascota;
}
