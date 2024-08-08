package com.example.safeagile.Services.IServices;

import com.example.safeagile.Models.Sprint;

import java.util.List;
import java.util.Optional;

public interface ISprintService {
    Sprint createSprint(Sprint sprint);
    List<Sprint> createSprint(List<Sprint> sprints);
    Sprint getSprintById(String id);
    List<Sprint> getAllSprints();
    Sprint updateSprint(String id, Sprint sprint);
    void deleteSprint(String id);
}
