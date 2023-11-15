package com.tranquyet.action;

import com.tranquyet.dto.KeyboardActionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Slf4j
@Getter
@Setter
public class KeyboardAction {
    private static KeyboardAction key;
    private KeyboardAction(){

    }
    public KeyStroke keyStrokeCenter(final String key){
//        int value = switch (key){
//            case -> 0
//            default -> throw new IllegalStateException("Unexpected value: " + key);
//        };
//        return KeyStroke.getKeyStroke;
        return null;
    }
    public static KeyboardAction getInstance(){
        return key != null ?  key : new KeyboardAction();
    }
    protected void keyboardActionFactory(KeyboardActionDto dto, Robot robot){
        try{
            Thread.sleep(10);
            switch (dto.getKeyboardActionType()){
                case PRESSED ->pressed(dto, robot);
                case RELEASED -> released(dto, robot);
                default -> throw new Exception("check again");
            }
        }catch(Exception ex){
            ex.printStackTrace();
           System.out.println(dto);
        }
    }
    public void pressed(KeyboardActionDto dto, Robot robot){
        robot.keyPress(dto.getKeyValue().getKeyEvent());
    }
    public void released(KeyboardActionDto dto, Robot robot){
        robot.keyRelease(dto.getKeyValue().getKeyEvent());
    }
}
