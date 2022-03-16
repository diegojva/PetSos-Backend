package com.petsos.api.services;

import com.petsos.api.model.Padrino;
import com.petsos.api.model.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PadrinoService {
    Page<Padrino> index(Pageable pegable);
    Padrino registrarPadrino(Padrino padrino);
    Padrino modificarPadrino(Padrino padrino);
    List<Padrino> listaPadrinos();
    Padrino obtenerPadrinoPorId(Integer idPadrino);
    void eliminarPadrino(Integer idPadrino);

}
