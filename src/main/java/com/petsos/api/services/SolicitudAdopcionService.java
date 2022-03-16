package com.petsos.api.services;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Publicacion;
import com.petsos.api.model.SolicitudAdopcion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SolicitudAdopcionService {
    Page<SolicitudAdopcion> index(Pageable pageable);
    SolicitudAdopcion registrarSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion);
    SolicitudAdopcion modificarSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion);
    List<SolicitudAdopcion> listaSolicitudAdopcion();
    SolicitudAdopcion obtenerSolicitudAdopcionPorId(Integer idSolicitudAdopcion);
    void eliminarSolicitudAdopcion(Integer idSolicitudAdopcion);

}
