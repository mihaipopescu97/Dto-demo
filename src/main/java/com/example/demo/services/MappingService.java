package com.example.demo.services;

import com.example.demo.dtos.RoleDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    public User convertDtoIntoUser(final UserDto userDto) {
        final User user = new User();

        user.setName(userDto.getName());
        user.setRole(userDto.getRole() != null ? convertDtoIntoRole(userDto.getRole()) : null);

        return user;
    }

    public Role convertDtoIntoRole(final RoleDto roleDto) {
        final Role role = new Role();

        role.setName(roleDto.getName());
        role.setAdmin(roleDto.isAdmin());

        return role;
    }

    public UserDto convertUserIntoDto(final User user) {
        final UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setRole(user.getRole() != null ? convertRoleIntoDto(user.getRole()) : null);

        return userDto;
    }

    public RoleDto convertRoleIntoDto(final Role role) {
        final RoleDto roleDto = new RoleDto();

        roleDto.setName(role.getName());
        roleDto.setAdmin(role.isAdmin());

        return roleDto;
    }
}
