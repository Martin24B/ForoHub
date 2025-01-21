package com.foroHub.service;

import com.foroHub.model.Author;
import com.foroHub.model.Curso;
import com.foroHub.model.Topic;
import com.foroHub.model.TopicDTO;
import com.foroHub.repository.TopicRepository;
import com.foroHub.repository.AuthorRepository;
import com.foroHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Page<Topic> getAllTopics(Pageable pageable) {
        return topicRepository.findAllByOrderByFechaCreacionAsc(pageable);
    }
 
    public Page<Topic> getTopicsByFilters(Integer cursoId, Integer year, Pageable pageable) {
        if (cursoId != null && year != null) {
            return topicRepository.findByCursoIdAndYear(cursoId, year, pageable);
        } else if (cursoId != null) {
            return topicRepository.findByCursoId(cursoId, pageable);
        } else if (year != null) {
            return topicRepository.findByYear(year, pageable);
        }
        return topicRepository.findAll(pageable);
    }

  
    public Topic createTopic(TopicDTO topicDTO) {
     
        Optional<Topic> existingTopic = topicRepository.findByTituloAndMensaje(topicDTO.getTitulo(), topicDTO.getMensaje());
        if (existingTopic.isPresent()) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }
        
        Author autor = authorRepository.findById(topicDTO.getAutorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));
        Curso curso = cursoRepository.findById(topicDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

       
        Topic topic = new Topic(topicDTO);
        topic.setAutor(autor);
        topic.setCurso(curso); 

       
        return topicRepository.save(topic);
    }

    public Optional<Topic> getTopicById(Integer id) {
        return topicRepository.findById(id);
    }

    @Transactional
    public Optional<Topic> updateTopic(Integer id, Topic updatedTopic) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            updatedTopic.setId(id);
            topicRepository.save(updatedTopic);
            return Optional.of(updatedTopic);
        }
        return Optional.empty();
    }
   
    @Transactional
    public boolean deleteTopic(Integer id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topicRepository.delete(topic.get());
            return true;
        }
        return false;
    }
}
