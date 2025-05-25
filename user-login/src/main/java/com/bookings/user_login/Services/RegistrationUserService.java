package com.bookings.user_login.Services;

import com.bookings.user_login.DTO.UserRegistrationDTO;
import com.bookings.user_login.Enums.UserType;
import com.bookings.user_login.Model.LoginUser;
import com.bookings.user_login.Model.UserRegistration;
import com.bookings.user_login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RegistrationUserService {
    @Autowired
    private UserRepository userRepository;
    public Map<String,String> createUser(UserRegistrationDTO userRegistrationDTO){
        UserRegistration userRegistration=new UserRegistration();
        LoginUser loginUser=new LoginUser();
        Optional.ofNullable(userRegistrationDTO).ifPresent(dto -> {
            userRegistration.setFirstName(dto.getFirstName());
            userRegistration.setMiddleName(dto.getMiddleName());
            userRegistration.setLastName(dto.getLastName());
            userRegistration.setEmailId(dto.getEmailId());
            userRegistration.setMobileNumber(dto.getMobileNo());
            userRegistration.setCountryName(dto.getContryName());
            userRegistration.setStateName(dto.getStateName());
            userRegistration.setDistrictName(dto.getDistrictName());
            userRegistration.setSubDistrictName(dto.getSubDistrictName());
            userRegistration.setPinCode(dto.getPinCode());
            userRegistration.setDepartment(String.valueOf(dto.getDepartment().equalsIgnoreCase("Admin")? UserType.ADMIN:UserType.CITIZEN));
            loginUser.setUsername(dto.getUserName());
            loginUser.setPassword(dto.getPassword());
            userRegistration.setLogin(loginUser);
        });
        Optional.ofNullable(userRegistration)
                .ifPresentOrElse(
                        userRepo -> userRepository.saveAndFlush(userRepo),
                        () -> {
                            // Log the exception or handle it as needed
                            System.out.println("User  registration cannot be null");
                        }
                );
        // Return a map with the emailId if userRegistration is not null, otherwise return an empty map or handle accordingly
        return Optional.ofNullable(userRegistration)
                .map(user -> Map.of("userName", user.getEmailId()))
                .orElse(Map.of("error", "User  registration was null"));
    }
}
