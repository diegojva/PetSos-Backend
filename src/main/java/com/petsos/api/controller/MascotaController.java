package com.petsos.api.controller;


import com.petsos.api.model.Mascota;
import com.petsos.api.services.MascotaService;
import com.petsos.api.utils.WrapperResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//verificando método get


@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Mascota>> index(Pageable pageable) {
    Page<Mascota> mascotas = mascotaService.index(pageable);
    return new ResponseEntity<Page<Mascota>>(mascotas, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<WrapperResponse<List<Mascota>>> listarMascotas() {
    List<Mascota> mascotas = mascotaService.listaMascotas();
    return new WrapperResponse<>(true, "success", mascotas)
      .createResponse(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity <WrapperResponse<Mascota>> obtenerMascotaPorId(@PathVariable("id") Integer id){
    Mascota mascota=mascotaService.obtenerMascotaPorId(id);
    return new WrapperResponse<>(true, "success", mascota)
      .createResponse(HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<WrapperResponse<Mascota>> registrarMascota(@RequestBody Mascota mascota) {
    Mascota productNew= mascotaService.registrarMascota(mascota);
    return new WrapperResponse<Mascota>(true, "success", productNew)
      .createResponse(HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<WrapperResponse<Mascota>> modificarMascota(@RequestBody Mascota mascota){
    Mascota mascotaUpdate= mascotaService.modificarMascota(mascota);
    return new WrapperResponse<Mascota>(true, "success", mascotaUpdate)
      .createResponse(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<WrapperResponse<Void>> eliminarMascota(@PathVariable Integer id){
    mascotaService.eliminarMascota(id);
    return new WrapperResponse<Void>(true, "success", null)
      .createResponse(HttpStatus.NO_CONTENT);
  }
}

