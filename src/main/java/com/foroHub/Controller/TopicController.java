package com.foroHub.Controller;

import com.foroHub.model.Topic;
import com.foroHub.model.TopicDTO;
import com.foroHub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<Page<Topic>> getAllTopics(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam Optional<Integer> cursoId,
            @RequestParam Optional<Integer> year) {

        if (cursoId.isPresent() || year.isPresent()) {
            Page<Topic> topics = topicService.getTopicsByFilters(cursoId.orElse(null), year.orElse(null), pageable);
            return ResponseEntity.ok(topics);
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
        return topicService.getTopicById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Integer id, @RequestBody Topic updatedTopic) {
        return topicService.updateTopic(id, updatedTopic)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        if (topicService.deleteTopic(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
