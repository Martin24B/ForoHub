package com.foroHub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer year; 
    private String titulo;
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Author autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime fechaCreacion;

    
    private String status;

    public Topic() {
    }

    public Topic(TopicDTO topicDTO) {
        this.titulo = topicDTO.getTitulo();
        this.mensaje = topicDTO.getMensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "activo"; 
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
