package com.example.safeagile.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Document(collection = "Sprint")
public class Sprint {
  @Id
  private String id;

  private String name;
  private String goal;
  private Date startDate;
  private Date endDate;

  @DBRef
  private List<UserStory> userStory; // List of UserStory objects
}
