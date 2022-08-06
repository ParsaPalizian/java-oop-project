package com.company.helper;

import com.company.Result;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.PrivateMessage;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class ForwardGroupMessageToContactMenuHelper {
    public static void printForwardToContacts() {
        System.out.println(Globals.currentAccount.getContacts().get(Globals.currentForwardContactIndex).getUserName());
        PrintUtility.printlnCommands(PrintUtility.createForwardMessageToMenu(RoleType.OWNER));
    }
    public static void performForwardToContactsCommand(String command) throws SQLException {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentForwardContactIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Contact");

                    printForwardToContacts();
                    performForwardToContactsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentForwardContactIndex--;
                    printForwardToContacts();
                    performForwardToContactsCommand(Main.scanner.nextLine());
                }
                break;

            case "S":
                PrivateMessage privateMessage=new PrivateMessage();
                privateMessage.setSender(Globals.currentAccount);
                privateMessage.setReceiver(Globals.currentAccount.getContacts().get(Globals.currentForwardContactIndex));
                privateMessage.setForwardedFromId(Globals.currentForwardedGroupMessage.getSender().getId());
                privateMessage.setContent(Globals.currentForwardedGroupMessage.getContent());
                Result result =PrivateMessage.sendMessage(privateMessage);
                if(!result.isError()){
                    PrivateMessage privateMessage1 = (PrivateMessage) result.getData();
                    Globals.currentPrivateMessages.add(privateMessage1);
                    Globals.currentAccount.getPrivateMessages().add(privateMessage1);
                }
                Globals.menuLevels.pop();
                Globals.menuLevels.pop();
                break;

            case "C":
                Globals.menuLevels.pop();
                break;


            case "N":
                if (Globals.currentForwardContactIndex == Globals.currentAccount.getContacts().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Contact");
                    printForwardToContacts();
                    performForwardToContactsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentForwardContactIndex++;
                    printForwardToContacts();
                    performForwardToContactsCommand(Main.scanner.nextLine());
                }
                break;
        }
    }
}
