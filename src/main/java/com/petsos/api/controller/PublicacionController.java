package com.petsos.api.controller;

import com.petsos.api.model.Propietario;
import com.petsos.api.model.Publicacion;
import com.petsos.api.services.PropietarioService;
import com.petsos.api.services.PublicacionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService){
        this.publicacionService = publicacionService;
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Publicacion>> index(Pageable pageable) {
        Page<Publicacion> products = publicacionService.index(pageable);
        return new ResponseEntity<Page<Publicacion>>(products, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> listarPropietarios(){
        List<Publicacion> publicacion = publicacionService.listaPublicaciones();
        return new ResponseEntity<List<Publicacion>>(publicacion, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Publicacion> obtenerPublicacionPorId(@PathVariable("id") Integer id){
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        return new ResponseEntity<Publicacion>(publicacion, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Publicacion> registrarPublicacion(@Valid @RequestBody Publicacion publicacion){
        Publicacion publicacionNew=publicacionService.registrarPublicacion(publicacion);
        return new ResponseEntity<Publicacion>(publicacionNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Publicacion> modificarPublicacion(@Valid @RequestBody Publicacion publicacion){
        Publicacion publicacionUpdate=publicacionService.modificarPublicacion(publicacion);
        return new ResponseEntity<Publicacion>(publicacionUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable("id") Integer id){
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
