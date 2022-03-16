package com.petsos.api.services.impl;

  import com.petsos.api.model.Adoptante;
  import com.petsos.api.model.Padrino;
  import com.petsos.api.model.Publicacion;
  import com.petsos.api.repositories.AdoptanteRepository;
  import com.petsos.api.repositories.PadrinoRepository;
  import com.petsos.api.services.PadrinoService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.data.domain.Page;
  import org.springframework.data.domain.Pageable;
  import org.springframework.stereotype.Service;

  import java.util.List;
@Service
public class PadrinoServiceImpl implements PadrinoService {

  private final PadrinoRepository padrinoRepository;

  public PadrinoServiceImpl(PadrinoRepository padrinoRepository){
    this.padrinoRepository = padrinoRepository;
  }

  public Page<Padrino> index(Pageable pageable) {
    return padrinoRepository.findAll(pageable);
  }

  @Override
  public Padrino registrarPadrino(Padrino padrino) {
    return padrinoRepository.save(padrino);
  }

  @Override
  public Padrino modificarPadrino(Padrino padrino) {
    return padrinoRepository.save(padrino);
  }

  @Override
  public List<Padrino> listaPadrinos() {
    return padrinoRepository.findAll();
  }

  @Override
  public Padrino obtenerPadrinoPorId(Integer idPadrino) {
    return padrinoRepository.findById(idPadrino).orElse(new Padrino());
  }

  @Override
  public void eliminarPadrino(Integer idPadrino) {
    padrinoRepository.deleteById(idPadrino);
  }



}
