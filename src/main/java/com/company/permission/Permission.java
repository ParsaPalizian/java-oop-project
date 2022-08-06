package com.company.permission;

import com.company.enums.RoleType;

public class Permission {
    String Command;

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        shortCode = shortCode;
    }

    String shortCode;
    RoleType role;
    boolean allowed;


    public Permission(String command, RoleType role, boolean allowed, String shortCode) {
        Command = command;
        this.role = role;
        this.allowed = allowed;
        this.shortCode = shortCode;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }
}
