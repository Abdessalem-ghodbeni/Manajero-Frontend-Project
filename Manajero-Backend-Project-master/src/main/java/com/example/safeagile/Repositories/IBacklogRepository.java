package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Backlog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IBacklogRepository extends MongoRepository<Backlog,String> {
  Optional<Backlog> findById(String id);
}
