package com.tranquyet.enums;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public enum MouseActionType {
    PRESSED("pressed", null, "PR"),
    LEFT_RELEASE("left released", 1L, "LR"),
    MOVED("moved", null, "MV"),
    RIGHT_RELEASE("right released", 2L, "RR"),
    LEFT_DRAGGED_CLICK("Left Dragged click", 256L, "LDC"),
    RIGHT_DRAGGED_CLICK("Right Dragged click", 512L, "RDC"),
    LEFT_DRAGGED_RELEASE("Left Dragged release", 256L, "LDR"),
    RIGHT_DRAGGED_RELEASE("Right Dragged click", 512L, "RDR"),
    WHEEL_DRAGGED_PRESS("Right Dragged click", 1024L, "WDP"),
    WHEEL_DRAGGED_RELEASE("Right Dragged click", 1024L, "WDR"),
    RIGHT_CLICK("right clicked", 2L, "RC"),
    LEFT_CLICK("left clicked", 1L, "LC"),
    WHEEL("wheeled", 1L, "WH");
    private String action;
    private Long value;
    private String tag;
    MouseActionType(String action, Long value, String tag){
        this.action = action;
        this.value = value;
        this.tag = tag;
    }
    public static MouseActionType fromValue(Long value, String tag){
        MouseActionType type =  Arrays.stream(values()).filter(p->p.getValue()!=null)
                .filter(p->p.getValue().equals(value)
                && p.getTag().equals(tag)).findFirst().orElse(null);
        return type;
    }
    public static MouseActionType fromTag(String tag){
        MouseActionType type =  Arrays.stream(values())
                .filter(p->p.getTag().equals(tag)).findFirst().orElse(null);
        return type;
    }
}
