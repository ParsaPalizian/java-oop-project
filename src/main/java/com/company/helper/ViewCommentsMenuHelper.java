package com.company.helper;

import com.company.Result;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Comment;
import com.company.settings.Setting;
import com.company.ui.PostUI;
import com.company.utility.PermissionUtility;
import com.company.utility.PrintUtility;

import java.util.Locale;

public class ViewCommentsMenuHelper {
    public static void printViewComments() {
        if (!Globals.currentComments.isEmpty(true)) {
            Globals.currentComments.current(true);
            if (Globals.currentAccount.equals(Globals.loggedInAccount)) {
                PrintUtility.printlnCommands(PrintUtility.createPostCommentsMenu(RoleType.OWNER));
            } else {
                PrintUtility.printlnCommands(PrintUtility.createPostCommentsMenu(RoleType.FOREIGNER));
            }
        }
    }

    public static void performViewCommentsCommand(String command) throws Exception {

        RoleType roleType = RoleType.OWNER;
        if (!Globals.currentAccount.equals(Globals.loggedInAccount)) {
            roleType = RoleType.FOREIGNER;
        }

        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentComments.previous();
                printViewComments();
                performViewCommentsCommand(Main.scanner.nextLine());
                break;

            case "R":
                Globals.menuLevels.push(MenuLevel.COMMENT_REACT);
                break;
            case "L":
                System.out.println("Enter Your Comment :");
                String content = Main.scanner.nextLine();
                Comment comment = new Comment(Globals.currentAccount, content);
                comment.setReplyId(Globals.currentComments.current().getId());
                Comment.reply(Globals.currentPosts.current(), comment);
                Globals.currentPosts.current().getComments().add(comment);
                break;

            case "Q":
                Globals.menuLevels.pop();
                break;

            case "E":
                if (PermissionUtility.hasPermission(Setting.VIEW_POST_COMMENTS_PERMISSION, command.toUpperCase(), roleType)) {
                    String content1 = PostUI.createContentForm(Main.scanner, Globals.currentPosts.current().getContent(), false);
                    Result<Comment> result = Globals.currentComments.current().edit(content1, true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Edit Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }
                break;

            case "D":

                if (PermissionUtility.hasPermission(Setting.VIEW_POST_COMMENTS_PERMISSION, command.toUpperCase(), roleType)) {
                    Result<Comment> result = Globals.currentComments.removeCurrent(true);
                    if (!result.isError())
                        PrintUtility.printlnSuccess("Delete Successful");
                    else
                        PrintUtility.printlnFail("Error Raised");
                } else {
                    PrintUtility.printlnFail("YOU DONT HAVE PERMISSION");
                }
                break;

            case "N":
                Globals.currentComments.next();
                printViewComments();
                performViewCommentsCommand(Main.scanner.nextLine());
                break;

        }
    }
}
