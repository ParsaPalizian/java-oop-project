package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.ProfilePicture;
import com.company.settings.Setting;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.sql.SQLException;

public class ProfileMenuHelper {
    public static void printProfile() {
        if(Globals.currentAccount.equals(Globals.loggedInAccount)){
            PrintUtility.printlnMenus(PrintUtility.createProfilePictureMenu(RoleType.OWNER));
        }else{
            PrintUtility.printlnMenus(PrintUtility.createProfilePictureMenu(RoleType.FOREIGNER));
        }
    }

    public static void performProfileCommand(String command) throws SQLException {
        RoleType roleType=Globals.currentAccount.equals(Globals.loggedInAccount) ? RoleType.OWNER : RoleType.FOREIGNER;
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    Globals.currentProfilePictureIndex=0;
                    Globals.menuLevels.push(MenuLevel.VIEW_PROFILE_PICTURE);
                    break;

                case 2:
                    if (PermissionUtility.hasPermission(Setting.VIEW_PROFILE_PICTURES_MENU_PERMISSION, command.toUpperCase(), roleType)) {
                        System.out.println("Enter Your New Profile Picture Address :");
                        String address = Main.scanner.nextLine();
                        ProfilePicture profilePicture = new ProfilePicture();
                        profilePicture.setAddress(address);
                        Globals.currentAccount.AddProfilePicture(profilePicture);
                    }else {
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 0:
                    Globals.menuLevels.pop();

                    break;
            }
        }catch (Exception ex){
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }

}
