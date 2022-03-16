package com.petsos.api.services;

import com.petsos.api.exception.GeneralServiceException;
import com.petsos.api.exception.IncorrectResourceRequestException;
import com.petsos.api.exception.ResourceNotFoundException;
import com.petsos.api.model.Mascota;
import com.petsos.api.repositories.MascotaRepository;
import com.petsos.api.validators.MascotaValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

  private final MascotaRepository mascotaRepository;

  public MascotaService(MascotaRepository mascotaRepository) {
    this.mascotaRepository = mascotaRepository;
  }

  public List<Mascota> listaMascotas(){
    return mascotaRepository.findAll();
  }

  public Page<Mascota> index(Pageable pageable){
    return mascotaRepository.findAll(pageable);
  }

  public Mascota obtenerMascotaPorId(Integer idMascota){
    Optional<Mascota> mascota = mascotaRepository.findById(idMascota);
    return mascota.orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
  }
  @Transactional
  public Mascota registrarMascota(Mascota mascota){
    try {
      MascotaValidator.validate(mascota);
      return mascotaRepository.save(mascota);
    } catch (IncorrectResourceRequestException | ResourceNotFoundException e) {
      throw e;
    } catch (Exception e) {
      throw new GeneralServiceException(e.getMessage(), e);
    }
  }

  @Transactional
  public Mascota modificarMascota(Mascota mascota){
    MascotaValidator.validate(mascota);

    Mascota mascotaFromDb=mascotaRepository.findById(mascota.getIdMascota()).orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));

    mascotaFromDb.setTipo(mascota.getTipo());
    mascotaFromDb.setNombre(mascota.getNombre());
    mascotaFromDb.setEdad(mascota.getEdad());
    mascotaFromDb.setTamano(mascota.getTamano());
    mascotaFromDb.setSexo(mascota.getSexo());
    mascotaFromDb.setNivel(mascota.getNivel());
    mascotaFromDb.setDescripcion(mascota.getDescripcion());
    mascotaFromDb.setFoto(mascota.getFoto());
    mascotaFromDb.setEstado(mascota.getEstado());

    return mascotaRepository.save(mascotaFromDb);
  }

  @Transactional
  public void eliminarMascota(Integer idMascota){
    Mascota mascotaFromDb=this.obtenerMascotaPorId(idMascota);
    mascotaRepository.delete(mascotaFromDb);
  }
}
