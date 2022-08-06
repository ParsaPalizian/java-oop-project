package com.company.helper;

import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.model.Group;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class AddGroupMemberMenuHelper {
    public static void printAddGroupMember() {
        if (Globals.currentAccount.getContacts().size() != 0) {
            System.out.println(Globals.currentAccount.getContacts().get(Globals.currentAddGroupMemberAccountIndex).getUserName());
            PrintUtility.printlnCommands(PrintUtility.createAddGroupMemberMenu(RoleType.OWNER));
        }else {
            System.out.println( "no contact");
        }
    }

    public static void performAddGroupMemberCommand(String command) throws SQLException {
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentAddGroupMemberAccountIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Account");

                    printAddGroupMember();
                    performAddGroupMemberCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentAddGroupMemberAccountIndex--;
                    printAddGroupMember();
                    performAddGroupMemberCommand(Main.scanner.nextLine());
                }
                break;

            case "A":
                Globals.addGroupMemberList.add(Globals.currentAccount.getContacts().get(Globals.currentAddGroupMemberAccountIndex));
                break;

            case "F":
                Globals.groupToInsert.setCreator(Globals.currentAccount);
                Globals.addGroupMemberList.add(Globals.currentAccount);
                Group.create(Globals.groupToInsert, Globals.addGroupMemberList);
                Globals.currentAddGroupMemberAccountIndex = 0;
                Globals.menuLevels.pop();
                break;

            case "S":
                for (Account account : Globals.addGroupMemberList) {
                    System.out.println(account.getUserName());
                }
                break;

            case "R":
                Globals.addGroupMemberList.remove(Globals.currentAccount.getContacts().get(Globals.currentAddGroupMemberAccountIndex));
                break;

            case "N":
                if (Globals.currentAddGroupMemberAccountIndex == Globals.currentAccount.getContacts().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Account");
                    printAddGroupMember();
                    performAddGroupMemberCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentAddGroupMemberAccountIndex++;
                    printAddGroupMember();
                    performAddGroupMemberCommand(Main.scanner.nextLine());
                }
                break;
        }
    }


}
