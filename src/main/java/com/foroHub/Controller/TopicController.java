package com.foroHub.Controller;

import com.foroHub.service.TopicService;
import com.foroHub.model.Topic;
import com.foroHub.model.TopicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<Page<Topic>> getAllTopics(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) Integer cursoId,
            @RequestParam(required = false) Integer year) {
        
        if (cursoId != null || year != null) {
            return ResponseEntity.ok(topicService.getTopicsByFilters(cursoId, year, pageable));
        }

        Page<Topic> topics = topicService.getAllTopics(pageable);
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid TopicDTO topicDTO) {
        try {
            Topic createdTopic = topicService.createTopic(topicDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Integer id) {
        try {
            Topic topic = topicService.getTopicById(id);
            return ResponseEntity.ok(topic);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    

    
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(
            @PathVariable Integer id, 
            @RequestBody Topic updatedTopic) {

        try {
            
            Topic topic = topicService.updateTopic(id, updatedTopic);
            return ResponseEntity.ok(topic);
        } catch (EntityNotFoundException e) {
           
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        try {
           
            topicService.deleteTopic(id);
            return ResponseEntity.noContent().build();  
        } catch (EntityNotFoundException e) {
      
            return ResponseEntity.notFound().build();
        }
    }
}
