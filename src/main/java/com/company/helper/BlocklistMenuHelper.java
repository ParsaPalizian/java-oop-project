package com.company.helper;

import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class BlocklistMenuHelper {
    public static void printBlocklist() {
        if (!Globals.currentAccount.getBlocklist().isEmpty(true)) {
            Globals.currentAccount.getBlocklist().current(true);
            PrintUtility.printlnCommands(PrintUtility.createBlockListMenu(RoleType.OWNER));
        }
    }

    public static void performBlocklistCommand(String command) throws Exception {
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentAccount.getBlocklist().previous();
                printBlocklist();
                performBlocklistCommand(Main.scanner.nextLine());
                break;

            case "U":
                Account.unBlock(Globals.currentAccount.getBlocklist().current());
                Globals.currentAccount.getBlocklist().removeCurrent();
                break;

            case "B":
                Globals.menuLevels.pop();
                break;

            case "N":
                Globals.currentAccount.getBlocklist().next();
                printBlocklist();
                performBlocklistCommand(Main.scanner.nextLine());
                break;
        }
    }

}
