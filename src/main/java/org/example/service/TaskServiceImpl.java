package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.ErrorCode;
import org.example.exceptions.NotFoundException;
import org.example.mappers.TaskMapper;
import org.example.model.TaskDTO;
import org.example.model.TaskEntity;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.example.exceptions.StringUtil.TASK_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public void createTask(TaskDTO taskDTO) {
        taskRepository.save(taskMapper.DTOtoEntity(taskDTO));
    }

    @Override
    public List<TaskDTO> getTasks() {
        return taskMapper.entityListToDTO(taskRepository.findAll());
    }

    @Override
    public TaskDTO getTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(TASK_NOT_FOUND));
        return taskMapper.entityToDTO(taskEntity);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new NotFoundException(TASK_NOT_FOUND));
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(Long id, TaskDTO taskDTO) {
        taskRepository.findById(id).orElseThrow(() -> new NotFoundException(TASK_NOT_FOUND));
        var taskEntity = taskMapper.DTOtoEntity(taskDTO);
        taskEntity.setId(id);
        taskRepository.save(taskEntity);
    }
}
