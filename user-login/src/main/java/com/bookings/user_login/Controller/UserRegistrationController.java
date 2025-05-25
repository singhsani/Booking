package com.bookings.user_login.Controller;

import com.bookings.user_login.DTO.UserRegistrationDTO;
import com.bookings.user_login.Services.RegistrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.spi.RegisterableService;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserRegistrationController {
    @Autowired
     private RegistrationUserService registrationUserService;
    @PostMapping("/userDetail")
    public ResponseEntity<Map<String,String>> saveDetails(@RequestBody UserRegistrationDTO userRegistration){
        Map<String,String> userDetail = registrationUserService.createUser(userRegistration);
        System.out.println("hello");
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetail);
    }
}
