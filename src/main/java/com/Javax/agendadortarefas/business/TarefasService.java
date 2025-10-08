package com.Javax.agendadortarefas.business;

import com.Javax.agendadortarefas.business.dto.TarefasDTO;
import com.Javax.agendadortarefas.business.mapper.TarefasConverter;
import com.Javax.agendadortarefas.infrastructure.Enums.StatusNotificacaoEnum;
import com.Javax.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.Javax.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.Javax.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
