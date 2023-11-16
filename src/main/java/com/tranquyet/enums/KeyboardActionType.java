package com.tranquyet.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum KeyboardActionType {
    PRESSED("pressed"), RELEASED("released"), TYPED("typed");
    private String action;
    KeyboardActionType(String action){
        this.action = action;
    }
}
