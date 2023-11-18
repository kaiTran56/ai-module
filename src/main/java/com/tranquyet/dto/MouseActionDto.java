package com.tranquyet.dto;

import com.tranquyet.enums.MouseActionType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MouseActionDto extends BasedDto{
    private int x;
    private int y;
    private int wheel;
    private String action;
    private Long value;
    private String tag;
    private MouseActionType mouseActionType;
}
