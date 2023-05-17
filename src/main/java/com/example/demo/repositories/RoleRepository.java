package com.example.demo.repositories;

import com.example.demo.entities.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findRoleByIsAdmin(final String name);


    Optional<Role> findByNameAndIsAdmin(String name, boolean isAdmin);

    @Transactional
    @Modifying
    @Query("update Role r set r.name = ?2 where r.id = ?1")
    void updateRoleById(final Long id, final String name);
}
