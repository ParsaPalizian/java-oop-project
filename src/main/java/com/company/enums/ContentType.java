package com.company.enums;

public enum ContentType {
    PRIVATE_MESSAGE("private message"),
    GROUP_MESSAGE("group message"),
    POST("post"),
    COMMENT("comment");



    final String value;

    @Override
    public String toString() {
        return value;
    }

    ContentType(String value) {
        this.value = value;
    }
}
