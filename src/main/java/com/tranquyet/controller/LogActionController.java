package com.tranquyet.controller;

import com.tranquyet.dto.LogActionDTO;
import com.tranquyet.repository.LogActionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController("/log")
public class LogActionController {
    @Autowired
    private LogActionRepository logActionRepository;

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<LogActionDTO> feed() {
        Flux<LogActionDTO> reactiveObj = this.logActionRepository.getReactiveLogs(null);
        return reactiveObj;
    }

}
