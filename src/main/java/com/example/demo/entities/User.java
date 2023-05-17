package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "USER", schema = "public")
public class User extends BaseEntity{

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;
}

