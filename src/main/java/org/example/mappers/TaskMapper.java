package org.example.mappers;

import org.example.model.TaskDTO;
import org.example.model.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity DTOtoEntity(TaskDTO dto);

    TaskDTO entityToDTO(TaskEntity entity);

    List<TaskDTO> entityListToDTO (List<TaskEntity> entities);
}
