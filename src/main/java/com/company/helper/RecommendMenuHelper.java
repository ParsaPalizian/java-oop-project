package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Follow;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class RecommendMenuHelper {
    public static void printRecommend() {
        if (Globals.recommendAccounts.size() != 0) {
            System.out.println(Globals.recommendAccounts.get(Globals.currentRecommendIndex).getUserName());
            System.out.println(Globals.recommendAccounts.get(Globals.currentRecommendIndex).getId());
            PrintUtility.printlnCommands(PrintUtility.createRecommendAccountsMenu(RoleType.OWNER));
        } else {
            System.out.println(CommandColors.ANSI_RED + "No Recommend Found" + CommandColors.ANSI_RESET);
            System.out.println(CommandColors.ANSI_YELLOW + "(Q)uit" + CommandColors.ANSI_RESET);
        }
    }

    public static void performRecommendCommand(String command) throws SQLException {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentRecommendIndex == 0) {
                    System.out.println("You Are Watching Your First Recommend");
                    printRecommend();
                    performRecommendCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentRecommendIndex--;
                    printRecommend();
                    performRecommendCommand(Main.scanner.nextLine());
                }
                break;

            case "O":
                Globals.currentAccount = Globals.recommendAccounts.get(Globals.currentRecommendIndex);
                Globals.menuLevels.push(MenuLevel.HOME);
                break;

            case "F":
                Follow.follow(Globals.currentAccount,Globals.recommendAccounts.get(Globals.currentRecommendIndex));
                if (!Follow.follow(Globals.currentAccount,Globals.recommendAccounts.get(Globals.currentRecommendIndex)).isError()){
                    Follow follow=new Follow();
                    follow.setAccount(Globals.recommendAccounts.get(Globals.currentRecommendIndex));
                    Globals.currentAccount.getFollowers().add(follow);
                }
                break;


            case "Q":
                Globals.currentRecommendIndex = 0;
                Globals.menuLevels.pop();

                break;

            case "N":
                if (Globals.currentRecommendIndex == Globals.recommendAccounts.size() - 1) {
                    System.out.println("You Are Watching Your Last Recommend");
                    printRecommend();
                    performRecommendCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentRecommendIndex++;
                    printRecommend();
                    performRecommendCommand(Main.scanner.nextLine());
                }
                break;

        }
    }

}
