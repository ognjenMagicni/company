package com.transport.repository;

import com.transport.entity.Package;
import com.transport.entity.User;
import jakarta.transaction.Transactional;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findById(String id);

    @Query(value= """
                select user from User user where user.idUser=?1
            """)
    public User getUserById(String id);

    @Query(value= """
                select p from Package p where p.fkUser=?1 and p.stage=1
            """)
    public List<Package> getAllWaitingPackages(String id);

    @Query(value= """
                select p from Package p where p.fkUser=?1 and p.stage=2
            """)
    public List<Package> getAllAcceptedPackages(String id);

    @Query(value= """
                select p from Package p where p.fkUser=?1 and p.stage=3
            """)
    public List<Package> getAllDeliveredPackages(String id);

    @Query(value= """
                select p from Package p where p.fkUser=?1 and p.idPackage=?2
            """)
    public Package getPackage(String idUser, Integer idPackage);

    @Transactional
    @Modifying
    @Query(value= """
                delete Package package where package.stage=1 and package.fkUser=?1 and package.idPackage=?2
            """)
    public void deleteByIdQ(String idUser, Integer idPackage);




}
