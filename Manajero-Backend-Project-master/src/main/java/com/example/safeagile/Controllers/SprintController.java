package com.example.safeagile.Controllers;

import com.example.safeagile.Models.Sprint;
import com.example.safeagile.Models.UserStory;
import com.example.safeagile.Services.IServices.ISprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
@CrossOrigin("*")
@Slf4j
@RequiredArgsConstructor

public class SprintController {

    @Autowired
    private ISprintService sprintService;

    @PostMapping
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint) {
        Sprint savedSprint = sprintService.createSprint(sprint);
        return ResponseEntity.ok(savedSprint);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> getSprintById(@PathVariable String id) {
        Sprint sprint = sprintService.getSprintById(id);
        return sprint != null ? ResponseEntity.ok(sprint) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Sprint>> getAllSprints() {
        List<Sprint> sprints = sprintService.getAllSprints();
        return ResponseEntity.ok(sprints);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sprint> updateSprint(@PathVariable("id") String id, @RequestBody Sprint sprint) {
        try {
            Sprint updatedSprint = sprintService.updateSprint(id, sprint);
            return ResponseEntity.ok(updatedSprint);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSprint(@PathVariable String id) {
        sprintService.deleteSprint(id);
        return ResponseEntity.noContent().build();
    }


}