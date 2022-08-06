package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.utility.PrintUtility;

import java.sql.SQLException;

public class GroupsMenuHelper {
    public static void printGroups() {
        System.out.println("Groups MENU");
        PrintUtility.printlnCommands(PrintUtility.createGroupsMenu(RoleType.OWNER));
    }

    public static void performGroupsCommand(String command) throws SQLException {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1: {
                    Globals.menuLevels.push(MenuLevel.GROUP_LIST);
                    break;
                }
                case 2: {
                    System.out.println("Enter GroupName :");
                    Globals.groupToInsert.setName(Main.scanner.nextLine());

                    System.out.println("Enter groupBio :");
                    Globals.groupToInsert.setBio(Main.scanner.nextLine());

                    System.out.println("Enter GroupProfilePictureAddress :");
                    Globals.groupToInsert.setProfilePicture(Main.scanner.nextLine());

                    System.out.println("Enter groupLink :");
                    Globals.groupToInsert.setLink(Main.scanner.nextLine());

                    Globals.menuLevels.push(MenuLevel.ADD_GROUP_MEMBER);

                    break;
                }
                case 0: {
                    Globals.menuLevels.pop();

                    break;
                }
            }
        }catch (Exception ex){
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }
}
