package com.foroHub.repository;

import com.foroHub.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Page<Topic> findAllByOrderByFechaCreacionAsc(Pageable pageable);
    Page<Topic> findByCursoId(Integer cursoId, Pageable pageable);
    Page<Topic> findByYear(Integer year, Pageable pageable);

    Page<Topic> findByCursoIdAndYear(Integer cursoId, Integer year, Pageable pageable);
    Optional<Topic> findByTituloAndMensaje(String titulo, String mensaje);
}
