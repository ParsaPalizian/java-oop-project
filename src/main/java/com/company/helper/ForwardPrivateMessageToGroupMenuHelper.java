package com.company.helper;

import com.company.Result;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.GroupMessage;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class ForwardPrivateMessageToGroupMenuHelper {
    public static void printForwardToGroup() {
        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentForwardGroupIndex).getName());
        PrintUtility.printlnCommands(PrintUtility.createForwardMessageToMenu(RoleType.OWNER));
    }
    public static void performForwardToGroupCommand(String command) throws SQLException {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentForwardGroupIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Group");

                    printForwardToGroup();
                    performForwardToGroupCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentForwardGroupIndex--;
                    printForwardToGroup();
                    performForwardToGroupCommand(Main.scanner.nextLine());
                }
                break;

            case "S":
                GroupMessage message=new GroupMessage();
                message.setSender(Globals.currentAccount);
                message.setGroup(Globals.currentAccount.getGroups().get(Globals.currentForwardGroupIndex));
                message.setForwardedFromId(Globals.currentForwardedPrivateMessage.getSender().getId());
                message.setContent(Globals.currentForwardedPrivateMessage.getContent());
                Result result =GroupMessage.sendMessage(message);
                if(!result.isError()){
                    GroupMessage groupMessage = (GroupMessage) result.getData();
                    Globals.currentGroupMessages.add(groupMessage);
                    Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().add(groupMessage);
                }
                Globals.menuLevels.pop();
                Globals.menuLevels.pop();
                break;

            case "C":
                Globals.menuLevels.pop();
                break;


            case "N":
                if (Globals.currentForwardGroupIndex == Globals.currentAccount.getGroups().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Group");
                    printForwardToGroup();
                    performForwardToGroupCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentForwardGroupIndex++;
                    printForwardToGroup();
                    performForwardToGroupCommand(Main.scanner.nextLine());
                }
                break;
        }
    }
}
