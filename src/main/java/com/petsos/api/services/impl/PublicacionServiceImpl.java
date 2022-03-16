package com.petsos.api.services.impl;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Mascota;
import com.petsos.api.model.Publicacion;
import com.petsos.api.repositories.AdoptanteRepository;
import com.petsos.api.repositories.PublicacionRepository;
import com.petsos.api.services.PublicacionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {
    private final PublicacionRepository publicacionRepository;

    public PublicacionServiceImpl(PublicacionRepository publicacionRepository){
        this.publicacionRepository = publicacionRepository;
    }

    @Override
    public Publicacion registrarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Page<Publicacion> index(Pageable pageable) {
        return publicacionRepository.findAll(pageable);
    }

    @Override
    public Publicacion modificarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public List<Publicacion> listaPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Integer idPublicacion) {
        return publicacionRepository.findById(idPublicacion).orElse(new Publicacion());
    }

    @Override
    public void eliminarPublicacion(Integer idPublicacion) {
        publicacionRepository.deleteById(idPublicacion);
    }
}
