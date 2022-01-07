package com.demo.insuranceproductsstore.reviewservice.model.enums;

public enum CommentStatusEnum {

    CONFIRM("CONFIRM"),
    NOT_CONFIRM("NOT_CONFIRM");

    private String type;

    CommentStatusEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static CommentStatusEnum getType(String text) {
        for (CommentStatusEnum item : CommentStatusEnum.values()) {
            if (item.type.equals(text)) {
                return item;
            }
        }
        return null;
    }
}
