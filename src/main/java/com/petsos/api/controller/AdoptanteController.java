package com.petsos.api.controller;

import com.petsos.api.model.Adoptante;
import com.petsos.api.services.AdoptanteService;
import com.petsos.api.utils.WrapperResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/adoptantes")
public class AdoptanteController {

    private final AdoptanteService adoptanteService;

    public AdoptanteController(AdoptanteService adoptanteService){
        this.adoptanteService = adoptanteService;
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Adoptante>> index(Pageable pageable) {
        Page<Adoptante> adoptantes = adoptanteService.index(pageable);
        return new ResponseEntity<Page<Adoptante>>(adoptantes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Adoptante>>> listarAdoptantes(){
        List<Adoptante> adoptante = adoptanteService.listaAdoptantes();
        return new WrapperResponse<>(true, "success", adoptante)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Adoptante> obtenerAdoptantePorId(@PathVariable("id") Integer id){
        Adoptante adoptante = adoptanteService.obtenerAdoptantePorId(id);
        return new ResponseEntity<Adoptante>(adoptante, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Adoptante> registrarAdoptante(@Valid @RequestBody Adoptante adoptante){
        Adoptante adoptanteNew=adoptanteService.registrarAdoptante(adoptante);
        return new ResponseEntity<Adoptante>(adoptanteNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Adoptante> modificarAdoptante(@Valid @RequestBody Adoptante adoptante){
        Adoptante adoptanteUpdate=adoptanteService.modificarAdoptante(adoptante);
        return new ResponseEntity<Adoptante>(adoptanteUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdoptante(@PathVariable("id") Integer id){
        //Adoptante adoptante = adoptanteService.obtenerAdoptantePorId(id);
        adoptanteService.eliminarAdoptante(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
