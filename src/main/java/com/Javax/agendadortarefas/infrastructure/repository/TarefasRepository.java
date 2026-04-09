package com.Javax.agendadortarefas.infrastructure.repository;

import com.Javax.agendadortarefas.infrastructure.Enums.StatusNotificacaoEnum;
import com.Javax.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial,
                                                                        LocalDateTime datafinal,
                                                                        StatusNotificacaoEnum status);

    List<TarefasEntity> findByEmailUsuario(String email);

}
