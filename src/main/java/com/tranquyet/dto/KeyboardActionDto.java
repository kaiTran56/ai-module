package com.tranquyet.dto;

import com.tranquyet.enums.KeyValue;
import com.tranquyet.enums.KeyboardActionType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeyboardActionDto extends BasedDto{
    private String key;
    private String description;
    private KeyboardActionType keyboardActionType;
    private String action;
    private KeyValue keyValue;
}
