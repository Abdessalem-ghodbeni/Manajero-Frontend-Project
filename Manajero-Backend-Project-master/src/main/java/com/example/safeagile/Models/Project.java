package com.example.safeagile.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "projects")
@Getter
@Setter

public class Project {

  @Id

  private String id;

  @Field("name")
  private String name;

  @Field("description")
  private String description;


}
