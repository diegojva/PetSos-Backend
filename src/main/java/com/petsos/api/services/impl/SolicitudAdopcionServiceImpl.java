package com.petsos.api.services.impl;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Publicacion;
import com.petsos.api.model.SolicitudAdopcion;
import com.petsos.api.repositories.AdoptanteRepository;
import com.petsos.api.repositories.SolicitudAdopcionRepository;
import com.petsos.api.services.SolicitudAdopcionService;
import com.petsos.api.validators.SolicitudAdopcionValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SolicitudAdopcionServiceImpl implements SolicitudAdopcionService {

    private final SolicitudAdopcionRepository solicitudAdopcionRepository;


    public SolicitudAdopcionServiceImpl(SolicitudAdopcionRepository solicitudAdopcionRepository){
        this.solicitudAdopcionRepository = solicitudAdopcionRepository;
    }

    @Override
    public Page<SolicitudAdopcion> index(Pageable pageable) {
        return solicitudAdopcionRepository.findAll(pageable);
    }

    @Override
    public SolicitudAdopcion registrarSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        SolicitudAdopcionValidator.validate(solicitudAdopcion);
        solicitudAdopcion.setFechaCreacion(LocalDate.now());
        solicitudAdopcion.setEstado("P");
        return solicitudAdopcionRepository.save(solicitudAdopcion);
    }

    @Override
    public SolicitudAdopcion modificarSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {

        return solicitudAdopcionRepository.save(solicitudAdopcion);
    }

    @Override
    public List<SolicitudAdopcion> listaSolicitudAdopcion() {
        return solicitudAdopcionRepository.findAll();
    }

    @Override
    public SolicitudAdopcion obtenerSolicitudAdopcionPorId(Integer idSolicitudAdopcion) {
        return solicitudAdopcionRepository.findById(idSolicitudAdopcion).orElse(new SolicitudAdopcion());
    }

    @Override
    public void eliminarSolicitudAdopcion(Integer idSolicitudAdopcion) {
        solicitudAdopcionRepository.deleteById(idSolicitudAdopcion);
    }
}
