package com.foroHub.service;

import com.foroHub.model.Topic;
import com.foroHub.model.TopicDTO;
import com.foroHub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Page<Topic> getAllTopics(Pageable pageable) {
        return topicRepository.findAllByOrderByFechaCreacionAsc(pageable);
    }

    public Page<Topic> getTopicsByFilters(Integer cursoId, Integer year, Pageable pageable) {
        if (cursoId != null && year != null) {
            return topicRepository.findByCursoIdAndFechaCreacionYear(cursoId, year, pageable);
        } else if (cursoId != null) {
            return topicRepository.findByCursoId(cursoId, pageable);
        } else if (year != null) {
            return topicRepository.findByFechaCreacionYear(year, pageable);
        } else {
            return getAllTopics(pageable);
        }
    }

    public Topic createTopic(@Valid TopicDTO topicDTO) {

        Optional<Topic> existingTopic = topicRepository.findByTituloAndMensaje(topicDTO.getTitulo(), topicDTO.getMensaje());
        if (existingTopic.isPresent()) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }

 
        Topic topic = new Topic();
        topic.setTitulo(topicDTO.getTitulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setFechaCreacion(LocalDateTime.now()); 
        topic.setStatus("ACTIVO"); 
        topic.setAutorId(topicDTO.getAutorId());
        topic.setCursoId(topicDTO.getCursoId());

        return topicRepository.save(topic);
    }
    
    public Topic getTopicById(Integer id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con el ID: " + id));
    }
    
    public Topic updateTopic(Integer id, Topic updatedTopic) {
      
        Topic existingTopic = getTopicById(id); 

        
        existingTopic.setTitulo(updatedTopic.getTitulo());
        existingTopic.setMensaje(updatedTopic.getMensaje());
        existingTopic.setStatus(updatedTopic.getStatus());
        existingTopic.setAutorId(updatedTopic.getAutorId());
        existingTopic.setCursoId(updatedTopic.getCursoId());

       
        return topicRepository.save(existingTopic);
    }
    
    public void deleteTopic(Integer id) {
        
        Topic topic = getTopicById(id);  
        topicRepository.deleteById(id);  
    }
}
