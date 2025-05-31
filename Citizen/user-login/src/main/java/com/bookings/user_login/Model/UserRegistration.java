package com.bookings.user_login.Model;

import com.bookings.user_login.Constants.ModelDBConstant;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = ModelDBConstant.USER_REGISTRATION, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"mobile_number"})
})
@SequenceGenerator(name = ModelDBConstant.USER_REGISTRATION_SEQ, sequenceName = ModelDBConstant.USER_REGISTRATION_SEQ, allocationSize = 1)
@BatchSize(size = 50)
@Data
public class UserRegistration implements Serializable {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ModelDBConstant.USER_REGISTRATION_SEQ)
    private Long id;

    @Column(name = "unique_id", columnDefinition = "VARCHAR(50)")
    private String uniqueId;

    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "middle_name", columnDefinition = "VARCHAR(50)")
    private String middleName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "mobile_number", columnDefinition = "VARCHAR(50)")
    private String mobileNumber;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String emailId;

    @Column(name = "country_name", columnDefinition = "VARCHAR(50)")
    private String countryName;

    @Column(name = "district_name", columnDefinition = "VARCHAR(50)")
    private String districtName;

    @Column(name = "sub_district_name", columnDefinition = "VARCHAR(50)")
    private String subDistrictName;

    @Column(name = "state", columnDefinition = "VARCHAR(50)")
    private String stateName;

    @Column(name = "pin_code", columnDefinition = "VARCHAR(50)")
    private String pinCode;

    @Column(name="department")
    private String department;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private LoginUser login;


}
