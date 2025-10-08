package com.Javax.agendadortarefas.business.mapper;

import com.Javax.agendadortarefas.business.dto.TarefasDTO;
import com.Javax.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
