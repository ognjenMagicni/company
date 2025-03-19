package com.transport.controller;

import com.transport.dto.DriverVehicleDTO;
import com.transport.dto.UserRegisterDto;
import com.transport.entity.Driver;
import com.transport.entity.Manager;
import com.transport.entity.Vehicle;
import com.transport.service.ManagerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("{id}")
    public ResponseEntity<Manager> findManagerById(@PathVariable("id") String username){
        Manager manager = managerService.findById(username);
        if(manager==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(manager,HttpStatus.OK);
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<Vehicle> findByIdVehicle(@PathVariable("id") String username){
        Vehicle vehicle = managerService.findByIdVehicle(username);
        if(vehicle==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

    @GetMapping("driver")
    public ResponseEntity<List<Driver>> getAllDrivers(){
        return new ResponseEntity<>(managerService.getAllDrivers(), HttpStatus.OK);
    }

    @GetMapping("drivers_fkvehicle_null")
    public ResponseEntity<List<Driver>> findAllDriversFkVehicleNull(){
        List<Driver> driverList = managerService.findDriversFkVehicleNull();
        return new ResponseEntity<>(driverList,HttpStatus.OK);
    }

    @GetMapping("vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicle(){
        return new ResponseEntity<>(managerService.getAllVehicle(), HttpStatus.OK);
    }

    @GetMapping("small_service")
    public ResponseEntity<List<Vehicle>> sortBySmallService(){
        return new ResponseEntity<>(managerService.sortBySmallService(), HttpStatus.OK);
    }

    @GetMapping("big_service")
    public ResponseEntity<List<Vehicle>> sortByBigService(){
        return new ResponseEntity<>(managerService.sortByBigService(), HttpStatus.OK);
    }

    @GetMapping("km")
    public ResponseEntity<List<Vehicle>> sortByKm(){
        return new ResponseEntity<>(managerService.sortByKm(), HttpStatus.OK);
    }
    @GetMapping("year")
    public ResponseEntity<List<Vehicle>> sortByYear(){
        return new ResponseEntity<>(managerService.sortByYear(), HttpStatus.OK);
    }
    @GetMapping("unused_vehicles")
    public ResponseEntity<List<Vehicle>> getUnusedVehicles(){
        return new ResponseEntity<>(managerService.getUnusedVehicles(), HttpStatus.OK);
    }

    @PostMapping("insert_vehicle")
    public ResponseEntity<Vehicle> insertVehicle(@RequestBody Vehicle vehicle){
        Vehicle vehicleObj = managerService.insertVehicle(vehicle);
        if(vehicleObj==null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(vehicleObj,HttpStatus.OK);
    }

    @PostMapping("insert_driver")
    public ResponseEntity<Driver> insertDriver(@RequestBody UserRegisterDto userDTO){
        Driver driver = managerService.insertDriver(userDTO);
        if(driver==null)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(driver,HttpStatus.OK);
    }

    @PostMapping("driver_vehicle")
    public ResponseEntity<Void> insertDriverVehicle(@RequestBody DriverVehicleDTO driverVehicle){
        managerService.insertDriverVehicle(driverVehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit_vehicle")
    public ResponseEntity<Void> editVehicle(@RequestBody Vehicle vehicle){
        managerService.editVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit_driver")
    public ResponseEntity<Void> editDriver(@RequestBody Driver driver){
        managerService.editDriver(driver);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete_vehicle/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") String username){
        managerService.removeVehicle(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete_driver/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") String username){
        managerService.removeDriver(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("driver_vehicle")
    public ResponseEntity<Void> deleteDriver(@RequestBody DriverVehicleDTO driverVehicle){
        managerService.removeDriverVehicle(driverVehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
