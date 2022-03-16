package com.petsos.api.services.impl;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Publicacion;
import com.petsos.api.repositories.AdoptanteRepository;
import com.petsos.api.services.AdoptanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptanteServiceImpl implements AdoptanteService {

    private final AdoptanteRepository adoptanteRepository;

    public AdoptanteServiceImpl(AdoptanteRepository adoptanteRepository){
        this.adoptanteRepository = adoptanteRepository;
    }


    public Page<Adoptante> index(Pageable pageable) {
        return adoptanteRepository.findAll(pageable);
    }

    @Override
    public Adoptante registrarAdoptante(Adoptante adoptante) {
        return adoptanteRepository.save(adoptante);
    }

    @Override
    public Adoptante modificarAdoptante(Adoptante adoptante) {
        return adoptanteRepository.save(adoptante);
    }

    @Override
    public List<Adoptante> listaAdoptantes() {
        return adoptanteRepository.findAll();
    }

    @Override
    public Adoptante obtenerAdoptantePorId(Integer idAdoptante) {
        return adoptanteRepository.findById(idAdoptante).orElse(new Adoptante());
    }

    @Override
    public void eliminarAdoptante(Integer idAdoptante) {
        adoptanteRepository.deleteById(idAdoptante);
    }
}
