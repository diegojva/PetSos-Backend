package com.petsos.api.services;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Propietario;

import java.util.List;

public interface PropietarioService {

    Propietario registrarPropietario(Propietario propietario);
    Propietario modificarPropietario(Propietario propietario);
    List<Propietario> listaPropietarios();
    Propietario obtenerPropietarioPorId(Integer idPropietario);
    void eliminarPropietario(Integer idPropietario);
}
