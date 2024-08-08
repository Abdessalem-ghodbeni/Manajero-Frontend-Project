package com.example.safeagile.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "backlogs")
public class Backlog {
  @Id
  private String _id;


  @DBRef
  private String projectId;



  @DBRef(lazy = true)
  private List<Task> tasks;





  @DBRef
  private List<Sprint> sprints;
}
