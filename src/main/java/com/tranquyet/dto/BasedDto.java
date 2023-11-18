package com.tranquyet.dto;

import lombok.Builder;
import lombok.Data;

@Data
public abstract class BasedDto {
    private Long id;
    private Long status;
    private String actionType;
    private Long createdDate;
}
