package com.tranquyet.dto;

import lombok.Getter;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.KeyEvent;
import java.util.Arrays;

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
    KEY_A(KeyEvent.VK_A, NativeKeyEvent.VC_A, "A"),
    KEY_B(KeyEvent.VK_B, NativeKeyEvent.VC_B, "B"),
    KEY_C(KeyEvent.VK_C, NativeKeyEvent.VC_C, "C"),
    KEY_D(KeyEvent.VK_D, NativeKeyEvent.VC_D, "D"),
    KEY_E(KeyEvent.VK_E, NativeKeyEvent.VC_E, "E"),
    KEY_F(KeyEvent.VK_F, NativeKeyEvent.VC_F, "F"),
    KEY_G(KeyEvent.VK_G, NativeKeyEvent.VC_G, "G"),
    KEY_H(KeyEvent.VK_H, NativeKeyEvent.VC_H, "H"),
    KEY_I(KeyEvent.VK_I, NativeKeyEvent.VC_I, "I"),
    KEY_J(KeyEvent.VK_J, NativeKeyEvent.VC_J, "J"),
    KEY_K(KeyEvent.VK_K, NativeKeyEvent.VC_K, "K"),
    KEY_L(KeyEvent.VK_L, NativeKeyEvent.VC_L, "L"),
    KEY_M(KeyEvent.VK_M, NativeKeyEvent.VC_M, "M"),
    KEY_N(KeyEvent.VK_N, NativeKeyEvent.VC_N, "N"),
    KEY_O(KeyEvent.VK_O, NativeKeyEvent.VC_O, "O"),
    KEY_P(KeyEvent.VK_P, NativeKeyEvent.VC_P, "P"),
    KEY_Q(KeyEvent.VK_Q, NativeKeyEvent.VC_Q, "Q"),
    KEY_R(KeyEvent.VK_R, NativeKeyEvent.VC_R, "R"),
    KEY_S(KeyEvent.VK_S, NativeKeyEvent.VC_S, "S"),
    KEY_T(KeyEvent.VK_T, NativeKeyEvent.VC_T, "T"),
    KEY_U(KeyEvent.VK_U, NativeKeyEvent.VC_U, "U"),
    KEY_V(KeyEvent.VK_V, NativeKeyEvent.VC_V, "V"),
    KEY_W(KeyEvent.VK_W, NativeKeyEvent.VC_W, "W"),
    KEY_X(KeyEvent.VK_X, NativeKeyEvent.VC_X, "X"),
    KEY_Y(KeyEvent.VK_Y, NativeKeyEvent.VC_Y, "Y"),
    KEY_Z(KeyEvent.VK_Z, NativeKeyEvent.VC_Z, "Z");
    private int keyEvent;
    private int nativeKeyEvent;
    private String content;

    KeyValue(int keyEvent, int nativeKeyEvent, String content) {
        this.keyEvent = keyEvent;
        this.nativeKeyEvent = nativeKeyEvent;
        this.content = content;
    }
    public static KeyValue fromContent(String content){
        KeyValue value = Arrays.stream(values()).filter(p->p.getContent().equals(content)).findFirst().orElse(null);
        return value;
    }
}
