package com.tranquyet.action;

import com.tranquyet.dto.DelayTimeDto;
import com.tranquyet.dto.KeyboardActionDto;
import com.tranquyet.dto.MouseActionDto;
import com.tranquyet.service.ActionService;
import org.jnativehook.GlobalScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.tranquyet.event.GlobalMouseListener.robot;
@Service
public class RobotActionCenter implements RobotAction {
    @Autowired
    private ActionService actionService;
    public void robotActionFactory(List<Object> actions) {
        actions.forEach(p -> {
            if (p instanceof MouseActionDto dto) {
                MouseAction.getInstance().mousesActionFactory(dto, robot);
            } else if (p instanceof KeyboardActionDto key) {
                KeyboardAction.getInstance().keyboardActionFactory(key, robot);
            }
        });
    }
    public void recordActions(List<Object> actions){
        List<Object> customizedActions = new ArrayList<>();
        customizedActions = new NormalizedAction().normalizedData(actions);
        actionService.insertActions(customizedActions);
    }

    public void robotActionFactory(List<Object> actions, Robot robot) {
//        List<Object> customizedActions = new ArrayList<>();
//        customizedActions = new NormalizedAction().normalizedData(actions);
        actions.forEach(p -> {
            try {
                if (p instanceof MouseActionDto dto) {
                    MouseAction.getInstance().mousesActionFactory(dto, robot);
                } else if (p instanceof KeyboardActionDto key) {
                    KeyboardAction.getInstance().keyboardActionFactory(key, robot);
                }
                else if (p instanceof DelayTimeDto dto) {
                    System.out.println("[DTO]: "+dto);
                    System.out.println("[DELAY]: "+dto.getDelay());
                    Long milis = dto.getDelay() * 1000;
                    Thread.sleep(Math.toIntExact(milis));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

//    public void robotActionFactory(List<Object> actions, Robot robot) {
//        List<Object> customizedActions = new ArrayList<>();
//        customizedActions = new NormalizedAction().normalizedData(actions);
//        customizedActions.forEach(p -> {
//            try {
//                if (p instanceof MouseActionDto dto) {
//                    MouseAction.getInstance().mousesActionFactory(dto, robot);
//                } else if (p instanceof KeyboardActionDto key) {
//                    KeyboardAction.getInstance().keyboardActionFactory(key, robot);
//                }
//                else if (p instanceof DelayTimeDto dto) {
//                    System.out.println("[DELAY]: "+dto.getDelay());
//                    Long milis = dto.getDelay() * 1000;
//                    Thread.sleep(Math.toIntExact(milis));
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }

}
