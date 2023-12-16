package com.tranquyet.repository;

import com.tranquyet.dto.LogActionDTO;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class LogActionRepositoryImpl implements LogActionRepository{
    @Override
    public Flux<LogActionDTO> getReactiveLogs(LogActionDTO logActionDTO) {
        return null;
    }
}
