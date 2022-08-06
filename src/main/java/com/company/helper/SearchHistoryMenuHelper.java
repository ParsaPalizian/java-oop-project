package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class SearchHistoryMenuHelper {
        public static void printSearchHistory() {
            if (!Globals.historyAccounts.isEmpty(true)) {
                Globals.historyAccounts.current(true);
                PrintUtility.printlnCommands(PrintUtility.createSearchedAccountsMenu(RoleType.OWNER));
            }
        }

        public static void performSearchHistoryCommand(String command) throws SQLException {
            switch (command.toUpperCase(Locale.ROOT)) {
                case "P":
                    Globals.historyAccounts.previous();
                    printSearchHistory();
                    performSearchHistoryCommand(Main.scanner.nextLine());
                    break;

                case "O":
                    Globals.currentAccount=Globals.historyAccounts.current();
                    Globals.menuLevels.push(MenuLevel.HOME);
                    break;

                case "D":
                    Account.deleteFromSearchHistory(Globals.currentAccount,Globals.historyAccounts.current());
                    Globals.historyAccounts.remove(Globals.historyAccounts.current());

                case "B":
                    Globals.menuLevels.pop();
                    break;

                case "N":
                    Globals.historyAccounts.next(false);
                    printSearchHistory();
                    performSearchHistoryCommand(Main.scanner.nextLine());
                    break;
            }
        }
    }
