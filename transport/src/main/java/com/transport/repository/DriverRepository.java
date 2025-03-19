package com.transport.repository;

import com.transport.entity.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {
    public Optional<Driver> findById(String username);

    @Transactional
    @Modifying
    @Query(value= """
                update Driver driver set fkVehicle=NULL where driver.fkVehicle=?1
            """)
    public void removeVehicle(String username);

    @Transactional
    @Modifying
    @Query(value= """
                update Driver driver set fkVehicle=NULL where driver.idDriver=?1
            """)
    public void removeeVehicle(String username);

    @Transactional
    @Modifying
    @Query(value= """
                update Driver driver set driver.fkVehicle=?1 where driver.idDriver=?2
            """)
    public void addVehicle(String idVehicle, String idDriver);



    public List<Driver> findByFkVehicleIsNull();
}
