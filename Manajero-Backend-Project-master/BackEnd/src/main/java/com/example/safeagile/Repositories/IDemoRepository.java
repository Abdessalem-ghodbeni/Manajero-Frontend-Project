package com.example.safeagile.Repositories;

import com.example.safeagile.Models.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IDemoRepository extends MongoRepository<Demo, String> {

}
