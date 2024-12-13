package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.TaskDTO;
import org.example.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskControllerImpl implements TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping
    public void createTask(@RequestBody @Valid TaskDTO taskDTO){
        taskService.createTask(taskDTO);
    }

    @GetMapping
    public List<TaskDTO> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO){
        taskService.updateTask(id, taskDTO);
    }

}
