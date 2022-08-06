package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.utility.PrintUtility;

public class ExplorerMenuHelper {
    public static void printExplorer() {
        //todo
        System.out.println("EXPLORER MENU");
        System.out.println("1- Open Post");
        System.out.println("0- Back");
    }

    public static void performExplorerCommand(String command) {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    Globals.menuLevels.push(MenuLevel.EXPLORER_POSTS);
                    break;
                case 0:
                    Globals.menuLevels.pop();

                    break;

            }
        }catch (Exception ex){
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }

}
