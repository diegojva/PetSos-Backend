package com.petsos.api.controller;

import com.petsos.api.model.Propietario;
import com.petsos.api.services.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService){
        this.propietarioService = propietarioService;
    }

    @GetMapping
    public ResponseEntity<List<Propietario>> listarPropietarios(){
        List<Propietario> propietarios = propietarioService.listaPropietarios();
        return new ResponseEntity<List<Propietario>>(propietarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Propietario> obtenerPropietarioPorId(@PathVariable("id") Integer id){
        Propietario propietario = propietarioService.obtenerPropietarioPorId(id);
        return new ResponseEntity<Propietario>(propietario, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Propietario> registrarPropietario(@Valid @RequestBody Propietario propietario){
        Propietario propietarioNew=propietarioService.registrarPropietario(propietario);
        return new ResponseEntity<Propietario>(propietarioNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Propietario> modificarPropietario(@Valid @RequestBody Propietario propietario){
        Propietario propietarioUpdate=propietarioService.modificarPropietario(propietario);
        return new ResponseEntity<Propietario>(propietarioUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable("id") Integer id){
        propietarioService.eliminarPropietario(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
