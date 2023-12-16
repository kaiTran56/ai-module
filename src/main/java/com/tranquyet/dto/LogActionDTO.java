package com.tranquyet.dto;

import com.tranquyet.enums.KeyValue;
import com.tranquyet.enums.KeyboardActionType;
import com.tranquyet.enums.MouseActionType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogActionDTO extends BasedDto{
    private String key;
    private String description;
    private KeyboardActionType keyboardActionType;
    private String action;
    private KeyValue keyValue;
    private int x;
    private int y;
    private int wheel;
    private Long value;
    private String tag;
    private MouseActionType mouseActionType;
}
