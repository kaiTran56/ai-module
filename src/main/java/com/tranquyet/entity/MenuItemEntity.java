package com.tranquyet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "items")
@Getter
@Setter
@EqualsAndHashCode
public class MenuItemEntity extends BasedEntity{
    @Column(name = "class_name", columnDefinition = "TEXT")
    private String className;
    @Column(name = "obj_type", columnDefinition = "TEXT")
    private String objType;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;
    @Column(name = "par_content", columnDefinition = "TEXT")
    private String parContent;
    @Column(name = "first_date", columnDefinition = "DATE")
    private Date firstDate;
    @Column(name = "updated_date", columnDefinition = "DATE")
    private Date updatedDate;

}
