package com.foroHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foroHub.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
