package org.example.service;

import jakarta.validation.Valid;
import org.example.model.TaskDTO;

import java.util.List;

public interface TaskService {
    void createTask (TaskDTO taskDTO);
    List<TaskDTO> getTasks ();
    TaskDTO getTask (Long id);
    void deleteTask(Long id);
    void updateTask(Long id, TaskDTO taskDTO);
}
