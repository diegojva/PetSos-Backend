package com.petsos.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.petsos.api.model.Mascota;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "solicitud_adopcion")
@Getter
@Setter
public class SolicitudAdopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="fecha_creacion", nullable = false, updatable = false)
    private LocalDate fechaCreacion;

    @NotNull
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @NotNull
    @Column(name="apellido", nullable = false, length = 100)
    private String apellido;

    @NotNull
    @Column(name="direccion", nullable = false, length = 150)
    private String direccion;

    @NotNull
    @Column(name="ciudad", nullable = false, length = 50)
    private String ciudad;

    @NotNull
    @Size(min=8, max=8, message = "DNI debe tener 8 digitos")
    @Column(name="dni",nullable = false, length = 8, unique = true)
    private String dni;

    @NotNull
    @Size(min=9, max=9, message = "Teléfono debe tener 9 digitos")
    @Column(name="telefono", nullable = false, length = 9)
    private String telefono;

    @NotNull
    @Size(min=10, max=100, message = "Correo debe tener mínimo 10 caracteres")
    @Column(name="correo",nullable = false, length = 100)
    private String correo;

    @NotNull
    @Size(min=10, max=250, message = "Detalle mínimo debe tener 10 caracteres")
    @Column(name="detalle_solicitud",nullable = false, length = 250)
    private String detalleSolicitud;

    @NotNull
    @Size(min=1, max=1 )
    @Column(name="estado", nullable = false, length = 1)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false,
            foreignKey = @ForeignKey(name = "Fk_solicitudAdopcion_mascota"))
    private Mascota mascota;

    /*@ManyToOne
    @JoinColumn(name = "id_adoptante", nullable = false,
            foreignKey = @ForeignKey(name = "Fk_solicitudAdopcion_adoptante"))
    private Adoptante adoptante;*/

    /* @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = false,
            foreignKey = @ForeignKey(name = "Fk_solicitudAdopcion_publicacion"))
    private Publicacion  publicacion;*/

}
