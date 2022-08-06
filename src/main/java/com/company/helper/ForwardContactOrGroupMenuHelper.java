package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.utility.PrintUtility;

import java.sql.SQLException;

public class ForwardContactOrGroupMenuHelper {
    public static void printForwardContactOrGroup() {
        System.out.println(Globals.currentAccount.getContacts().get(Globals.currentForwardContactIndex).getUserName());
        PrintUtility.printlnCommands("Forward To ...");
        PrintUtility.printlnCommands(PrintUtility.createForwardContactOrGroupMenu(RoleType.OWNER));
    }

    public static void performForwardContactOrGroupCommand(String command) throws SQLException {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    Globals.currentForwardContactIndex = 0;
                    Globals.menuLevels.push(MenuLevel.FORWARD_TO_CONTACT);
                    break;
                case 2:
                    Globals.currentForwardGroupIndex = 0;
                    Globals.menuLevels.push(MenuLevel.FORWARD_TO_GROUP);
                    break;
                case 0:
                    Globals.menuLevels.pop();
                    break;
            }
        } catch (Exception ex) {
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }
}