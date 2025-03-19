package com.transport.controller;

import com.transport.entity.Driver;
import com.transport.entity.Package;
import com.transport.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping("{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable("id") String id){
        Driver driver = driverService.getDriver(id);
        if(driver==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(driver,HttpStatus.OK);
    }

    @GetMapping("waitingpackages")
    public ResponseEntity<List<Package>> getAllWaitingPackages(){
        List<Package> packageList = driverService.getAllWaitingPackage();
        if(packageList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(packageList,HttpStatus.OK);
    }

    @GetMapping("package/accepted/{id}")
    public ResponseEntity<List<Package>> findAccepted(@PathVariable("id") String username){
        System.out.println("driver/accepted runned");
        List<Package> packageList = driverService.findByFkDriverAndStage(username,2);
        return new ResponseEntity<>(packageList,HttpStatus.OK);
    }

    @GetMapping("package/delivered/{id}")
    public ResponseEntity<List<Package>> findDelivered(@PathVariable("id") String username){
        List<Package> packageList = driverService.findByFkDriverAndStage(username,3);
        return new ResponseEntity<>(packageList,HttpStatus.OK);
    }

    @PutMapping("waiting2accepted/{username}/{idPackage}")
    public ResponseEntity<Void> insertDriverPackage(@PathVariable("username") String username, @PathVariable("idPackage") Integer idPackage){
        driverService.insertDriverPackage(username,idPackage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("accepted2delivered/{username}/{idPackage}")
    public ResponseEntity<Void> accepted2delivered(@PathVariable("username") String username, @PathVariable("idPackage") Integer idPackage){
        driverService.accepted2delivered(username,idPackage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
