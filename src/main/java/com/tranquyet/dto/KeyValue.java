package com.tranquyet.dto;

import lombok.Getter;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.KeyEvent;
import java.util.Arrays;

@Getter
public enum KeyValue {
    LEFT_CONTROL(KeyEvent.VK_CONTROL, NativeKeyEvent.CTRL_L_MASK, "Left Control"),
    CONTROL(KeyEvent.VK_CONTROL, NativeKeyEvent.CTRL_MASK, "Control"),
    LEFT_ALT(KeyEvent.VK_CONTROL, NativeKeyEvent.ALT_L_MASK, "Left Alt"),
    LEFT_META(KeyEvent.VK_WINDOWS, NativeKeyEvent.META_L_MASK, "Left Meta"),
    RIGHT_META(KeyEvent.VK_WINDOWS, NativeKeyEvent.META_R_MASK, "Right Meta"),
    RIGHT_SHIFT(KeyEvent.VK_SHIFT, NativeKeyEvent.SHIFT_R_MASK, "Right Shift"),
    LEFT_SHIFT(KeyEvent.VK_SHIFT, NativeKeyEvent.SHIFT_L_MASK, "Left Shift"),
    SHIFT(KeyEvent.VK_SHIFT, NativeKeyEvent.SHIFT_MASK, "Left Shift"),
    CAPS_LOCK(KeyEvent.VK_CAPS_LOCK, NativeKeyEvent.VC_CAPS_LOCK, "Caps Lock"),
    TAB(KeyEvent.VK_TAB, NativeKeyEvent.VC_TAB, "Tab"),
    SCROLL_LOCK(KeyEvent.VK_SCROLL_LOCK, NativeKeyEvent.VC_SCROLL_LOCK, "Scroll Lock"),
    PAUSE(KeyEvent.VK_PAUSE, NativeKeyEvent.VC_PAUSE, "Pause"),
    INSERT(KeyEvent.VK_INSERT, NativeKeyEvent.VC_INSERT, "Insert"),
    HOME(KeyEvent.VK_HOME, NativeKeyEvent.VC_HOME, "Home"),
    PAGE_UP(KeyEvent.VK_PAGE_UP, NativeKeyEvent.VC_PAGE_UP, "Page Up"),
    PAGE_DOWN(KeyEvent.VK_PAGE_DOWN, NativeKeyEvent.VC_PAGE_DOWN, "Page Down"),
    END(KeyEvent.VK_END, NativeKeyEvent.VC_END, "End"),
    DELETE(KeyEvent.VK_DELETE, NativeKeyEvent.VC_DELETE, "Delete"),
    LEFT(KeyEvent.VK_LEFT, NativeKeyEvent.VC_LEFT, "Left"),
    DOWN(KeyEvent.VK_DOWN, NativeKeyEvent.VC_DOWN, "Down"),
    RIGHT(KeyEvent.VK_RIGHT, NativeKeyEvent.VC_RIGHT, "Right"),
    UP(KeyEvent.VK_UP, NativeKeyEvent.VC_UP, "Up"),
    ENTER(KeyEvent.VK_ENTER, NativeKeyEvent.VC_ENTER, "Enter"),
    NUMPAD_ADD(KeyEvent.VK_ADD, NativeKeyEvent.VC_KP_ADD, "NumPad Add"),
    NUMPAD_SUBTRACT(KeyEvent.VK_SUBTRACT, NativeKeyEvent.VC_KP_SUBTRACT, "NumPad Subtract"),
    NUMPAD_MULTIPLY(KeyEvent.VK_MULTIPLY, NativeKeyEvent.VC_KP_MULTIPLY, "NumPad Multiply"),
    NUMPAD_DIVIDE(KeyEvent.VK_DIVIDE, NativeKeyEvent.VC_KP_DIVIDE, "NumPad Divide"),
    NUM_LOCK(KeyEvent.VK_NUM_LOCK, NativeKeyEvent.VC_NUM_LOCK, "Num Lock"),
    MINUS_CHARACTER(KeyEvent.VK_MINUS, NativeKeyEvent.VC_MINUS, "-"),
    SPACE(KeyEvent.VK_SPACE, NativeKeyEvent.VC_SPACE, " "),
    ESC(KeyEvent.VK_ESCAPE, NativeKeyEvent.VC_ESCAPE, "\u001B"),
    ASTERISK(KeyEvent.VK_SPACE, NativeKeyEvent.VC_SPACE, "*"),

    F1(KeyEvent.VK_F1, NativeKeyEvent.VC_F1, "F1"),
    F2(KeyEvent.VK_F2, NativeKeyEvent.VC_F2, "F2"),
    F3(KeyEvent.VK_F3, NativeKeyEvent.VC_F3, "F3"),
    F4(KeyEvent.VK_F4, NativeKeyEvent.VC_F4, "F4"),
    F5(KeyEvent.VK_F5, NativeKeyEvent.VC_F5, "F5"),
    F6(KeyEvent.VK_F6, NativeKeyEvent.VC_F6, "F6"),
    F7(KeyEvent.VK_F7, NativeKeyEvent.VC_F7, "F7"),
    F8(KeyEvent.VK_F8, NativeKeyEvent.VC_F8, "F8"),
    F9(KeyEvent.VK_F9, NativeKeyEvent.VC_F9, "F9"),
    F10(KeyEvent.VK_F10, NativeKeyEvent.VC_F10, "F10"),
    F11(KeyEvent.VK_F11, NativeKeyEvent.VC_F11, "F11"),
    F12(KeyEvent.VK_F12, NativeKeyEvent.VC_F12, "F12"),

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
    KEY_Z(KeyEvent.VK_Z, NativeKeyEvent.VC_Z, "Z"),

    KEY_0(KeyEvent.VK_0, NativeKeyEvent.VC_0, "0"),
    KEY_1(KeyEvent.VK_1, NativeKeyEvent.VC_1, "1"),
    KEY_2(KeyEvent.VK_2, NativeKeyEvent.VC_2, "2"),
    KEY_3(KeyEvent.VK_3, NativeKeyEvent.VC_3, "3"),
    KEY_4(KeyEvent.VK_4, NativeKeyEvent.VC_4, "4"),
    KEY_5(KeyEvent.VK_5, NativeKeyEvent.VC_5, "5"),
    KEY_6(KeyEvent.VK_6, NativeKeyEvent.VC_6, "6"),
    KEY_7(KeyEvent.VK_7, NativeKeyEvent.VC_7, "7"),
    KEY_8(KeyEvent.VK_8, NativeKeyEvent.VC_8, "8"),
    KEY_9(KeyEvent.VK_9, NativeKeyEvent.VC_9, "9")
    ;
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
