package com.petsos.api.services;

import com.petsos.api.model.Mascota;
import com.petsos.api.model.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PublicacionService {
    Page<Publicacion> index(Pageable pegable);
    Publicacion registrarPublicacion(Publicacion publicacion);
    Publicacion modificarPublicacion(Publicacion publicacion);
    List<Publicacion> listaPublicaciones();
    Publicacion obtenerPublicacionPorId(Integer idPublicacion);
    void eliminarPublicacion(Integer idPublicacion);
}
