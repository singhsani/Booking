package com.bookings.registration_booking.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegistrationController {
    @GetMapping("/new_user")
    public String get(){
        return "welcome to new user";
    }
}
