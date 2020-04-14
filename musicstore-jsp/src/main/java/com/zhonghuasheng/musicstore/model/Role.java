package com.zhonghuasheng.musicstore.model;

public enum Role {

    ADMIN("管理员"),
    USER("普通用户");

    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
