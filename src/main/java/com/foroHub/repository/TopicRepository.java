package com.foroHub.repository;

import com.foroHub.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable; 

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

   
    Optional<Topic> findByTituloAndMensaje(String titulo, String mensaje);

    Page<Topic> findByCursoIdAndFechaCreacionYear(Integer cursoId, Integer year, Pageable pageable);

    Page<Topic> findByCursoId(Integer cursoId, Pageable pageable);

    Page<Topic> findByFechaCreacionYear(Integer year, Pageable pageable);

    Page<Topic> findAllByOrderByFechaCreacionAsc(Pageable pageable);
}
