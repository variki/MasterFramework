package com.master.pages.enums.topMenuComponent;

public enum MenuType {
    ADMIN("Admin"),
    PIM("Pim"),
    LEAVE("Leave"),
    TIME("Time");

    private final String name;

    public String getName() {
        return name;
    }

   MenuType(String name){
        this.name = name;
   }
}
