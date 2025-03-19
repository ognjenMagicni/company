package com.transport.service;

import com.transport.authentication.UserAuthProvider;
import com.transport.dto.*;
import com.transport.entity.*;
import com.transport.entity.Package;
import com.transport.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PackageRepository packageRepository;
    @Autowired
    UserCredRepository userCredRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserAuthProvider userAuthProvider;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ManagerRepository managerRepository;


    public User getUserById(String id){
        User user = userRepository.getUserById(id);
        return user;
    }

    public List<Package> getAllWaitingPackages(String id){
        List<Package> packageList = userRepository.getAllWaitingPackages(id);
        return packageList;
    }

    public List<Package> getAllAcceptedPackages(String id){
        List<Package> packageList = userRepository.getAllAcceptedPackages(id);
        return packageList;
    }

    public List<Package> getAllDeliveredPackages(String id){
        List<Package> packageList = userRepository.getAllDeliveredPackages(id);
        return packageList;
    }

    public Package getPackage(String idUser, Integer idPackage){
        Package packageObj = userRepository.getPackage(idUser,idPackage);
        return packageObj;
    }

    public Package insertPackage(Package packageObj){
        float weight = packageObj.getWeight();
        Integer width = packageObj.getWidth();
        Integer heigth = packageObj.getHeight();
        Integer length = packageObj.getLength();
        packageObj.setStage(1);
        packageObj.setPrice(2*(width*heigth + length*heigth + width*length)*weight/100);
        try{
            packageObj = packageRepository.save(packageObj);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            packageObj = null;
        }
        return packageObj;
    }

    public User insertUser(UserRegisterDto userDTO){
        UserCred userCredExist = userCredRepository.findByUsername(userDTO.getUsername());
        if(userCredExist!=null)
            return null;

        userDTO.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        User user = new User(userDTO);
        UserCred userCred = new UserCred();
        userCred.setByUserRegisterDTO(userDTO);

        System.out.println(userCred);
        userCred = userCredRepository.save(userCred);
        user = userRepository.save(user);

        return user;
    }

    public void updatePackageGrade(PackageDTO packageDTO){
        packageRepository.updatePackageGrade(packageDTO.getIdPackage(),packageDTO.getGrade(),packageDTO.getComment());
    }

    public LoginReturn login(LoginDTO loginDTO){
        UserCred userCred = userCredRepository.findByUsername(loginDTO.getUsername());
        if( userCred==null)
            return null;
        if(passwordEncoder.matches(CharBuffer.wrap(loginDTO.getPassword()),userCred.getPassword())){
            LoginReturn login = new LoginReturn(userCred);
            if(login.getRole()==1){
                User user = userRepository.getUserById(login.getUsername());
                login.setToken(userAuthProvider.createToken(user));
            }else if(login.getRole()==2){
                Driver driver = driverRepository.findById(login.getUsername()).orElseThrow();
                login.setToken(userAuthProvider.createToken(driver));
            }else if(login.getRole()==3){
                Manager manager = managerRepository.findById(login.getUsername()).orElseThrow();
                login.setToken(userAuthProvider.createToken(manager));
            }
            return login;
        }
        return null;
    }

    public void deleteByIdQ(String idUser, Integer idPackage){
        userRepository.deleteByIdQ(idUser,idPackage);
    }
}
