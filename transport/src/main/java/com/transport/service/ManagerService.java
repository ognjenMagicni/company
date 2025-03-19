package com.transport.service;

import com.transport.dto.DriverVehicleDTO;
import com.transport.dto.UserRegisterDto;
import com.transport.entity.*;
import com.transport.repository.DriverRepository;
import com.transport.repository.ManagerRepository;
import com.transport.repository.UserCredRepository;
import com.transport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    UserCredRepository userCredRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Vehicle findByIdVehicle(String username){
        return vehicleRepository.findById(username).orElseThrow();
    }

    public Manager findById(String username){
        return managerRepository.findById(username).orElseThrow();
    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<Vehicle> sortBySmallService(){
        return vehicleRepository.sortBySmallService();
    }

    public List<Vehicle> sortByBigService(){
        return vehicleRepository.sortByBigService();
    }

    public List<Vehicle> sortByKm(){
        return vehicleRepository.sortByKm();
    }

    public List<Vehicle> sortByYear(){
        return vehicleRepository.sortByYear();
    }

    public List<Vehicle> getUnusedVehicles(){
        return vehicleRepository.getUnusedVehicles();
    }

    public Vehicle insertVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public void insertDriverVehicle(DriverVehicleDTO driverVehicle){
        driverRepository.addVehicle(driverVehicle.getIdVehicle(),driverVehicle.getIdDriver());
        Driver driver = driverRepository.findById(driverVehicle.getIdDriver()).orElseThrow();
        vehicleRepository.addDriver(driver,driverVehicle.getIdVehicle());
    }

    public void removeDriverVehicle(DriverVehicleDTO driverVehicleDTO){
        driverRepository.removeeVehicle(driverVehicleDTO.getIdDriver());
        vehicleRepository.removeDriver(driverVehicleDTO.getIdVehicle());
    }

    public void removeVehicle(String idVehicle){
        driverRepository.removeVehicle(idVehicle);
        vehicleRepository.deleteVehicle(idVehicle);
    }

    public void removeDriver(String username){
        driverRepository.deleteById(username);
    }

    public void editVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void editDriver(Driver driver){
        driverRepository.save(driver);
    }

    public Driver insertDriver(UserRegisterDto userDTO){
        UserCred userCredExist = userCredRepository.findByUsername(userDTO.getUsername());
        if(userCredExist!=null)
            return null;

        userDTO.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        Driver driver = new Driver(userDTO);
        UserCred userCred = new UserCred();
        userCred.setByUserRegisterDTO(userDTO);
        userCred.setFkRole(2);

        System.out.println(userCred);

        userCred = userCredRepository.save(userCred);
        driver = driverRepository.save(driver);

        return driver;
    }

    public List<Driver> findDriversFkVehicleNull(){
        return driverRepository.findByFkVehicleIsNull();
    }

}
