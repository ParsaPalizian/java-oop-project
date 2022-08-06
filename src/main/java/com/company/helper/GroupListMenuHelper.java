package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.settings.Setting;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class GroupListMenuHelper {
    public static void printGroupsList() {

        if (Globals.currentAccount.getGroups().size() == 0) {
            System.out.println(CommandColors.ANSI_RED + "No Group Found" + CommandColors.ANSI_RESET);
            System.out.println(CommandColors.ANSI_YELLOW + "(B)ack" + CommandColors.ANSI_RESET);
            return;
        }


        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getName());
        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getBio());

        if (Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getCreator().equals(Globals.currentAccount)) {
            PrintUtility.printlnCommands(PrintUtility.createGroupMenu(RoleType.OWNER));
        } else {
            PrintUtility.printlnCommands(PrintUtility.createGroupMenu(RoleType.FOREIGNER));
        }


    }

    public static void performGroupListCommand(String command) throws Exception {

        RoleType roleType = Globals.currentAccount.getGroups().size() != 0 ? Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getCreator().equals(Globals.currentAccount)
                ? RoleType.OWNER
                : RoleType.FOREIGNER : RoleType.FOREIGNER;

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":

                if (Globals.currentGroupIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Group");

                    printGroupsList();
                    performGroupListCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentGroupIndex--;
                    printGroupsList();
                    performGroupListCommand(Main.scanner.nextLine());
                }
                break;
            case "M":
                if (Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().size() != 0) {
                    Globals.menuLevels.push(MenuLevel.MEMBER);
                } else {
                    PrintUtility.printlnFail("There Is No Member");
                }
                break;

            case "C":
                if (Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().size() != 0) {
                    Globals.menuLevels.push(MenuLevel.GROUP_CONTENT);
                    Globals.currentGroupMessages = Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages();
                } else {
                    PrintUtility.printlnFail("There Is No Content");
                }
                break;

            case "B":
                Globals.menuLevels.pop();

                break;

            case "D":
                if (PermissionUtility.hasPermission(Setting.GROUP_ITEMS_PERMISSION, command.toUpperCase(), roleType)) {
                    Account.deleteGroup(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex));
                    if (Globals.currentGroupIndex == Globals.currentAccount.getGroups().size() ) {
                        Globals.currentGroupIndex--;
                    }
                } else {
                    System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                }
                break;

            case "L":
                Account.leaveGroup(Globals.currentAccount, Globals.currentAccount.getGroups().get(Globals.currentGroupIndex));
                if (Globals.currentAccount.getGroups().size()==Globals.currentGroupIndex){
                    Globals.currentGroupIndex--;
                }

                break;

            case "N":
                if (Globals.currentGroupIndex == Globals.currentAccount.getGroups().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Groups");
                    printGroupsList();
                    performGroupListCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentGroupIndex++;
                    printGroupsList();
                    performGroupListCommand(Main.scanner.nextLine());
                }
                break;
        }
    }

}
