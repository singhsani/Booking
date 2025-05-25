//package com.bookings.user_login.Model;
//
//import com.bookings.user_login.Constants.ModelDBConstant;
//import com.bookings.user_login.Enums.UserStatus;
//import com.bookings.user_login.Enums.UserType;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import org.hibernate.annotations.BatchSize;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Data
//@Entity
//@Table(name = ModelDBConstant.USER, uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"email"}),
//        @UniqueConstraint(columnNames = {"password"}),
//        @UniqueConstraint(columnNames = {"unique_id"})
//})
//
//@SequenceGenerator(name = ModelDBConstant.USER_SEQ, sequenceName = ModelDBConstant.USER_SEQ, allocationSize = 1)
//@BatchSize(size = 50)
//
//public class Users {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @Column(name = "id", updatable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ModelDBConstant.USER_SEQ)
//    private Long id;
//
//    @Column(name = "unique_id", columnDefinition = "VARCHAR(50)")
//    private String uniqueId;
//
//    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
//    private String firstName;
//
//    @Column(name = "middle_name", columnDefinition = "VARCHAR(50)")
//    private String middleName;
//
//    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
//    private String lastName;
//
//    @Column(name = "password", columnDefinition = "VARCHAR(100)")
//    private String password;
//
//    /**
//     * For each User Email with userType must be unique.
//     */
//    @Column(name = "email", columnDefinition = "VARCHAR(50)")
//    private String email;
//
//    /**
//     * For each User Cell with userType must be unique.
//     */
//    @Column(name = "cell_no", columnDefinition = "VARCHAR(15)")
//    private String cellNo;
//
//    /**
//     * We use this emailCode when we required email verification.
//     */
//    @Column(name = "email_code", columnDefinition = "VARCHAR(50)")
//    private String emailCode;
//
//    /**
//     * We use this cellOtp when we required cell verification.
//     */
//    @Column(name = "cell_otp", columnDefinition = "VARCHAR(10)")
//    private String cellOtp;
//
//    /**
//     * It shows weather the email is validated.
//     */
//    @Column(name = "email_validated")
//    private boolean emailValidated;
//
//    /**
//     * It shows weather the cell is validated.
//     */
//    @Column(name = "otp_validated")
//    private boolean otpValidated;
//
//    @Column(name = "profile_pic", columnDefinition = "Text")
//    private String profilePic;
//
//
//    @Column(name = "enableIpAuth" ,columnDefinition = "boolean default false" )
//    private Boolean enableIpAuth;
//
//    @Column(name = "ipAddress", columnDefinition = "VARCHAR(20)")
//    private String ipAddress;
//
//    /**
//     * For all Registered Citizen via Portal become ACTIVE. Registered by Dept are set as NEW and has
//     * to follow change password to make himself ACTIVE.
//     */
//    @Column(name = "status", columnDefinition = "VARCHAR(15)")
//    @Enumerated(value = EnumType.STRING)
//    private UserStatus status = UserStatus.NEW;
//
//    @Column(name = "user_type", columnDefinition = "VARCHAR(15)")
//    @Enumerated(EnumType.STRING)
//    private UserType userType;
//
//    /**
//     * Show weather the User is Registered self or Dept. For DEPT we store dept user's id here.
//     */
//    @Column(name = "register_by", columnDefinition = "VARCHAR(5)")
//    private String registerBy = "SELF";
//
//    @Column(name = "building_name", columnDefinition = "VARCHAR(60)")
//    private String buildingName;
//
//    /*Block Name,Street Number or Street name or Sector Number or Mohalla*/
//    @Column(name = "street_name", columnDefinition = "VARCHAR(60)")
//    private String streetName;
//
//    @Column(name = "landmark", columnDefinition = "VARCHAR(100)")
//    private String landmark;
//
//    @Column(name = "area", columnDefinition = "VARCHAR(60)")
//    private String area;
//
//    @Column(name = "state", columnDefinition = "VARCHAR(60)")
//    private String state;
//
//    @Column(name = "district", columnDefinition = "VARCHAR(60)")
//    private String district;
//
//    @Column(name = "city", columnDefinition = "VARCHAR(60)")
//    private String city;
//
//    @Column(name = "pincode", columnDefinition = "VARCHAR(6)")
//    private String pincode;
//
//    @Column(name = "country", columnDefinition = "VARCHAR(60)")
//    private String country;
//
//    @Column(name = "birth_date", columnDefinition = "DATE")
//    private LocalDate birthDate;
//
//    private String gender;
//
//    @Column(name = "module_name", columnDefinition = "VARCHAR(200)")
//    private String moduleName;
//
//    @Column(name = "designation", columnDefinition = "VARCHAR(200)")
//    private String designation;
//
//    @Column(name = "department", columnDefinition = "VARCHAR(200)")
//    private String department;
//
//    @Column(name = "user_code", columnDefinition = "VARCHAR(200)")
//    private String userCode;
//
//    @Column(name = "sap_user_code", columnDefinition = "VARCHAR(200)")
//    private String sapCode;
//
//    /**
//     * Payment Gateway like CCAVENUE,BILLDESK. Based on Payment Gateway Online Account Code used
//     */
//    @Column(name = "payment_gateway", columnDefinition = "VARCHAR(50)")
//    private String paymentGateway;
//
//    @Column(name = "DepositMerchantID", columnDefinition = "VARCHAR(50)")
//    private String depositMerchantid;
//
//    @Column(name = "DepositIMEI", columnDefinition = "VARCHAR(50)")
//    private String depositImei;
//
//    @Column(name = "IncomeMerchantID", columnDefinition = "VARCHAR(50)")
//    private String incomeMerchantid;
//
//    @Column(name = "IncomeIMEI", columnDefinition = "VARCHAR(50)")
//    private String incomeImei;
//
//    @Column(name = "signature_name", columnDefinition = "VARCHAR(255)")
//    private String signatureName;
//
//    @Column(name = "digital_signature")
//    private Boolean digitalSignature = Boolean.FALSE;
//
//    public void validateSameAs(LoginUser loginUser) {
//        if (isSameAs(loginUser)) {
//            return;
//        }
//        throw AppException.unauthorisedUser();
//    }
//
//    public void validateSameAs(Users loginUser) {
//        if (isSameAs(loginUser)) {
//            return;
//        }
//        throw AppException.unauthorisedUser();
//    }
//
//    public boolean isSameAs(LoginUser loginUser) {
//        if (loginUser.isDeptCitizenUser() || loginUser.isGuestUser()) {
//            return true;
//        }
//        return this.id.equals(loginUser.getUserId());
//    }
//
//    public boolean isSameAs(Users loginUser) {
//        return this.id.equals(loginUser.getId());
//    }
//
//    public boolean isDeptUser() {
//        return UserType.DEPARTMENT == getUserType();
//    }
//
//    //public LookupDataDTO toLookUp() {
//      //  return LookupDataDTO.create(getId(), getUniqueId(), getName(), getGujName());
//    //}
//
//    /**
//     * <p> Returns Applicant Full Address</p>
//     *
//     * @author VISHAL KUMAR
//     */
////    @JsonIgnore
////    public String buildApplicantFullAddress() {
////
////        return String.format("%s, %s, %s, %s, %s, %s, %s, %s",
////                HelperUtil.formatStringIfExist(buildingName),
////                HelperUtil.formatStringIfExist(streetName),
////                HelperUtil.formatStringIfExist(landmark),
////                HelperUtil.formatStringIfExist(city),
////                HelperUtil.formatStringIfExist(area),
////                HelperUtil.formatStringIfExist(district),
////                HelperUtil.formatStringIfExist(country),
////                HelperUtil.formatStringIfExist(pincode));
////    }
//
//
//}
