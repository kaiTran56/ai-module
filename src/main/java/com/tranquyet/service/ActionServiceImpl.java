package com.tranquyet.service;

import com.tranquyet.entity.ActionEntity;
import com.tranquyet.mapper.ActionMapper;
import com.tranquyet.repository.ActionRepository;
import jakarta.persistence.OrderBy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActionServiceImpl implements ActionService{
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionMapper actionMapper;
    @Override
    public boolean insertActions(List<Object> actions) {
        if(actions==null||actions.isEmpty())
            throw new RuntimeException("[insertActions]: no actions");
        List<ActionEntity> actEntities = actions.stream().map(p->actionMapper.toEntity(p)).toList();
        actionRepository.saveAll(actEntities);
        log.info("[SAVE]: successfully!");

        return true;
    }

    @Override
    public List<Object> getActions() {
        List<Object> actions = new ArrayList<>();
        actions = actionRepository.findAll().stream().map(p->actionMapper.toDto(p)).toList();
        return actions;
    }

    @Override
    public void truncate() {
        log.info("[delete data]");
        actionRepository.deleteAll();
    }
}
