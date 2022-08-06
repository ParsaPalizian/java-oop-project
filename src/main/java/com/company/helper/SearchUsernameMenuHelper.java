package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class SearchUsernameMenuHelper {
    public static void printSearchUsername() {
        if (!Globals.searchedAccounts.isEmpty(true)) {
            Globals.searchedAccounts.current(true);
            PrintUtility.printlnCommands(PrintUtility.createSearchUsernameMenu(RoleType.OWNER));
        }
    }

    public static void performSearchUsernameCommand(String command) throws SQLException {
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.searchedAccounts.previous();
                printSearchUsername();
                performSearchUsernameCommand(Main.scanner.nextLine());
                break;

            case "O":
                if (!Globals.historyAccounts.contains(Globals.searchedAccounts.current())) {
                    Globals.historyAccounts.add(Globals.searchedAccounts.current());
                }
                Account.saveHistory(Globals.loggedInAccount.getId(), Globals.searchedAccounts.current().getId());
                Globals.currentAccount = Globals.searchedAccounts.current();
                Globals.menuLevels.push(MenuLevel.HOME);
                break;

            case "B":
                Globals.menuLevels.pop();
                break;

            case "N":
                Globals.searchedAccounts.next();
                printSearchUsername();
                performSearchUsernameCommand(Main.scanner.nextLine());
                break;
        }
    }
}
