package com.company.helper;

import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class ViewProfilePictureMenuHelper {
    public static void printViewProfilePictures() {

        System.out.println(Globals.currentAccount.getProfilePictures().get(Globals.currentProfilePictureIndex).getAddress());
        if (Globals.currentAccount.equals(Globals.loggedInAccount)) {
            PrintUtility.printlnCommands(PrintUtility.createViewProfilePicturesMenu(RoleType.OWNER));
        }else{
            PrintUtility.printlnCommands(PrintUtility.createViewProfilePicturesMenu(RoleType.FOREIGNER));
        }
    }

    public static void performViewProfilePicturesCommand(String command) throws Exception {

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                //Globals.currentProfilePictureIndex = 0;
                if (Globals.currentProfilePictureIndex == 0) {
                    PrintUtility.printlnFail("You Are On First Profile Picture");

                    printViewProfilePictures();
                    performViewProfilePicturesCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentProfilePictureIndex--;
                    printViewProfilePictures();
                    performViewProfilePicturesCommand(Main.scanner.nextLine());
                }
                break;


            case "Q":
                Globals.currentProfilePictureIndex =0;
                Globals.menuLevels.pop();

                break;

            case "D":
                Globals.currentAccount.deleteProfilePicture(Globals.currentAccount.getProfilePictures().get(Globals.currentProfilePictureIndex));
                break;


            case "N":
                if (Globals.currentProfilePictureIndex == Globals.currentAccount.getProfilePictures().size() - 1) {
                    PrintUtility.printlnFail("You Reached To Last Profile Picture");
                    printViewProfilePictures();
                    performViewProfilePicturesCommand(Main.scanner.nextLine());
                } else {
                    Globals.currentProfilePictureIndex++;
                    printViewProfilePictures();
                    performViewProfilePicturesCommand(Main.scanner.nextLine());
                }
                break;
        }
    }

}
