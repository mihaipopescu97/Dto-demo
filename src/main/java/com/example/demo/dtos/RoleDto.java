package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoleDto {

    private String name;

    @JsonProperty("isAdmin")
    private boolean isAdmin;
}
