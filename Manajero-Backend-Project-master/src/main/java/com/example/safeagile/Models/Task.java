package com.example.safeagile.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import java.util.Date;
@Getter
@Setter

@Data
@Document(collection = "tasks")
public class Task {
  @Id

  private String _id;

  private String sprintId;


  private String title;

  private String description;


  private TaskStatus status;


  private Date startDate;


  private Date endDate;

  private String assignee;


  @DBRef
  private Backlog backlog;

}
