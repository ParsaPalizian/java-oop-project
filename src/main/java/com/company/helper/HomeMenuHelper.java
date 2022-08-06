package com.company.helper;

import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.global.Temp;
import com.company.model.Account;
import com.company.settings.Setting;
import com.company.utility.PermissionUtility;
import com.company.utility.PostUtility;
import com.company.utility.PrintUtility;

public class HomeMenuHelper {
    public static void printHome() {
        System.out.println("HOME MENU");

        if (Globals.currentAccount.equals(Globals.loggedInAccount)) {
             PrintUtility.printlnMenus(PrintUtility.createHomeMenu(RoleType.OWNER));
        } else {
            PrintUtility.printlnMenus(PrintUtility.createHomeMenu(RoleType.FOREIGNER));
        }

//        System.out.println("1- Profile Picture");
//        System.out.println("2- Posting");
//        System.out.println("3- Followers");
//        System.out.println("4- Followings");
//        System.out.println("5- View Posts");
//        System.out.println("6- Images");
//        System.out.println("7- Videos");
//        System.out.println("8- Audios");
//        System.out.println("9- Texts");
//        System.out.println("10- Groups");
//        System.out.println("11- Private Messages");
//        System.out.println("0- Back");


    }

    public static void performHomeCommand(String command) {
        RoleType roleType=Globals.currentAccount.equals(Globals.loggedInAccount) ? RoleType.OWNER : RoleType.FOREIGNER;
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1:
                    Globals.menuLevels.push(MenuLevel.PROFILE);
                    break;

                case 2:
                    if (PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION, command.toUpperCase(), roleType)) {
                        Globals.menuLevels.push(MenuLevel.POSTING);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 3:
                    Globals.menuLevels.push(MenuLevel.FOLLOWERS);
                    break;

                case 4:
                    Globals.menuLevels.push(MenuLevel.FOLLOWINGS);
                    break;

                case 5:
                    Globals.menuLevels.push(MenuLevel.VIEW_POSTS);
                    break;

                case 6:
                    Temp.images = PostUtility.getImagePosts(Globals.currentAccount.getPosts());
                    Globals.menuLevels.push(MenuLevel.VIEW_IMAGES);
                    break;

                case 7:
                    Temp.videos = PostUtility.getVideosPosts(Globals.currentAccount.getPosts());
                    Globals.menuLevels.push(MenuLevel.VIEW_VIDEOS);
                    break;

                case 8:
                    Temp.audios = PostUtility.getAudiosPosts(Globals.currentAccount.getPosts());
                    Globals.menuLevels.push(MenuLevel.VIEW_AUDIOS);
                    break;

                case 9:
                    Temp.texts = PostUtility.getTextPosts(Globals.currentAccount.getPosts());
                    Globals.menuLevels.push(MenuLevel.VIEW_TEXTS);
                    break;

                case 10:
                    if (PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION, command.toUpperCase(), roleType)) {
                        Globals.menuLevels.push(MenuLevel.GROUPS);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;


                case 11:
                    if (PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION, command.toUpperCase(), roleType)) {

//                        Globals.currentPrivateMessages=Globals.currentAccount.getPrivateMessages();
                        Globals.menuLevels.push(MenuLevel.MESSAGES);

                    }else {
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;


                case 12:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){

                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;


                case 13:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){

                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;


                case 14:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){
                            Account.sendRequest(Globals.loggedInAccount,Globals.currentAccount);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 15:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){
                            Globals.menuLevels.push(MenuLevel.BLOCKLIST);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 16:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){
                        Globals.menuLevels.push(MenuLevel.REQUEST_LIST);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 17:
                    if(PermissionUtility.hasPermission(Setting.HOME_MENU_PERMISSION,command.toUpperCase(),roleType)){
                        Globals.recommendAccounts=Globals.currentAccount.recommend(Setting.RECOMMEND_AMOUNT).getData();
                        Globals.menuLevels.push(MenuLevel.RECOMMEND);
                    }else{
                        System.out.println(CommandColors.ANSI_RED + "YOU DONT HAVE PERMISSION");
                    }
                    break;

                case 0:
                    Globals.currentAccount = Globals.loggedInAccount;
                    Globals.menuLevels.pop();

                    break;

            }
        }catch (Exception ex ){
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }

}
