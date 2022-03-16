package com.petsos.api.controller;

import com.petsos.api.model.Padrino;
import com.petsos.api.services.PadrinoService;
import com.petsos.api.utils.WrapperResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/padrinos")
public class PadrinoController {

  private final PadrinoService padrinoService;

  public PadrinoController(PadrinoService padrinoService){
    this.padrinoService = padrinoService;
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Padrino>> index(Pageable pageable) {
    Page<Padrino> padrinos = padrinoService.index(pageable);
    return new ResponseEntity<Page<Padrino>>(padrinos, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<WrapperResponse<List<Padrino>>> listarPadrinos(){
    List<Padrino> padrino = padrinoService.listaPadrinos();
    return new WrapperResponse<>(true, "success", padrino)
      .createResponse(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity <Padrino> obtenerPadrinoPorId(@PathVariable("id") Integer id){
    Padrino padrino = padrinoService.obtenerPadrinoPorId(id);
    return new ResponseEntity<Padrino>(padrino, HttpStatus.OK);

  }

  @PostMapping
  public ResponseEntity<Padrino> registrarPadrino(@Valid @RequestBody Padrino padrino){
    Padrino padrinoNew=padrinoService.registrarPadrino(padrino);
    return new ResponseEntity<Padrino>(padrinoNew, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Padrino> modificarPadrino(@Valid @RequestBody Padrino padrino){
    Padrino padrinoUpdate=padrinoService.modificarPadrino(padrino);
    return new ResponseEntity<Padrino>(padrinoUpdate, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarPadrino(@PathVariable("id") Integer id){
    //Padrino padrino = padrinoService.obtenerPadrinoPorId(id);
    padrinoService.eliminarPadrino(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }


}
