package com.petsos.api.controller;

import com.petsos.api.model.SolicitudAdopcion;
import com.petsos.api.services.SolicitudAdopcionService;
import com.petsos.api.utils.WrapperResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud-adopcion")
public class SolicitudAdopcionController {

    private final SolicitudAdopcionService solicitudAdopcionService;

    public SolicitudAdopcionController(SolicitudAdopcionService solicitudAdopcionService){
        this.solicitudAdopcionService=solicitudAdopcionService;
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<SolicitudAdopcion>> index(Pageable pageable) {
        Page<SolicitudAdopcion> solicitudAdopcion = solicitudAdopcionService.index(pageable);
        return new ResponseEntity<Page<SolicitudAdopcion>>(solicitudAdopcion, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<SolicitudAdopcion>>> getAll() {
        List<SolicitudAdopcion> solicitudAdopcion = solicitudAdopcionService.listaSolicitudAdopcion();
        return new WrapperResponse<>(true, "success", solicitudAdopcion)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<SolicitudAdopcion>> get(@PathVariable Long id){
        SolicitudAdopcion solicitudAdopcion=solicitudAdopcionService.obtenerSolicitudAdopcionPorId(id.intValue());
        return new WrapperResponse<>(true, "success", solicitudAdopcion)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<SolicitudAdopcion>> createProduct(@RequestBody SolicitudAdopcion solicitudAdopcion) {
        SolicitudAdopcion solicitudAdopcionNew= solicitudAdopcionService.registrarSolicitudAdopcion(solicitudAdopcion);
        return new WrapperResponse<SolicitudAdopcion>(true, "success", solicitudAdopcionNew)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<SolicitudAdopcion>> updateProduct(@RequestBody SolicitudAdopcion solicitudAdopcion){
        SolicitudAdopcion solicitudAdopcionUpdate= solicitudAdopcionService.modificarSolicitudAdopcion(solicitudAdopcion);
        return new WrapperResponse<SolicitudAdopcion>(true, "success", solicitudAdopcionUpdate)
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteBook(@PathVariable Long id){
        solicitudAdopcionService.eliminarSolicitudAdopcion(id.intValue());
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

}
