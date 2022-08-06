package com.company.helper;

import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class RequestListMenuHelper {
    public static void printRequestList() {

        if (!Globals.currentAccount.getRequests().isEmpty(true)) {
            Globals.currentAccount.getRequests().current(true);
            PrintUtility.printlnCommands(PrintUtility.createRequestMenu(RoleType.OWNER));
        }




    }

    public static void performRequestListCommand(String command) throws Exception {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentAccount.getRequests().previous();
                printRequestList();
                performRequestListCommand(Main.scanner.nextLine());
                break;

            case "R":
                Globals.currentAccount.getRequests().removeCurrent(true);
                break;

            case "C":
                Account.addFollower(Globals.currentAccount.getRequests().current().getFrom(),Globals.currentAccount);
                Globals.currentAccount.getRequests().removeCurrent(true);
                break;

            case "B":
                Globals.menuLevels.pop();

                break;

            case "N":
                Globals.currentAccount.getRequests().next();
                printRequestList();
                performRequestListCommand(Main.scanner.nextLine());

                break;

        }
    }
}
