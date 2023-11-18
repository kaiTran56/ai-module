package com.tranquyet.action;

import com.tranquyet.dto.MouseActionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

import static com.tranquyet.event.GlobalMouseListener.robot;

@Slf4j
@Getter
@Setter
public class MouseAction {
    private static MouseAction action;

    private MouseAction() {
    }

    public static MouseAction getInstance() {
        return action != null ? action : new MouseAction();
    }

    protected void mousesActionFactory(MouseActionDto dto, Robot robot) {
        try {

            Thread.sleep(10);

            switch (dto.getMouseActionType()) {
                case MOVED -> moved(dto, robot);
                case LEFT_CLICK -> leftClicked(dto, robot);
                case LEFT_RELEASE -> leftReleased(dto, robot);
                case RIGHT_CLICK -> rightClicked(dto, robot);
                case RIGHT_RELEASE -> rightReleased(dto, robot);
                case WHEEL -> wheeled(dto, robot);
                case LEFT_DRAGGED_CLICK,
                        RIGHT_DRAGGED_CLICK,
                        LEFT_DRAGGED_RELEASE,
                        RIGHT_DRAGGED_RELEASE -> dragged(dto, robot);
                default -> throw new Exception("check again");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(dto);
            throw new RuntimeException(e);
        }
    }

    public void moved(MouseActionDto dto, Robot robot) {
        robot.mouseMove((dto.getX()), Math.toIntExact(dto.getY()));
    }

    public void leftClicked(MouseActionDto dto, Robot robot) {
        moved(dto, robot);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightClicked(MouseActionDto dto, Robot robot) {
        moved(dto, robot);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void leftReleased(MouseActionDto dto, Robot robot) {
        moved(dto, robot);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightReleased(MouseActionDto dto, Robot robot) {
        moved(dto, robot);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void wheeled(MouseActionDto dto, Robot robot) {
        moved(dto, robot);
        robot.mouseWheel(dto.getWheel());
    }

    public void dragged(MouseActionDto dto, Robot robot) {
        switch (dto.getMouseActionType()) {
            case RIGHT_DRAGGED_CLICK -> moved(dto, robot);
            case RIGHT_DRAGGED_RELEASE -> moved(dto, robot);
            case LEFT_DRAGGED_CLICK -> moved(dto, robot);
            case LEFT_DRAGGED_RELEASE -> moved(dto, robot);
        }
    }
}
