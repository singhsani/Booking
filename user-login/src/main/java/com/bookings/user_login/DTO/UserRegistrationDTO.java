package com.bookings.user_login.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserRegistrationDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private String contryName;
    private String districtName;
    private String subDistrictName;
    private String pinCode;
    private String department;
    private String userName;
    private String password;
    private String stateName;

}
