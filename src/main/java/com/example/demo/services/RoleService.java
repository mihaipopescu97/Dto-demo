package com.example.demo.services;

import com.example.demo.dtos.RoleDto;
import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class RoleService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    public RoleDto getRoleById(final Long id) {
        final Role foundRole = roleRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found!"));

        return modelMapper.map(foundRole, RoleDto.class);
    }

    public RoleDto createRole(final RoleDto roleDto) {
        final Role role = modelMapper.map(roleDto, Role.class);
        final Role savedRole = roleRepository.save(modelMapper.map(roleDto, Role.class));
        return modelMapper.map(savedRole, RoleDto.class);
    }

    public RoleDto updateRole(final RoleDto roleDto) {
        final Optional<Role> optionalRole = roleRepository.findByNameAndIsAdmin(roleDto.getName(), roleDto.isAdmin());

        if (optionalRole.isPresent()) {
            roleRepository.updateRoleById(optionalRole.get().getId(), "updatedName");
            final Role updatedRole = roleRepository.findById(optionalRole.get().getId()).get();
            return modelMapper.map(updatedRole, RoleDto.class);
        }

        return null;
    }
}
