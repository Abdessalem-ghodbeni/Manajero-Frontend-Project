package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISprintRepository extends MongoRepository<Sprint,String> {
}
