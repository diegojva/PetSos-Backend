package com.petsos.api.repositories;

import com.petsos.api.model.Adoptante;
import com.petsos.api.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
