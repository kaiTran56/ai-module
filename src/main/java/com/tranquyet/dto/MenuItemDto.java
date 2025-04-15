package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuItemDto extends BasedDto{
    private String className;
    private String objType;
    private String content;
    private String url;
    private String parContent;
}
