package com.bookings.user_login.Repository;

import com.bookings.user_login.Model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Long> {

}
