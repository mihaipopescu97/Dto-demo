package com.example.demo.controllers;

import com.example.demo.dtos.RoleDto;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getRoleById(@RequestParam(name = "id") final Long id) {
        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody final RoleDto roleDto) {
        return new ResponseEntity<>(roleService.createRole(roleDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateRole(@RequestBody final RoleDto roleDto) {
        return new ResponseEntity<>(roleService.updateRole(roleDto), HttpStatus.OK);
    }
}
