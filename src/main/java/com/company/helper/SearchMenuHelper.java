package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

public class SearchMenuHelper {
    public static void printSearch() {
        PrintUtility.createSearchMenu();
    }

    public static void performSearchCommand(String command) {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    String searchedUsername= Main.scanner.nextLine();
                    Globals.searchedAccounts= Account.searchAccount(searchedUsername).getData();
                    Globals.menuLevels.push(MenuLevel.SEARCH_USERNAME);
                    break;

                case 2:
                    Globals.menuLevels.push(MenuLevel.HISTORY_ACCOUNTS);
                    break;

                case 3:
                    Globals.historyAccounts.clear();
                    Account.clearSearchedHistory(Globals.currentAccount);
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
