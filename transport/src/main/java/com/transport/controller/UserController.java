package com.transport.controller;

import com.transport.dto.*;
import com.transport.entity.Package;
import com.transport.entity.User;
import com.transport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        User user = userService.getUserById(id);
        if(user!=null)
            return ResponseEntity.ok(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("package/waiting/{id}")
    public ResponseEntity<List<Package>> getAllWaitingPackages(@PathVariable("id") String id){
        List<Package> listPackage = userService.getAllWaitingPackages(id);
        if(listPackage==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listPackage,HttpStatus.OK);
    }
    @GetMapping("package/accepted/{id}")
    public ResponseEntity<List<Package>> getAllAcceptedPackages(@PathVariable("id") String id){
        List<Package> listPackage = userService.getAllAcceptedPackages(id);
        if(listPackage==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listPackage,HttpStatus.OK);
    }
    @GetMapping("package/delivered/{id}")
    public ResponseEntity<List<Package>> getAllDeliveredPackages(@PathVariable("id") String id){
        List<Package> listPackage = userService.getAllDeliveredPackages(id);
        if(listPackage == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listPackage,HttpStatus.OK);
    }
    @GetMapping("package/{idUser}/{idPackage}")
    public ResponseEntity<Package> getAllAcceptedPackages(@PathVariable("idUser") String idUser, @PathVariable("idPackage") Integer idPackage){
        Package packageObj = userService.getPackage(idUser,idPackage);
        if(packageObj==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(packageObj,HttpStatus.OK);
    }
    @PostMapping("package")
    public ResponseEntity<Package> getAllAcceptedPackages(@RequestBody Package packageObj){
        Package packageInserted = userService.insertPackage(packageObj);
        if(packageInserted==null)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(packageInserted,HttpStatus.CREATED);
    }

    @PostMapping("register")
    public ResponseEntity<User> insertUser(@RequestBody UserRegisterDto userDTO){
        System.out.println("Contoller user/register started");
        User user = userService.insertUser(userDTO);
        if(user!=null)
            return new ResponseEntity<>(user,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("login")
    public ResponseEntity<LoginReturn> login(@RequestBody LoginDTO loginDTO){
        LoginReturn login = userService.login(loginDTO);
        if(login!=null)
            return new ResponseEntity<>(login,HttpStatus.OK);
        return null;
    }

    @PutMapping("update")
    public ResponseEntity<Package> updatePackageGrade(@RequestBody PackageDTO packageDTO){
        userService.updatePackageGrade(packageDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("package/{idUser}/{idPackage}")
    public ResponseEntity<Void> deleteByIdQ(@PathVariable("idUser") String idUser, @PathVariable("idPackage") Integer idPackage){
        System.out.println("Controller delete "+idUser+" and "+idPackage);
        userService.deleteByIdQ(idUser,idPackage);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
