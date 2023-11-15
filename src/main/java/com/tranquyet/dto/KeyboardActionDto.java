package com.tranquyet.dto;

import com.tranquyet.enums.KeyboardActionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class KeyboardActionDto extends BasedDto{
    private String key;
    private String description;
    private KeyboardActionType keyboardActionType;
    private String action;
    private KeyValue keyValue;
}
