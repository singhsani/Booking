package com.bookings.user_login.Model;

import com.bookings.user_login.Constants.ModelDBConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;


@Data
@Entity
@Table(name= ModelDBConstant.LOGIN_DETAIL)
@javax.persistence.SequenceGenerator(name = ModelDBConstant.LOGIN_DETAIL_SEQ, sequenceName = ModelDBConstant.LOGIN_DETAIL_SEQ, allocationSize = 1)
@BatchSize(size = 50)
public class LoginUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "registration_id")
    private UserRegistration registration;
}
