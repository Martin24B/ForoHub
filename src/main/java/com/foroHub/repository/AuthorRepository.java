package com.foroHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foroHub.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
}

