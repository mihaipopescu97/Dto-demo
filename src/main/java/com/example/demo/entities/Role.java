package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "ROLE", schema = "public")
public class Role extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin;
}



