package com.tranquyet.repository;

import com.tranquyet.dto.LogActionDTO;
import reactor.core.publisher.Flux;

public interface LogActionRepository {
    Flux<LogActionDTO> getReactiveLogs(LogActionDTO logActionDTO);
}
