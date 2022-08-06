package com.company.utility;

import com.company.enums.RoleType;
import com.company.permission.Permission;

import java.util.ArrayList;

public class PermissionUtility {


    public static boolean hasPermission(ArrayList<Permission> permissions, String shortCode, RoleType roleType) {
        for (Permission permission : permissions) {
            if (permission.getShortCode().equals(shortCode) && permission.getRole() == roleType) {
                return permission.isAllowed();
            }
        }
        return false;
    }

}
