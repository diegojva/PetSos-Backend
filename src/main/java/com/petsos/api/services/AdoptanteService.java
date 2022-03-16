package com.petsos.api.services;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdoptanteService {
    Page<Adoptante> index(Pageable pegable);
    Adoptante registrarAdoptante(Adoptante adoptante);
    Adoptante modificarAdoptante(Adoptante adoptante);
    List<Adoptante> listaAdoptantes();
    Adoptante obtenerAdoptantePorId(Integer idAdoptante);
    void eliminarAdoptante(Integer idAdoptante);

}
