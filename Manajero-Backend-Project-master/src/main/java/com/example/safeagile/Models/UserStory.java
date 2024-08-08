package com.example.safeagile.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "UserStory")
public class UserStory {

    @Id
    private String id;

    private String sprintId; // Assuming it's a String ID, not a reference to another document

    private String title;
    private String description;
    private String priority;
    private TaskStatus status;

    @DBRef
    private List<Task> tasks;
}
