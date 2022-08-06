package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class FollowingMenuHelper {
    public static void printFollowings() {

        if (Globals.currentAccount.getFollowings().size() != 0) {
            System.out.println(Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex).getAccount().getUserName());
            PrintUtility.printlnCommands(PrintUtility.createFollowingsMenu(RoleType.OWNER));
        } else {
            System.out.println(CommandColors.ANSI_RED + "No Following Found" + CommandColors.ANSI_RESET);
            System.out.println(CommandColors.ANSI_YELLOW + "(Q)uit" + CommandColors.ANSI_RESET);
        }

    }

    public static void performFollowingsCommand(String command) throws Exception {
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentFollowingIndex == 0) {
                    System.out.println("You Are Watching Your First Following");
                    printFollowings();
                    performFollowingsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentFollowingIndex--;
                    printFollowings();
                    performFollowingsCommand(Main.scanner.nextLine());
                }
                break;

            case "U":


                Account.unFollow(Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex));
                Globals.currentAccount.getFollowings().remove(Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex));
                if(Globals.currentAccount.getFollowings().size()==Globals.currentFollowingIndex){
                    Globals.currentFollowingIndex--;
                }

                break;
            case "O":
                Globals.currentAccount = Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex).getAccount();
                Globals.menuLevels.push(MenuLevel.HOME);
                break;


            case "Q":
                Globals.currentFollowingIndex = 0;
                Globals.menuLevels.pop();

                break;

            case "N":
                if (Globals.currentFollowingIndex == Globals.currentAccount.getFollowings().size() - 1) {
                    System.out.println("You Are Watching Your Last Followings");
                    printFollowings();
                    performFollowingsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentFollowingIndex++;
                    printFollowings();
                    performFollowingsCommand(Main.scanner.nextLine());
                }
                break;

        }
    }

}
