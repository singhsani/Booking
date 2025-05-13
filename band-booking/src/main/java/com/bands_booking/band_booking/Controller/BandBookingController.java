package com.bands_booking.band_booking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BandBookingController {
    @GetMapping("/book")
    public String getBookDetail(){
        return "Hello Booki";
    }
}
