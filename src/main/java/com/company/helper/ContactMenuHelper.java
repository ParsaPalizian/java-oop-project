package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.PrivateMessage;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.Locale;

public class ContactMenuHelper {
    public static void printContacts() {
        if (!Globals.currentAccount.getContacts().isEmpty(true)) {
            Globals.currentAccount.getContacts().current(false);
            PrintUtility.printlnCommands(PrintUtility.createContactMenu(RoleType.OWNER));
        }
    }

    public static void performContactsCommand(String command) throws SQLException {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                if (Globals.currentContactIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Contact");

                    printContacts();
                    performContactsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentContactIndex--;
                    printContacts();
                    performContactsCommand(Main.scanner.nextLine());
                }
                break;

            case "O":
                Globals.currentPrivateMessageIndex = 0;
                Globals.currentPrivateMessages.clear();
                Globals.currentContact=Globals.currentAccount.getContacts().get(Globals.currentContactIndex );
                for(PrivateMessage privateMessage : Globals.currentAccount.getPrivateMessages()){
                    if(privateMessage.getReceiver().getId()== Globals.currentAccount.getContacts().get(Globals.currentContactIndex ).getId()
                            || privateMessage.getSender().getId()==Globals.currentAccount.getContacts().get(Globals.currentContactIndex ).getId()){
                        Globals.currentPrivateMessages.add(privateMessage);
                    }
                }
                Globals.menuLevels.push(MenuLevel.PRIVATE_MESSAGE);
                break;


            case "B":
                Globals.menuLevels.pop();
                break;


            case "N":
                if (Globals.currentContactIndex == Globals.currentAccount.getContacts().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Contact");
                    printContacts();
                    performContactsCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentContactIndex++;
                    printContacts();
                    performContactsCommand(Main.scanner.nextLine());
                }
                break;
        }
    }

}
