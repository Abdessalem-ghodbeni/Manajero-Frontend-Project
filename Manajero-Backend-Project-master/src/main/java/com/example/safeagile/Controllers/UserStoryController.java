package com.example.safeagile.Controllers;

import com.example.safeagile.Models.UserStory;
import com.example.safeagile.Services.ServicesImp.UserStoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/us")
@CrossOrigin("*")
@Slf4j
@RequiredArgsConstructor
public class UserStoryController {
    @Autowired
    private UserStoryServiceImpl userStoryService;


    @PostMapping
    public UserStory createUserStory(@RequestBody UserStory userStory) {
        return userStoryService.createUserStory(userStory);
    }

    @PostMapping("/batch")
    public List<UserStory> createUserStories(@RequestBody List<UserStory> userStories) {
        return userStoryService.createUserStories(userStories);
    }

    @GetMapping("/{id}")
    public UserStory getUserStoryById(@PathVariable String id) {
        return userStoryService.getUserStoryById(id);
    }

    @GetMapping
    public ResponseEntity<List<UserStory>> getAllUserStories() {
        List<UserStory> userStories = userStoryService.getAllUserStories();
        return ResponseEntity.ok(userStories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserStory> updateUserStory(@PathVariable String id, @RequestBody UserStory userStory) {
        UserStory updatedUserStory = userStoryService.updateUserStory(id, userStory);
        if (updatedUserStory != null) {
            return ResponseEntity.ok(updatedUserStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserStory(@PathVariable String id) {
        userStoryService.deleteUserStory(id);
        return ResponseEntity.noContent().build();
    }
}