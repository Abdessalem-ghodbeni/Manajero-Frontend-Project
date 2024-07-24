package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Backlog;
import com.example.safeagile.Models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITaskRepository extends MongoRepository<Task,String> {
  List<Task> findByBacklog(Backlog backlog);
}
