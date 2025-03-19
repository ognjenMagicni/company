package com.transport.repository;

import com.transport.entity.Driver;
import com.transport.entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    public Optional<Vehicle> findByIdVehicle(String username);
    @Transactional
    @Modifying
    @Query(value= """
                select vehicle from Vehicle vehicle ORDER BY vehicle.dateSmallServiceLast
            """)
    public List<Vehicle> sortBySmallService();

    @Transactional
    @Modifying
    @Query(value= """
                select vehicle from Vehicle vehicle ORDER BY vehicle.dateBigServiceLast
            """)
    public List<Vehicle> sortByBigService();

    @Transactional
    @Modifying
    @Query(value= """
                SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.km DESC
            """)
    public List<Vehicle> sortByKm();

    @Transactional
    @Modifying
    @Query(value= """
                SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.year
            """)
    public List<Vehicle> sortByYear();

    @Transactional
    @Modifying
    @Query(value= """
                SELECT vehicle FROM Vehicle vehicle WHERE vehicle.fkDriver IS NULL
                """)
    public List<Vehicle> getUnusedVehicles();

    @Transactional
    @Modifying
    @Query(value= """
                DELETE Vehicle vehicle WHERE vehicle.idVehicle=?1
                """)
    public void deleteVehicle(String idVehicle);

    @Transactional
    @Modifying
    @Query(value= """
                update Vehicle vehicle set vehicle.fkDriver=?1 where vehicle.idVehicle=?2
            """)
    public void addDriver(Driver driver, String idVehicle);

    @Transactional
    @Modifying
    @Query(value= """
                update Vehicle vehicle set fkDriver=NULL where vehicle.idVehicle=?1
            """)
    public void removeDriver(String username);

    










}
