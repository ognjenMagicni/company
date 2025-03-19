package com.transport.service;

import com.transport.entity.Driver;
import com.transport.entity.Package;
import com.transport.repository.DriverRepository;
import com.transport.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    PackageRepository packageRepository;

    public Driver getDriver(String id){
        Driver driver = driverRepository.findById(id).orElseThrow();
        if(driver==null)
            return null;
        return driver;
    }

    public List<Package> getAllWaitingPackage(){
        return packageRepository.findByStage(1);
    }

    public void insertDriverPackage(String username, Integer id){
        packageRepository.insertDriverPackage(username,id);
    }

    public void accepted2delivered(String username, Integer id){
        System.out.println(username);
        System.out.println(id);
        packageRepository.accepted2delivered(username,id);
    }

    public List<Package> findByFkDriverAndStage(String username, Integer stage){
        return packageRepository.findByFkDriverAndStage(username,stage);
    }
}
