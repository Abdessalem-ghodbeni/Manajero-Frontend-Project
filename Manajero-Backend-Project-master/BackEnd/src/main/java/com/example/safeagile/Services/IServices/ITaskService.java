package com.example.safeagile.Services.IServices;

import com.example.safeagile.Models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    Task createTask(Task task);
    Optional<Task> getTaskById(String id);
    List<Task> getAllTasks();
    Task updateTask(String id, Task task);
    void deleteTask(String id);
}
