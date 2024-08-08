package com.example.safeagile.Services.IServices;

import com.example.safeagile.Models.Backlog;

import java.util.List;

public interface IBacklogService {
  Backlog addBacklog(Backlog backlog);
  Backlog updateBacklog(Backlog backlog);
  Backlog getBacklogById(String id);
  void deleteBacklog(String id);
  List<Backlog> AllBacklog();

}
