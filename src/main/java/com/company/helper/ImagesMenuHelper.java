package com.company.helper;

import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.model.Comment;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.util.ArrayList;

public class ImagesMenuHelper {
    public static void printImages() {
        System.out.println("IMAGES MENU");
        System.out.println("1- React");
        System.out.println("2- Comment");
        System.out.println("3- Share");
        System.out.println("0- Back");
    }

    public static void performImageCommand(String command) throws SQLException {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1: {
                    System.out.println("enter postId :");
                    String postId = Main.scanner.nextLine();

                    System.out.println("choose reactType");
                    System.out.println("1- ");
                    System.out.println("2- ");
                    System.out.println("3- ");
                    System.out.println("4- ");
                    System.out.println("5- ");
                    System.out.println("6- ");
                    System.out.println("7- ");
                    System.out.println("8- ");
                    System.out.println("9- ");
                    System.out.println("10- ");
                    String reactType = Main.scanner.nextLine();

//                    Account.react(Globals.currentAccount, null, null);
                    break;
                }
                case 2: {
                    System.out.println("enter postId :");
                    String postId = Main.scanner.nextLine();

                    System.out.println("enter your comment :");
                    String postComment = Main.scanner.nextLine();

                    Comment.comment(null, null);
                    break;
                }
                case 3: {
                    System.out.println("enter postId :");
                    String postId = Main.scanner.nextLine();

                    System.out.println("enter receiversId");
                    ArrayList<Integer> receiversId = new ArrayList<>();
                    //todo getReceiversId

                    Account.share(Globals.currentAccount, null, null);
                    break;
                }
                case 0: {
                    Globals.menuLevels.pop();

                    break;
                }
            }
        }catch (Exception ex){
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }

}
