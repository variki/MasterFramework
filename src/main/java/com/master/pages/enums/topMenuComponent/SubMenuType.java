package com.master.pages.enums.topMenuComponent;

public enum SubMenuType {
    USER_MANAGEMENT("User Management"),
    USERS("Users"),
    JOB("Job");

    private final String name;

    public String getName(){
        return name;
    }

    SubMenuType(String name){
        this.name = name;
    }
}
