package com.jwt.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Model, Long> {
    Model findByUsername(String username);

}
