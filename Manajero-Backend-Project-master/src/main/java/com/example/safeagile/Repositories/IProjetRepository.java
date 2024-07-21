package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProjetRepository extends MongoRepository<Project,String> {
}
