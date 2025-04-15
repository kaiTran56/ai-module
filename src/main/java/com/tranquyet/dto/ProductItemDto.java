package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductItemDto extends BasedDto{
    private String url;
    private String name;
    private double price;
    private String linkItem;
    private String parItem;
}
