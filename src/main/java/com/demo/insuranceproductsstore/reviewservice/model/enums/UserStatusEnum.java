package com.demo.insuranceproductsstore.reviewservice.model.enums;

public enum UserStatusEnum {

    UNKNOWN("UNKNOWN"), USER("USER"), ADMIN("ADMIN");

    private String type;

    UserStatusEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static UserStatusEnum getType(String text) {
        for (UserStatusEnum item : UserStatusEnum.values()) {
            if (item.type.equals(text)) {
                return item;
            }
        }
        return null;
    }
}
