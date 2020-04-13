package com.zhonghuasheng.musicstore.model;

public enum Gender {

    MALE("男"),
    FEMALE("女"),
    UNKNOW("未知");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
