package com.petsos.api.repositories;

  import com.petsos.api.model.Padrino;
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.stereotype.Repository;

  @Repository
  public interface PadrinoRepository extends JpaRepository<Padrino, Integer> {


}
