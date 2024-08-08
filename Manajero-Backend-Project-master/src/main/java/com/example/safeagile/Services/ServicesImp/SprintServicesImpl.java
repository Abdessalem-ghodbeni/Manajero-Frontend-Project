package com.example.safeagile.Services.ServicesImp;

import com.example.safeagile.Models.Sprint;
import com.example.safeagile.Models.Task;
import com.example.safeagile.Models.UserStory;
import com.example.safeagile.Repositories.ISprintRepository;
import com.example.safeagile.Repositories.ITaskRepository;
import com.example.safeagile.Repositories.IUserStoryRepository;
import com.example.safeagile.Services.IServices.ISprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SprintServicesImpl implements ISprintService {

    @Autowired
    private final ISprintRepository sprintRepository;

    @Autowired
    private final IUserStoryRepository userStoryRepository;
    @Override
    public Sprint createSprint(Sprint sprint) {
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint cannot be null");
        }

        // Handle the user stories, allowing null user stories or missing user stories
        List<UserStory> userStories = sprint.getUserStory() != null ?
                sprint.getUserStory().stream()
                        .map(userStory -> {
                            if (userStory == null || userStory.getId() == null) {
                                return null;
                            }
                            // Fetch the existing user story from the repository by its ID
                            return userStoryRepository.findById(userStory.getId()).orElse(null);
                        })
                        .filter(Objects::nonNull) // Only keep user stories that exist
                        .collect(Collectors.toList())
                : Collections.emptyList(); // Default to an empty list if user stories are null

        // Set the valid user stories in the Sprint
        sprint.setUserStory(userStories);

        // Save the Sprint to the repository
        return sprintRepository.save(sprint);
    }

    @Override
    public List<Sprint> createSprint(List<Sprint> sprints) {
        return null;
    }


    @Override
    public Sprint getSprintById(String id) {
        return sprintRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint updateSprint(String id, Sprint newSprintData) {
        // Check if the sprint exists
        Sprint existingSprint = sprintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id: " + id));

        // Update fields if provided
        if (newSprintData.getName() != null) {
            existingSprint.setName(newSprintData.getName());
        }
        if (newSprintData.getGoal() != null) {
            existingSprint.setGoal(newSprintData.getGoal());
        }
        if (newSprintData.getStartDate() != null) {
            existingSprint.setStartDate(newSprintData.getStartDate());
        }
        if (newSprintData.getEndDate() != null) {
            existingSprint.setEndDate(newSprintData.getEndDate());
        }
        if (newSprintData.getUserStory() != null) {
            List<UserStory> userStories = newSprintData.getUserStory().stream()
                    .map(userStory -> {
                        if (userStory.getId() != null) {
                            return userStoryRepository.findById(userStory.getId()).orElse(null);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            existingSprint.setUserStory(userStories);
        }

        // Save and return the updated Sprint
        return sprintRepository.save(existingSprint);
    }



    @Override
    public void deleteSprint(String id) {
        sprintRepository.deleteById(id);
    }



}