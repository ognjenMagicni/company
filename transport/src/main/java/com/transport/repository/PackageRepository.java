package com.transport.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.entity.Package;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package,Integer> {
    public List<Package> findByStage(Integer stage);

    public List<Package> findByFkDriverAndStage(String username, Integer stage);

    @Transactional
    @Modifying
    @Query(value= """
                update Package package set package.stage=2, package.fkDriver=?1 where package.idPackage=?2
            """)
    public void insertDriverPackage(String username, Integer id);

    @Transactional
    @Modifying
    @Query(value= """
                update Package package set package.stage=3 where package.idPackage=?2 and package.fkDriver=?1
            """)
    public void accepted2delivered(String username, Integer id);

    @Transactional
    @Modifying
    @Query(value= """
                update Package package set package.grade=?2, package.comment=?3 where package.idPackage=?1
            """)
    public void updatePackageGrade(Integer id, Integer grade, String comment);

}
