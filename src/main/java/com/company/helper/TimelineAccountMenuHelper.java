package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.utility.PrintUtility;

public class TimelineAccountMenuHelper {
    public static void printTimelineAccount() {
//        PrintUtility.printlnCommands(PrintUtility.createAccountsMenu(RoleType.FOREIGNER));
    }
    public static void performTimelineAccountCommand(String command) {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    Globals.menuLevels.push(MenuLevel.VIEW_IMAGES);
                    break;

                case 2:
                    Globals.menuLevels.push(MenuLevel.FOLLOWERS);
                    break;

                case 3:
                    Globals.menuLevels.push(MenuLevel.FOLLOWINGS);
                    break;

                case 4:
                    Globals.menuLevels.push(MenuLevel.IMAGES);
                    break;

                case 5:
                    Globals.menuLevels.push(MenuLevel.VIDEOS);
                    break;

                case 6:
                    Globals.menuLevels.push(MenuLevel.AUDIOS);
                    break;

                case 7:
                    Globals.menuLevels.push(MenuLevel.TEXT);
                    break;

                case 8:
                    //TODO CALL
                    break;

                case 9:
                    //TODO EMAIL
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
