package com.company.utility;

import com.company.enums.CommandColors;
import com.company.enums.ReactionType;
import com.company.enums.RoleType;
import com.company.model.*;
import com.company.permission.Permission;
import com.company.settings.Setting;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintUtility {

    public static String createHomeMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.HOME_MENU_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createProfilePictureMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.VIEW_PROFILE_PICTURES_MENU_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createMessageMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.PRIVATE_MESSAGE_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createViewPostsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.VIEW_POSTS_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createGroupMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.GROUP_ITEMS_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createGroupMembersMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.GROUP_CONTACTS_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createGroupContentsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.GROUP_CONTENTS_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createPostCommentsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.VIEW_POST_COMMENTS_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }


    public static String createBlockListMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.BLOCKLIST_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createContactMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.CONTACT_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createAddGroupMemberMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.ADD_GROUP_MEMBER_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createFollowersMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.FOLLOWERS_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createFollowingsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.FOLLOWINGS_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createForwardMessageToMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.FORWARD_MESSAGE_TO_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createRequestMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.REQUEST_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createSearchedAccountsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.SEARCHED_ACCOUNTS_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createRecommendAccountsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.RECOMMEND_ACCOUNTS_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createSearchUsernameMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.SEARCH_USERNAME_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("--", commands.toArray(new String[0]));
    }

    public static String createViewProfilePicturesMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.VIEW_PROFILE_PICTURE_PERMISSION) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createForwardContactOrGroupMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.FORWARD_CONTACT_OR_GROUP_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createGroupsMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.GROUPS_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createMainMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.MAIN_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static String createPostingMenu(RoleType roleType) {
        ArrayList<String> commands = new ArrayList<>();
        for (Permission permission : Setting.POSTING_PERMISSIONS) {
            if (permission.getRole() == roleType && permission.isAllowed()) {
                commands.add(permission.getCommand());
            }
        }
        return String.join("\n", commands.toArray(new String[0]));
    }

    public static void createLoginMenu() {
        System.out.println("LOGIN MENU");
        System.out.println("1- Login");
        System.out.println("2- Sign up");
        System.out.println("3- forget Password");
        System.out.println("0- Exit");
    }

    public static void createSearchMenu() {
        System.out.println("SEARCH MENU");
        System.out.println("1- Search Username");
        System.out.println("2- Search History");
        System.out.println("3- Clear Search History");
        System.out.println("0- Back");
    }

    public static void createSearchUsernameMenu() {
        System.out.println("SEARCH MENU");
        System.out.println("1- Search Username");
        System.out.println("2- Search History");
        System.out.println("3- Clear Search History");
        System.out.println("0- Back");
    }

    public static void createEmojisMenu() {
        System.out.print("1)\uD83D\uDE02---");
        System.out.print("2)\u2764---");
        System.out.print("3)\uD83D\uDC4D---");
        System.out.print("4)\uD83D\uDC4E---");
        System.out.print("5)\uD83D\uDE10---");
        System.out.print("6)\uD83E\uDD2C---");
        System.out.print("7)\uD83D\uDE2D---");
        System.out.print("8)\uD83E\uDD2E---");
        System.out.print("9)\uD83D\uDD25---");
        System.out.println("0)back");
    }



    public static void printlnCommands(String command) {
        System.out.println(CommandColors.ANSI_YELLOW + command + CommandColors.ANSI_RESET);
    }


    public static void printCommands(String command) {
        System.out.print(CommandColors.ANSI_YELLOW + command + CommandColors.ANSI_RESET);
    }

    public static void printlnMenus(String command) {
        System.out.println(CommandColors.ANSI_RESET + command + CommandColors.ANSI_RESET);
    }

    public static void printlnCommands(String format, String args) { //TODO NEEDS LOTS OF WORK
        System.out.println(CommandColors.ANSI_YELLOW +
                String.format(format, args) +
                CommandColors.ANSI_RESET);
    }


    public static void printlnFail(String command) {
        System.out.println(CommandColors.ANSI_RED + command + CommandColors.ANSI_RESET);
    }

    public static void printFail(String command) {
        System.out.print(CommandColors.ANSI_RED + command + CommandColors.ANSI_RESET);
    }

    public static void printlnSuccess(String command) {
        System.out.println(CommandColors.ANSI_GREEN + command + CommandColors.ANSI_RESET);
    }

    public static void printSuccess(String command) {
        System.out.print(CommandColors.ANSI_GREEN + command + CommandColors.ANSI_RESET);
    }


    public static void printPost(Post post) {
        System.out.println(CommandColors.ANSI_BLUE + "###############################################");
        System.out.println(CommandColors.ANSI_BLUE + post.getId());
        if (post.getAccount() != null && post.getAccount().getUserName() != null && !post.getAccount().getUserName().isEmpty()) {
            System.out.println(CommandColors.ANSI_BLUE + post.getAccount().getUserName());
        }
        System.out.println(CommandColors.ANSI_BLUE + post.getMedia());
        System.out.println(CommandColors.ANSI_BLUE + post.getContent());
        System.out.println(CommandColors.ANSI_BLUE + "###############################################" + CommandColors.ANSI_RESET);
    }


    public static void printComment(Comment comment) {
        System.out.println(CommandColors.ANSI_PURPLE + comment.getId());
        System.out.println(CommandColors.ANSI_PURPLE + comment.getContent());
        System.out.println(CommandColors.ANSI_RESET);
    }

    public static void printPrivateMessage(PrivateMessage message) {
        System.out.println(message.getSender().getUserName() + " :");
        System.out.println(message.getContent());
    }

    public static void printGroupMessage(GroupMessage message) {
        System.out.println(message.getSender().getUserName() + " :");
        System.out.println(message.getContent());
    }

    public static void printGroupMember(GroupMember member) {
        System.out.println(member.getMember().getUserName() + " :");
    }

    public static void printViewer(View view) {
        System.out.println(view.getAccount().getUserName() + " :");
    }

    public static void printRequest(Request request) {
        System.out.println(request.getFrom().getUserName() + " :");
    }

    public static void printReaction(Reaction reaction) {
        System.out.println(reaction.getType() + " :");
    }

    public static void printProfilePicture(ProfilePicture profilePicture) {
        System.out.println(profilePicture.getAddress() + " :");
    }

    public static void printGroup(Group group) {
        System.out.println(group.getName() + " :");
        System.out.println(group.getBio() + " :");
    }

    public static void printFollow(Follow follow) {
        System.out.println(follow.getAccount().getUserName() + " :");
    }

    public static void printBlock(Block block) {
        System.out.println(block.getBlocked().getUserName() + " :");
    }

    public static void printAccount(Account account) {
        System.out.println(account.getUserName() + " :");
    }

    public static void printlnEmojisSummary(LinkedHashMap<ReactionType, Integer> reacts) {
        for (Map.Entry<ReactionType, Integer> entry : reacts.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.print("( " + entry.getKey() + " : " + entry.getValue() + " )   ");
            }
        }
        System.out.println();
    }


}
