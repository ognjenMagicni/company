package com.transport.repository;

import com.transport.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,String> {
    public Optional<Manager> findById(String username);
}
