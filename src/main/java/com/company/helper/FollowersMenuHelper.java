package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.model.Follow;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class FollowersMenuHelper {
    public static void printFollowers() {
        if (Globals.currentAccount.getFollowers().size() != 0) {
            System.out.println(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount().getUserName());
            PrintUtility.printlnCommands(PrintUtility.createFollowersMenu(RoleType.OWNER));
        } else {
            System.out.println(CommandColors.ANSI_RED + "No Follower Found" + CommandColors.ANSI_RESET);
            System.out.println(CommandColors.ANSI_YELLOW + "(Q)uit" + CommandColors.ANSI_RESET);
        }
    }

    public static void performFollowersCommand(String command) throws SQLException {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentFollowerIndex == 0) {
                    System.out.println("You Are Watching Your First Followers");
                    printFollowers();
                    performFollowersCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentFollowerIndex--;
                    printFollowers();
                    performFollowersCommand(Main.scanner.nextLine());
                }
                break;

            case "B":
                //todo we should create blocklist
                Account.block(Globals.currentAccount, Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount());
                Globals.currentAccount.getFollowers().remove(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex));
                if (Globals.currentAccount.getFollowers().size()==Globals.currentFollowerIndex){
                    Globals.currentFollowerIndex--;
                }


                break;
            case "O":
                Globals.currentAccount = Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount();
//                Globals.currentPosts = Globals.currentAccount.getPosts();
                Globals.menuLevels.push(MenuLevel.HOME);
                break;

            case "F":
                boolean shouldBeFollow = false;
                for (Follow follow : Globals.currentAccount.getFollowings()) {
                    if (follow.getAccount().equals(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount())) {
                        shouldBeFollow = true;
                    }
                }
                if (shouldBeFollow) {
                    Follow.follow(Globals.currentAccount, Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount());
                }
                break;


            case "Q":
                Globals.currentFollowerIndex = 0;
                Globals.menuLevels.pop();

                break;

            case "N":
                if (Globals.currentFollowerIndex == Globals.currentAccount.getFollowers().size() - 1) {
                    System.out.println("You Are Watching Your Last Followers");
                    printFollowers();
                    performFollowersCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentFollowerIndex++;
                    printFollowers();
                    performFollowersCommand(Main.scanner.nextLine());
                }
                break;

        }
    }

}
