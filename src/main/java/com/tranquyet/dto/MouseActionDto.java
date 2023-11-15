package com.tranquyet.dto;

import com.tranquyet.enums.MouseActionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class MouseActionDto extends BasedDto{
    private Long x;
    private Long y;
    private Long wheel;
    private String action;
    private Long value;
    private String tag;
    private MouseActionType mouseActionType;
}
