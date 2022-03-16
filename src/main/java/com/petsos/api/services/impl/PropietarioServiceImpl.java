package com.petsos.api.services.impl;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Propietario;
import com.petsos.api.repositories.AdoptanteRepository;
import com.petsos.api.repositories.PropietarioRepository;
import com.petsos.api.services.PropietarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository){
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public Propietario registrarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario modificarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public List<Propietario> listaPropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario obtenerPropietarioPorId(Integer idPropietario) {
        return propietarioRepository.findById(idPropietario).orElse(new Propietario());
    }

    @Override
    public void eliminarPropietario(Integer idPropietario) {
        propietarioRepository.deleteById(idPropietario);
    }
}
