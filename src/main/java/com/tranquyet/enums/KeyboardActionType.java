package com.tranquyet.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public enum KeyboardActionType {
    PRESSED("pressed"), RELEASED("released"), TYPED("typed");
    private String action;
    KeyboardActionType(String action){
        this.action = action;
    }
    public static KeyboardActionType fromAction(String action){
        KeyboardActionType actionType = Arrays.stream(values()).filter(p->p.getAction().equals(action)).findFirst().orElse(null);
        return actionType;
    }
}
