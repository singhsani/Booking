//package com.bookings.user_login.security;
//
//import com.bookings.user_login.Enums.UserType;
//import lombok.Data;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//
//public class LoginUser extends org.springframework.security.core.userdetails.User {
//    private Long userId;
//    private UserType userType;
//
//    private boolean loginByDept = Boolean.FALSE;
//
//    private String deptUserId;
//    private String serviceCode;
//
//    //private Set<LookupDataDTO> departments;
//
//    private Object userRights;
//    private Object accessOperationsList;
//
//    public LoginUser(Long userId, String username, String password,
//                     Collection<? extends GrantedAuthority> authorities, UserType userType) {
//        super(username, password, authorities);
//        this.userId = userId;
//        this.userType = userType;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public boolean hasAuthority(String authority) {
//        return getAuthorities().stream().anyMatch(g -> g.getAuthority().equalsIgnoreCase(authority));
//    }
//
//    public boolean isDeptUser() {
//        return UserType.DEPARTMENT == userType;
//    }
//
//    public void validateAuthority(String authority) {
//        if (!hasAuthority(authority)) {
//            //throw AppException.unauthorisedUser();
//            throw new RuntimeException("user unauthoritis user");
//        }
//    }
//
////    public boolean isInDept(LookupDataDTO department) {
////        return Objects.nonNull(departments) && departments.contains(department);
////    }
//
//    public boolean isDeptCitizenUser(){
//        return this.getUsername().startsWith("CITIZEN:DEP_USER_");
//    }
//
//    public boolean isGuestUser(){
//        return this.getUsername().equals("CITIZEN:cs_guest@guest.com");
//    }
//
//    @Override
//    public String toString() {
//        return "LoginUser{" +
//                "userId=" + userId +
//                ", userType=" + userType +
//                ", loginByDept=" + loginByDept +
//                ", deptUserId='" + deptUserId + '\'' +
//                ", serviceCode='" + serviceCode  +
//                '}';
//    }
//
//}
