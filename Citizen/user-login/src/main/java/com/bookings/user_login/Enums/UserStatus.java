package com.bookings.user_login.Enums;

import Common.EnumType;
import org.springframework.util.StringUtils;

import javax.persistence.Convert;

/**
 * A user-status, such as 'NEW'.
 *
 * <p>{@code UserStatus} is an enum representing the different types of the template such as
 * NEW, ACTIVE, and BLOCKED.
 *
 * It represents the user activation status.</p>
 */
@Convert
public enum UserStatus implements EnumType {



        /**
         * The singleton instance for the user-status of NEW.
         * This has the numeric value of {@code 1}.
         */
        NEW(1, "New"),
        /**
         * The singleton instance for the user-status of ACTIVE.
         * This has the numeric value of {@code 2}.
         */
        ACTIVE(2, "Active"),
        /**
         * The singleton instance for the user-status of BLOCKED.
         * This has the numeric value of {@code 3}.
         */
        BLOCKED(3, "Blocked");

        private final String status;
        private final int id;

        UserStatus(int id, String status) {
            this.id = id;
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public String getName() {
            return status;
        }

        @Override
        public String getType() {
            return name();
        }

        public static UserStatus fromType(String type) {
            return UserStatus.valueOf(type);
        }

        public int getId() {
            return id;
        }

        public Integer getDBId() {
            return id;
        }

        public static UserStatus getById(Integer id) {
            if (StringUtils.isEmpty(id)) {
                return null;
            }
            for (UserStatus userStatus : values()) {
                if (userStatus.id == id) {
                    return userStatus;
                }
            }
            //throw AppException.create(INVALID_ENUM, ENUM_ID);
            throw new RuntimeException("envalid enum");
        }
    }

