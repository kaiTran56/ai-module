package com.tranquyet.mapper;

import com.tranquyet.Constants;
import com.tranquyet.dto.DelayTimeDto;
import com.tranquyet.enums.KeyValue;
import com.tranquyet.dto.KeyboardActionDto;
import com.tranquyet.dto.MouseActionDto;
import com.tranquyet.entity.ActionEntity;
import com.tranquyet.enums.KeyboardActionType;
import com.tranquyet.enums.MouseActionType;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {
    public ActionEntity toEntity(Object action){
        ActionEntity actionEntity = new ActionEntity();
        if (action instanceof MouseActionDto dto){
            actionEntity.setId(dto.getId());
            actionEntity.setX(dto.getX());
            actionEntity.setY(dto.getY());
            actionEntity.setWheel(dto.getWheel());
            actionEntity.setAction(dto.getAction());
            actionEntity.setValue(dto.getValue());
            actionEntity.setTag(dto.getTag());
            actionEntity.setActionType(Constants.MOUSE_ACTION);
            return actionEntity;
        }else if (action instanceof KeyboardActionDto dto){
            actionEntity.setId(dto.getId());
            actionEntity.setKey(dto.getKey());
            actionEntity.setDescription(dto.getDescription());
            actionEntity.setAction(dto.getAction());
            actionEntity.setActionType(Constants.KEYBOARD_ACTION);
            return actionEntity;
        }else if (action instanceof DelayTimeDto dto){
            actionEntity.setId(dto.getId());
            actionEntity.setDelay(dto.getDelay());
            actionEntity.setActionType(Constants.DELAY_ACTION);
            return actionEntity;
        }
        return actionEntity;
    }

    public Object toDto(ActionEntity entity){
        Object obj = switch (entity.getActionType()){
            case Constants.MOUSE_ACTION -> toMouseActionDto(entity);
            case Constants.KEYBOARD_ACTION -> toKeyboardActionDto(entity);
            case Constants.DELAY_ACTION -> {
                DelayTimeDto dto = toDelayActionDto(entity);
                yield dto;
            }
            default -> throw new RuntimeException("CHECK AGAIN!");
        };
        return obj;
    }

    public MouseActionDto toMouseActionDto(ActionEntity action){
        MouseActionDto dto = MouseActionDto.builder()
                .mouseActionType(MouseActionType.fromTag(action.getTag()))
                .value(action.getValue())
                .tag(action.getTag())
                .action(action.getAction())
                .x(action.getX())
                .y(action.getY())
                .build();
        dto.setId(action.getId());
        dto.setStatus(Constants.ACTIVE_MOUSE_ACTION);
        dto.setActionType(Constants.MOUSE_ACTION);
        return dto;
    }
    public KeyboardActionDto toKeyboardActionDto(ActionEntity action){
        KeyboardActionDto keyboardActionDto = KeyboardActionDto.builder()
                .action(action.getAction())
                .keyboardActionType(KeyboardActionType.fromAction(action.getAction()))
                .keyValue(KeyValue.fromContent(action.getKey()))
                .key(action.getKey())
                .description(action.getDescription())
                .build();
        keyboardActionDto.setId(action.getId());
        keyboardActionDto.setStatus(Constants.ACTIVE_KEY_ACTION);
        return keyboardActionDto;
    }
    public DelayTimeDto toDelayActionDto(ActionEntity action){
        DelayTimeDto dto = new DelayTimeDto();
        dto.setId(action.getId());
        dto.setDelay(action.getDelay());
        return dto;
    }
}
