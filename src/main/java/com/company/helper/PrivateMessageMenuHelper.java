package com.company.helper;

import com.company.Result;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.PrivateMessage;
import com.company.settings.Setting;
import com.company.ui.PostUI;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class PrivateMessageMenuHelper {
    public static void printMessages() {

        if (!Globals.currentPrivateMessages.isEmpty(true)) {
            Globals.currentPrivateMessages.current(true);
            if (Globals.currentPrivateMessages.current().getSender().equals(Globals.currentAccount)) {
                PrintUtility.printlnCommands(PrintUtility.createMessageMenu(RoleType.OWNER));
            } else {
                PrintUtility.printlnCommands(PrintUtility.createMessageMenu(RoleType.FOREIGNER));
            }
        }

    }

    public static void performMessagesCommand(String command) throws Exception {

        RoleType roleType = RoleType.OWNER;
        if (!Globals.currentPrivateMessages.current().getSender().equals(Globals.currentAccount)) {
            roleType = RoleType.FOREIGNER;
        }

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentPrivateMessages.previous();
                printMessages();
                performMessagesCommand(Main.scanner.nextLine());
                break;


            case "D":
                if (PermissionUtility.hasPermission(Setting.PRIVATE_MESSAGE_PERMISSION, command.toUpperCase(), roleType)) {
                    Globals.currentAccount.getPrivateMessages().removeCurrent(true);
                    Result<PrivateMessage> result = Globals.currentPrivateMessages.removeCurrent(true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Delete Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }
                break;
//            if (PermissionUtility.hasPermission(Setting.PRIVATE_MESSAGE_PERMISSION, command.toUpperCase(), roleType)) {
//                PrivateMessage.deleteMessage(Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex));
//                Globals.currentAccount.getPrivateMessages().remove(Globals.currentAccount.getPrivateMessages().get(Globals.currentPrivateMessageIndex));
//                Globals.currentPrivateMessages.remove(Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex));
//                if (Globals.currentPrivateMessageIndex == Globals.currentPrivateMessages.size()) {
//                    Globals.currentPrivateMessageIndex--;
//                }
//            } else {
//                System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
//            }
//            break;

            case "E":

                if (PermissionUtility.hasPermission(Setting.PRIVATE_MESSAGE_PERMISSION, command.toUpperCase(), roleType)) {
                    String content1 = PostUI.createContentForm(Main.scanner, Globals.currentPosts.current().getContent(), false);
                    Result<PrivateMessage> result = Globals.currentPrivateMessages.current().edit(content1, true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Edit Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }
                break;



//                if (PermissionUtility.hasPermission(Setting.PRIVATE_MESSAGE_PERMISSION, command.toUpperCase(), roleType)) {
//                    System.out.println("Enter Your New Message :");
//                    String editedMessage = Main.scanner.nextLine();
//                    Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex).setContent(editedMessage);
//                    PrivateMessage.editMessage(Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex));
//                } else {
//                    System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
//                }
//                break;

            case "S":
                System.out.println("Enter Your Message :");
                String message = Main.scanner.nextLine();
                PrivateMessage privateMessage = new PrivateMessage();
                privateMessage.setSender(Globals.currentAccount);
                privateMessage.setReceiver(Globals.currentContact);
                privateMessage.setContent(message);
                Result result = PrivateMessage.sendMessage(privateMessage);
                if (!result.isError()) {
                    PrivateMessage privateMessage1 = (PrivateMessage) result.getData();
                    Globals.currentPrivateMessages.add(privateMessage1);
                    Globals.currentAccount.getPrivateMessages().add(privateMessage1);
                }
                Globals.currentPrivateMessageIndex = Globals.currentPrivateMessages.size() - 1;

                break;

            case "R":
                Globals.menuLevels.push(MenuLevel.PRIVATE_MESSAGE_REACT);
                break;

            case "F":
                Globals.currentForwardedGroupMessage = null;
                Globals.currentForwardedPrivateMessage = Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex);
                Globals.menuLevels.push(MenuLevel.FORWARD_CONTACT_OR_GROUP);
                break;

            case "B":
                Globals.currentPrivateMessageIndex = 0;
                Globals.menuLevels.pop();
                break;

            case "L":
                System.out.println("Enter Your Message :");
                message = Main.scanner.nextLine();
                privateMessage = new PrivateMessage();
                privateMessage.setSender(Globals.currentAccount);
                privateMessage.setReceiver(Globals.currentContact);
                privateMessage.setReplyId(Globals.currentPrivateMessages.get(Globals.currentPrivateMessageIndex).getId());
                privateMessage.setContent(message);
                result = PrivateMessage.reply(privateMessage);
                if (!result.isError()) {
                    PrivateMessage privateMessage1 = (PrivateMessage) result.getData();
                    Globals.currentPrivateMessages.add(privateMessage1);
                    Globals.currentAccount.getPrivateMessages().add(privateMessage1);
                }
                Globals.currentPrivateMessageIndex = Globals.currentPrivateMessages.size() - 1;

                break;

            case "N":
                Globals.currentPrivateMessages.next();
                printMessages();
                performMessagesCommand(Main.scanner.nextLine());
                break;

        }
    }

}
