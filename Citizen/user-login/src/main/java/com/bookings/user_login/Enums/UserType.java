package com.bookings.user_login.Enums;

import Common.EnumType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UserType implements EnumType {
    CITIZEN(1, "Citizen"),
    DEPARTMENT(2, "Department"),
    ADMIN(4,"Admin");

    private final String name;
    private final int id;

    UserType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return name();
    }

    public static UserType fromType(String type) {
        return UserType.valueOf(type.toUpperCase());
    }

    public static List<UserType> getAll() {
        return Arrays.asList(values());
    }

    public int getId() {
        return id;
    }

//    public static List<LookupDataDTO> toLookup(){
//        return Arrays.stream(UserType.values()).map(EnumType::toLookupData)
//                .collect(Collectors.toList());
//    }

    public static void main(String[] args) {
        try {
            fromType("sdsd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
