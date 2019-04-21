package com.espressoshock.drinkle.Model;

public enum PermissionType {
    V("View"), E("Edit");

    private final String permissionTextual;

    PermissionType(String permissionTextual){
        this.permissionTextual = permissionTextual;
    }

    public String getPermissionTextual() {
        return permissionTextual;
    }
}
