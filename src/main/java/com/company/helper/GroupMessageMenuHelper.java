package com.company.helper;

import com.company.Result;
import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.model.GroupMember;
import com.company.model.GroupMessage;
import com.company.model.Reaction;
import com.company.settings.Setting;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class GroupMessageMenuHelper {
    public static void printGroupContent() {

        PrintUtility.printGroupMessage(Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex));
        PrintUtility.printlnEmojisSummary( Reaction.summarize(Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex).getReactions()));

        if (Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex).getSender().equals(Globals.currentAccount)) {
            PrintUtility.printlnCommands(PrintUtility.createGroupContentsMenu(RoleType.OWNER));
        } else {
            GroupMember member = null;
            for (GroupMember member1 : Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers()) {
                if (member1.getMember().equals(Globals.currentAccount)) {
                    member = member1;
                }
            }
            if (member != null && member.isAdmin()) {
                PrintUtility.printlnCommands(PrintUtility.createGroupContentsMenu(RoleType.ADMIN));
            } else if (member != null && !member.isAdmin()) {
                PrintUtility.printlnCommands(PrintUtility.createGroupContentsMenu(RoleType.FOREIGNER));
            }
        }

    }

    public static void performGroupContentCommand(String command) throws Exception {

        RoleType roleType = RoleType.OWNER;
        if (Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex).getSender().equals(Globals.currentAccount)) {
            roleType = RoleType.OWNER;
        } else {
            GroupMember member = null;
            for (GroupMember member1 : Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers()) {
                if (member1.getMember().equals(Globals.currentAccount)) {
                    member = member1;
                }
            }
            if (member != null && member.isAdmin()) {
                roleType = RoleType.ADMIN;
            } else if (member != null && !member.isAdmin()) {
                roleType = RoleType.FOREIGNER;
            }
        }
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentGroupMessageIndex == 0) {
                    PrintUtility.printlnFail("You Are On First GroupContent");

                    printGroupContent();
                    performGroupContentCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentGroupMessageIndex--;
                    printGroupContent();
                    performGroupContentCommand(Main.scanner.nextLine());
                }
                break;

            case "S":
                System.out.println("Enter Your Message :");
                String message = Main.scanner.nextLine();
                GroupMessage groupMessage = new GroupMessage();
                groupMessage.setSender(Globals.currentAccount);
                groupMessage.setGroup(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex));
                groupMessage.setContent(message);
                groupMessage.setReplyId(0);
                Result result = GroupMessage.sendMessage(groupMessage);
                if (!result.isError()) {
                    GroupMessage groupMessage1 = (GroupMessage) result.getData();
                    Globals.currentGroupMessages.add(groupMessage1);
                    Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().add(groupMessage1);
                }
                Globals.currentGroupMessageIndex = Globals.currentGroupMessages.size() - 1;
                break;

            case "L":

                System.out.println("Enter Your Message :");
                message = Main.scanner.nextLine();
                groupMessage = new GroupMessage();
                groupMessage = new GroupMessage();
                groupMessage.setSender(Globals.currentAccount);
                groupMessage.setGroup(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex));
                groupMessage.setReplyId(Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex).getId());
                groupMessage.setContent(message);
                result = GroupMessage.reply(groupMessage);
                if (!result.isError()) {
                    GroupMessage groupMessage1 = (GroupMessage) result.getData();
                    Globals.currentGroupMessages.add(groupMessage1);
                    Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().add(groupMessage1);
                }
                Globals.currentGroupMessageIndex = Globals.currentGroupMessages.size() - 1;

                break;

            case "R":
                Globals.menuLevels.push(MenuLevel.GROUP_MESSAGE_REACT);
                break;

            case "F":
                Globals.currentForwardedPrivateMessage = null;
                Globals.currentForwardedGroupMessage = Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex);
                Globals.menuLevels.push(MenuLevel.FORWARD_CONTACT_OR_GROUP);
                break;

            case "B":
                Globals.currentGroupMessageIndex = 0;
                Globals.menuLevels.pop();

                break;

            case "D":
                if (PermissionUtility.hasPermission(Setting.GROUP_CONTENTS_PERMISSION, command.toUpperCase(), roleType)) {
                    Account.deleteGroupContent(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().get(Globals.currentGroupContentIndex));
                } else {
                    System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                }
                break;


            case "E":
                if (PermissionUtility.hasPermission(Setting.GROUP_CONTENTS_PERMISSION, command.toUpperCase(), roleType)) {
                    System.out.println("Enter Your New Message :");
                    String editedMessage = Main.scanner.nextLine();
                    Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex).setContent(editedMessage);
                    Account.editGroupMessage(Globals.currentGroupMessages.get(Globals.currentGroupMessageIndex));
                } else {
                    System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                }
                break;


            case "N":
                if (Globals.currentGroupMessageIndex == Globals.currentGroupMessages.size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last GroupContent");
                    printGroupContent();
                    performGroupContentCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentGroupMessageIndex++;
                    printGroupContent();
                    performGroupContentCommand(Main.scanner.nextLine());
                }
                break;
        }
    }

}
