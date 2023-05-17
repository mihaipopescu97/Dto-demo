package com.example.demo.services;

import com.example.demo.dtos.UserDto;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MappingService mappingService;

    public UserDto getUserById(final long id) {
        final User foundUser =  userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));

        return mappingService.convertUserIntoDto(foundUser);
    }

    public User createUser(final UserDto userDto) {
        final User user = mappingService.convertDtoIntoUser(userDto);

        return userRepository.save(user);
    }
}
