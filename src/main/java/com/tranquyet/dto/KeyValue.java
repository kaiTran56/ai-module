package com.tranquyet.dto;

import lombok.Getter;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Getter
public enum KeyValue {
    LEFT_CONTROL(KeyEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Left Control"),
    CONTROL(KeyEvent.CTRL_MASK, NativeKeyEvent.CTRL_MASK, "Control"),
    LEFT_ALT(KeyEvent.ALT_MASK, NativeKeyEvent.ALT_L_MASK, "Left Alt"),
    LEFT_META(KeyEvent.VK_WINDOWS, NativeKeyEvent.META_L_MASK, "Left Meta"),
    RIGHT_META(KeyEvent.VK_WINDOWS, NativeKeyEvent.META_R_MASK, "Right Meta"),

//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Right Control"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Right Alt"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Slash"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Right Shift"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Left Shift"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Caps Lock"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Caps Lock"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Tab"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Escape"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F1"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F2"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F3"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F4"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F5"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F6"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F7"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F8"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F9"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F10"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F11"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "F12"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Scroll Lock"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Pause"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Insert"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Home"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Page Up"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Page Down"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "End"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Delete"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Left"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Down"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Right"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Up"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Insert"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Delete"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Enter"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "NumPad Add"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "NumPad Subtract"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "NumPad Multiply"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "NumPad Divide"),
//    LEFT_CONTROL(ActionEvent.CTRL_MASK, NativeKeyEvent.CTRL_L_MASK, "Num Lock");
    private int actionEvent;
    private int nativeKeyEvent;
    private String action;
    KeyValue(int actionEvent, int nativeKeyEvent, String action){
        this.actionEvent = actionEvent;
        this.nativeKeyEvent = nativeKeyEvent;
        this.action = action;
    }
}
