package com.company.helper;

import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Comment;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Locale;

public class TimelineMenuHelper {
    public static void printTimeline() throws SQLException, ParseException {
        if (!Globals.currentPosts.isEmpty(true)) {
            Globals.currentPosts.current(true);
            PrintUtility.printlnCommands(PrintUtility.createViewPostsMenu(RoleType.FOREIGNER));
        }
    }

    public static void performTimelineCommand(String command) throws SQLException, ParseException {
        switch (command.toUpperCase(Locale.ROOT)) {
            case "P":
                Globals.currentPosts.previous();
                printTimeline();
                performTimelineCommand(Main.scanner.nextLine());
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

            case "B": {
                Globals.menuLevels.pop();
                break;
            }
            case "S": {
                Globals.menuLevels.push(MenuLevel.SHARE);
                break;
            }
            case "O": {
                Globals.currentAccount = Globals.currentPosts.current().getAccount();
                Globals.menuLevels.push(MenuLevel.HOME);
                break;
            }
            case "V": {
                Globals.currentComments = Globals.currentPosts.current().getComments();
                Globals.menuLevels.push(MenuLevel.VIEW_COMMENTS);
                break;
            }

            case "N":
                Globals.currentPosts.next();
                printTimeline();
                performTimelineCommand(Main.scanner.nextLine());
                break;

        }
    }
}
