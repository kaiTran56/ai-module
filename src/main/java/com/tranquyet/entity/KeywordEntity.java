package com.tranquyet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "keywords")
@Getter
@Setter
public class KeywordEntity extends BasedEntity {
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "id_account", columnDefinition = "INTEGER")
    private Long idAccount;
}
