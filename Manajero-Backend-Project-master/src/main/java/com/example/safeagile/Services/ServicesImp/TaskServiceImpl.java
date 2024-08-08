package com.example.safeagile.Services.ServicesImp;

import com.example.safeagile.Models.Backlog;
import com.example.safeagile.Models.Task;
import com.example.safeagile.Repositories.IBacklogRepository;
import com.example.safeagile.Repositories.ITaskRepository;
import com.example.safeagile.Services.IServices.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements ITaskService {
    @Autowired
    private final ITaskRepository taskRepository;


    @Autowired
    private IBacklogRepository backlogRepository; // Ensure you have a repository for Backlog

    @Override

    public Task createTask(Task task) {
        if (task.getBacklog() != null && task.getBacklog().get_id() != null) {
            Optional<Backlog> backlogOptional = backlogRepository.findById(task.getBacklog().get_id());
            if (backlogOptional.isEmpty()) {
                throw new IllegalArgumentException("Backlog with the provided ID does not exist.");
            }
        } else {
            log.error("Backlog reference is missing or invalid.");
        }

        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(String id, Task task) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setSprintId(task.getSprintId());
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            existingTask.setStartDate(task.getStartDate());
            existingTask.setEndDate(task.getEndDate());
            existingTask.setAssignee(task.getAssignee());
            existingTask.setBacklog(task.getBacklog());
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
