package com.tranquyet.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actions")
@Getter
@Setter
@EqualsAndHashCode
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "x", columnDefinition = "INTEGER")
    private int x;
    @Column(name = "y", columnDefinition = "INTEGER")
    private int y;
    @Column(name = "wheel", columnDefinition = "INTEGER")
    private int wheel;
    @Column(name = "action", columnDefinition = "TEXT")
    private String action;
    @Column(name = "value", columnDefinition = "INTEGER")
    private Long value;
    @Column(name = "tag", columnDefinition = "TEXT")
    private String tag;
    @Column(name = "key_value", columnDefinition = "TEXT")
    private String key;
    @Column(name = "key", columnDefinition = "TEXT")
    private String description;
    @Column(name = "delay", columnDefinition = "INTEGER")
    private Long delay;
    @Column(name = "action_type", columnDefinition = "TEXT")
    private String actionType;
    @Column(name = "created_date", columnDefinition = "REAL")
    private Long createdDate;
}
