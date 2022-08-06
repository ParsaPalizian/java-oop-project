package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.model.GroupMember;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class MemberMenuHelper {
    public static void printMember() {
        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().get(Globals.currentMemberIndex).getMember().getUserName());
        GroupMember member=null;
        for(GroupMember member1 : Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers()){
            if(member1.getMember().equals(Globals.currentAccount)){
                member=member1;
            }

        }
        if(member!=null && member.isAdmin()){
            PrintUtility.printlnCommands(PrintUtility.createGroupMembersMenu(RoleType.ADMIN));
        }else if(member!=null && !member.isAdmin()){
            PrintUtility.printlnCommands(PrintUtility.createGroupMembersMenu(RoleType.FOREIGNER));
        }

    }

    public static void performMemberCommand(String command) throws Exception {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentMemberIndex==0) {
                    PrintUtility.printlnFail("You Are On First Member");

                    printMember();
                    performMemberCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentMemberIndex--;
                    printMember();
                    performMemberCommand(Main.scanner.nextLine());
                }
                break;
            case "K":
                Account.kickMember(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().get(Globals.currentMemberIndex));
                if(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().size()==Globals.currentMemberIndex){
                    Globals.currentMemberIndex--;
                }
                break;

            case "B":
                Globals.menuLevels.pop();
                break;

            case "O":
                Globals.currentAccount = Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount();
                Globals.menuLevels.push(MenuLevel.HOME);
                break;

            case "N":
                if (Globals.currentMemberIndex == Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Member");
                    printMember();
                    performMemberCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentMemberIndex++;
                    printMember();
                    performMemberCommand(Main.scanner.nextLine());
                }
                break;
        }
    }

}
