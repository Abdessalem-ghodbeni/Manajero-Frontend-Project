package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Sprint;
import com.example.safeagile.Models.UserStory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserStoryRepository extends MongoRepository<UserStory,String> {
}
