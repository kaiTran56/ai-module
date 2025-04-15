package com.tranquyet.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BasedDto {
    private Long id;
    private Long status;
    private String actionType;
    private Long createdDate;
    private Date updatedDate;
    private Date firstDate;
    private String createdUser;
    private String updatedUSer;
}
