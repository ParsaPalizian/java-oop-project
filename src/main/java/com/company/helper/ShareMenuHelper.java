package com.company.helper;

import com.company.global.Globals;

public class ShareMenuHelper {

    public static void printShare() {

        System.out.println("SHARE MENU");
        System.out.println("1- Telegram");
        System.out.println("2- Whatsapp");
        System.out.println("3- SMS");
        System.out.println("0- Logout");
    }

    public static void performShareCommand(String command) {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    Globals.menuLevels.pop();
                    break;

            }
        } catch (Exception ex) {


        }
    }
}
