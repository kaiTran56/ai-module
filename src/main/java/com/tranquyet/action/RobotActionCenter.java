package com.tranquyet.action;

import com.tranquyet.dto.KeyboardActionDto;
import com.tranquyet.dto.MouseActionDto;

import java.util.List;

import static com.tranquyet.event.GlobalMouseListener.robot;

public class RobotActionCenter implements RobotAction {
    public void robotActionFactory(List<Object> actions) {
        actions.forEach(p -> {
            if (p instanceof MouseActionDto dto) {
                MouseAction.getInstance().mousesActionFactory(dto, robot);
            } else if (p instanceof KeyboardActionDto key){
                KeyboardAction.getInstance().keyboardActionFactory(key, robot);
            }
        });
    }

}
