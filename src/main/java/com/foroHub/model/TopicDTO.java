package com.foroHub.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class TopicDTO {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    @Size(max = 500, message = "El mensaje no puede tener más de 500 caracteres")
    private String mensaje;

    @NotNull(message = "El autor es obligatorio")
    private Integer autorId;

    @NotNull(message = "El curso es obligatorio")
    private Integer cursoId;

    
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

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
}
