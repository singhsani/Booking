package com.bookings.user_login.Controller;

import com.bookings.user_login.Model.LoginUser;
import com.bookings.user_login.Services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    LoginUserService loginUserService;

//    @GetMapping("/getUser")
//    public List<LoginUser> getUsers(){
//        return loginUserService.getLoginUser();
//    }
}
