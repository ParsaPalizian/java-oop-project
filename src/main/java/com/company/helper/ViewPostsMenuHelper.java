package com.company.helper;

import com.company.Result;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Comment;
import com.company.model.Post;
import com.company.settings.Setting;
import com.company.ui.PostUI;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class ViewPostsMenuHelper {
    public static void printViewPosts() {
        if (!Globals.currentPosts.isEmpty(true)) {
            Globals.currentPosts.current(true);
            if (Globals.currentAccount.equals(Globals.loggedInAccount)) {
                PrintUtility.printlnCommands(PrintUtility.createViewPostsMenu(RoleType.OWNER));
            } else {
                PrintUtility.printlnCommands(PrintUtility.createViewPostsMenu(RoleType.FOREIGNER));
            }
        }
    }

    public static void performViewPostsCommand(String command) throws Exception {
        RoleType roleType = RoleType.OWNER;
        if (!Globals.currentAccount.equals(Globals.loggedInAccount)) {
            roleType = RoleType.FOREIGNER;
        }
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentPosts.previous();
                printViewPosts();
                performViewPostsCommand(Main.scanner.nextLine());
                break;
            case "R":
                Globals.menuLevels.push(MenuLevel.POST_REACT);
                break;
            case "C":
                System.out.println("Enter Your Comment :");
                String content = Main.scanner.nextLine();
                Comment comment = new Comment(Globals.currentAccount, content);
                Comment.comment(Globals.currentPosts.current(), comment);
                Globals.currentPosts.current().getComments().add(comment);
                break;

            case "B":
                Globals.menuLevels.pop();
                break;

            case "V":
                Globals.currentComments = Globals.currentPosts.current().getComments();
                Globals.menuLevels.push(MenuLevel.VIEW_COMMENTS);
                break;

            case "E":

                if (PermissionUtility.hasPermission(Setting.VIEW_POSTS_PERMISSION, command.toUpperCase(), roleType)) {
                    String content1 = PostUI.createContentForm(Main.scanner, Globals.currentPosts.current().getContent(), false);
                    Result<Post> result = Globals.currentPosts.current().edit(content1, true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Edit Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }

                break;

            case "D":
                if (PermissionUtility.hasPermission(Setting.VIEW_POSTS_PERMISSION, command.toUpperCase(), roleType)) {
                    Result<Post> result = Globals.currentPosts.removeCurrent(true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Delete Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }
                break;
            case "N":
                Globals.currentPosts.next();
                printViewPosts();
                performViewPostsCommand(Main.scanner.nextLine());
                break;
        }
    }

}
