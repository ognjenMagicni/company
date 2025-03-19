package com.transport.repository;

import com.transport.entity.UserCred;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredRepository extends JpaRepository<UserCred,String> {
    public UserCred findByUsername(String username);

}
