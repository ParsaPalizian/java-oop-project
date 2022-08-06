package com.company.settings;

import com.company.enums.RoleType;
import com.company.permission.Permission;

import java.util.ArrayList;

public class Setting {

    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int PASSWORD_MAX_LENGTH = 10;
    public static final int RECOMMEND_AMOUNT = 10;

    public static final ArrayList<Permission> PRIVATE_MESSAGE_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> VIEW_POSTS_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> GROUP_ITEMS_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> GROUP_CONTACTS_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> GROUP_CONTENTS_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> VIEW_PROFILE_PICTURE_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> VIEW_POST_COMMENTS_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> HOME_MENU_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> VIEW_PROFILE_PICTURES_MENU_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> VIEW_FOLLOWERS_MENU_PERMISSION = new ArrayList<>();


    public static final ArrayList<Permission> BLOCKLIST_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> CONTACT_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> REQUEST_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> ADD_GROUP_MEMBER_PERMISSION = new ArrayList<>();
    public static final ArrayList<Permission> FOLLOWERS_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> FOLLOWINGS_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> FORWARD_MESSAGE_TO_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> FORWARD_CONTACT_OR_GROUP_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> GROUPS_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> MAIN_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> POSTING_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> SEARCH_USERNAME_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> SEARCHED_ACCOUNTS_PERMISSIONS = new ArrayList<>();
    public static final ArrayList<Permission> RECOMMEND_ACCOUNTS_PERMISSIONS = new ArrayList<>();


//    public static final ArrayList<Permission> MESSAGE_PERMISSION = new ArrayList<>();

    static {
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(P)rior", RoleType.FOREIGNER, true, "P"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(P)rior", RoleType.OWNER, true, "P"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(D)elete", RoleType.FOREIGNER, false, "D"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(E)dit", RoleType.FOREIGNER, false, "E"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(E)dit", RoleType.OWNER, true, "E"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(R)eact", RoleType.FOREIGNER, true, "R"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(R)eact", RoleType.OWNER, true, "R"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(S)end Message", RoleType.FOREIGNER, true, "S"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(S)end Message", RoleType.OWNER, true, "S"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("Rep(l)y", RoleType.FOREIGNER, true, "L"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("Rep(l)y", RoleType.OWNER, true, "L"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(F)oreward", RoleType.FOREIGNER, true, "F"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(F)oreward", RoleType.OWNER, true, "F"));

        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));
        PRIVATE_MESSAGE_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));

        VIEW_POSTS_PERMISSION.add(new Permission("(P)rior", RoleType.FOREIGNER, true, "P"));
        VIEW_POSTS_PERMISSION.add(new Permission("(P)rior", RoleType.OWNER, true, "P"));

        VIEW_POSTS_PERMISSION.add(new Permission("(D)elete", RoleType.FOREIGNER, false, "D"));
        VIEW_POSTS_PERMISSION.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));

        VIEW_POSTS_PERMISSION.add(new Permission("(E)dit", RoleType.FOREIGNER, false, "E"));
        VIEW_POSTS_PERMISSION.add(new Permission("(E)dit", RoleType.OWNER, true, "E"));

        VIEW_POSTS_PERMISSION.add(new Permission("(V)iewComments", RoleType.FOREIGNER, true, "V"));
        VIEW_POSTS_PERMISSION.add(new Permission("(V)iewComments", RoleType.OWNER, true, "V"));

        VIEW_POSTS_PERMISSION.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));
        VIEW_POSTS_PERMISSION.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));

        VIEW_POSTS_PERMISSION.add(new Permission("(R)eact", RoleType.FOREIGNER, true, "R"));
        VIEW_POSTS_PERMISSION.add(new Permission("(R)eact", RoleType.OWNER, true, "R"));

        VIEW_POSTS_PERMISSION.add(new Permission("(O)pen Account", RoleType.FOREIGNER, true, "O"));
        VIEW_POSTS_PERMISSION.add(new Permission("(O)pen Account", RoleType.OWNER, false, "O"));

        VIEW_POSTS_PERMISSION.add(new Permission("(S)hare", RoleType.FOREIGNER, true, "S"));
        VIEW_POSTS_PERMISSION.add(new Permission("(S)hare", RoleType.OWNER, true, "S"));


        VIEW_POSTS_PERMISSION.add(new Permission("(C)omment", RoleType.FOREIGNER, true, "C"));
        VIEW_POSTS_PERMISSION.add(new Permission("(C)omment", RoleType.OWNER, true, "C"));

        VIEW_POSTS_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));
        VIEW_POSTS_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));


        GROUP_ITEMS_PERMISSION.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(M)ember", RoleType.OWNER, true, "M"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(M)ember", RoleType.FOREIGNER, true, "M"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(C)ontent", RoleType.OWNER, true, "C"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(C)ontent", RoleType.FOREIGNER, true, "C"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(L)eave", RoleType.OWNER, true, "L"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(L)eave", RoleType.FOREIGNER, true, "L"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(D)elete", RoleType.FOREIGNER, false, "D"));

        GROUP_ITEMS_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        GROUP_ITEMS_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        GROUP_CONTACTS_PERMISSION.add(new Permission("(P)erior", RoleType.ADMIN, true, "P"));
        GROUP_CONTACTS_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        GROUP_CONTACTS_PERMISSION.add(new Permission("(K)ick", RoleType.ADMIN, true, "K"));
        GROUP_CONTACTS_PERMISSION.add(new Permission("(K)ick", RoleType.FOREIGNER, false, "K"));

        GROUP_CONTACTS_PERMISSION.add(new Permission("(B)ack", RoleType.ADMIN, true, "B"));
        GROUP_CONTACTS_PERMISSION.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        GROUP_CONTACTS_PERMISSION.add(new Permission("(O)pen", RoleType.ADMIN, true, "O"));
        GROUP_CONTACTS_PERMISSION.add(new Permission("(O)pen", RoleType.FOREIGNER, true, "O"));

        GROUP_CONTACTS_PERMISSION.add(new Permission("(N)ext", RoleType.ADMIN, true, "N"));
        GROUP_CONTACTS_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        GROUP_CONTENTS_PERMISSION.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(P)erior", RoleType.ADMIN, true, "P"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("Rep(l)y", RoleType.OWNER, true, "l"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("Rep(l)y", RoleType.ADMIN, true, "l"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("Rep(l)y", RoleType.FOREIGNER, true, "l"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("(R)eact", RoleType.OWNER, true, "R"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(R)eact", RoleType.ADMIN, true, "R"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(R)eact", RoleType.FOREIGNER, true, "R"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("(F)orward", RoleType.OWNER, true, "F"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(F)orward", RoleType.ADMIN, true, "F"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(F)orward", RoleType.FOREIGNER, true, "F"));


        GROUP_CONTENTS_PERMISSION.add(new Permission("(S)end Message", RoleType.OWNER, true, "S"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(S)end Message", RoleType.ADMIN, true, "S"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(S)end Message", RoleType.FOREIGNER, true, "S"));


        GROUP_CONTENTS_PERMISSION.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(B)ack", RoleType.ADMIN, true, "B"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(D)elete", RoleType.ADMIN, true, "D"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(D)elete", RoleType.FOREIGNER, false, "D"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("(E)dit", RoleType.OWNER, true, "E"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(E)dit", RoleType.ADMIN, false, "E"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(E)dit", RoleType.FOREIGNER, false, "E"));

        GROUP_CONTENTS_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(N)ext", RoleType.ADMIN, true, "N"));
        GROUP_CONTENTS_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(Q)uit", RoleType.OWNER, true, "Q"));
        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(Q)uit", RoleType.FOREIGNER, true, "Q"));

        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(D)elet", RoleType.OWNER, true, "D"));
        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(D)elet", RoleType.FOREIGNER, false, "D"));

        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        VIEW_PROFILE_PICTURE_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(R)eact", RoleType.OWNER, true, "R"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(R)eact", RoleType.FOREIGNER, true, "R"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("Rep(l)y", RoleType.OWNER, true, "L"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("Rep(l)y", RoleType.FOREIGNER, true, "L"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(Q)uit", RoleType.OWNER, true, "Q"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(Q)uit", RoleType.FOREIGNER, true, "Q"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(E)dit", RoleType.OWNER, true, "E"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(E)dit", RoleType.FOREIGNER, false, "E"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(D)elete", RoleType.FOREIGNER, false, "D"));

        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        VIEW_POST_COMMENTS_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        HOME_MENU_PERMISSION.add(new Permission("1-Profile Picture", RoleType.OWNER, true, "1"));
        HOME_MENU_PERMISSION.add(new Permission("1-Profile Picture", RoleType.FOREIGNER, true, "1"));

        HOME_MENU_PERMISSION.add(new Permission("2-Posting", RoleType.OWNER, true, "2"));
        HOME_MENU_PERMISSION.add(new Permission("2-Posting", RoleType.FOREIGNER, false, "2"));

        HOME_MENU_PERMISSION.add(new Permission("3-Followers", RoleType.OWNER, true, "3"));
        HOME_MENU_PERMISSION.add(new Permission("3-Followers", RoleType.FOREIGNER, true, "3"));

        HOME_MENU_PERMISSION.add(new Permission("4-Followings", RoleType.OWNER, true, "4"));
        HOME_MENU_PERMISSION.add(new Permission("4-Followings", RoleType.FOREIGNER, true, "4"));

        HOME_MENU_PERMISSION.add(new Permission("5-View Posts", RoleType.OWNER, true, "5"));
        HOME_MENU_PERMISSION.add(new Permission("5-View Posts", RoleType.FOREIGNER, true, "5"));

        HOME_MENU_PERMISSION.add(new Permission("6-Images", RoleType.OWNER, true, "6"));
        HOME_MENU_PERMISSION.add(new Permission("6-Images", RoleType.FOREIGNER, true, "6"));

        HOME_MENU_PERMISSION.add(new Permission("7-Videos", RoleType.OWNER, true, "7"));
        HOME_MENU_PERMISSION.add(new Permission("7-Videos", RoleType.FOREIGNER, true, "7"));

        HOME_MENU_PERMISSION.add(new Permission("8-Audios", RoleType.OWNER, true, "8"));
        HOME_MENU_PERMISSION.add(new Permission("8-Audios", RoleType.FOREIGNER, true, "8"));

        HOME_MENU_PERMISSION.add(new Permission("9-Texts", RoleType.OWNER, true, "9"));
        HOME_MENU_PERMISSION.add(new Permission("9-Texts", RoleType.FOREIGNER, true, "9"));

        HOME_MENU_PERMISSION.add(new Permission("10-Groups", RoleType.OWNER, true, "10"));
        HOME_MENU_PERMISSION.add(new Permission("10-Groups", RoleType.FOREIGNER, false, "10"));

        HOME_MENU_PERMISSION.add(new Permission("11-Private Messages", RoleType.OWNER, true, "11"));
        HOME_MENU_PERMISSION.add(new Permission("11-Private Messages", RoleType.FOREIGNER, false, "11"));

        HOME_MENU_PERMISSION.add(new Permission("12-Call", RoleType.OWNER, false, "12"));
        HOME_MENU_PERMISSION.add(new Permission("12-Call", RoleType.FOREIGNER, true, "12"));

        HOME_MENU_PERMISSION.add(new Permission("13-Email", RoleType.OWNER, false, "13"));
        HOME_MENU_PERMISSION.add(new Permission("13-Email", RoleType.FOREIGNER, true, "13"));

        HOME_MENU_PERMISSION.add(new Permission("14-Request", RoleType.OWNER, false, "14"));
        HOME_MENU_PERMISSION.add(new Permission("14-Request", RoleType.FOREIGNER, true, "14"));

        HOME_MENU_PERMISSION.add(new Permission("15-Blocklist", RoleType.OWNER, true, "15"));
        HOME_MENU_PERMISSION.add(new Permission("15-Blocklist", RoleType.FOREIGNER, false, "15"));

        HOME_MENU_PERMISSION.add(new Permission("16-RequestList", RoleType.OWNER, true, "16"));
        HOME_MENU_PERMISSION.add(new Permission("16-RequestList", RoleType.FOREIGNER, false, "16"));

        HOME_MENU_PERMISSION.add(new Permission("17-RecommendAccounts", RoleType.OWNER, true, "17"));
        HOME_MENU_PERMISSION.add(new Permission("17-RecommendAccounts", RoleType.FOREIGNER, false, "17"));

        HOME_MENU_PERMISSION.add(new Permission("0-Back", RoleType.OWNER, true, "0"));
        HOME_MENU_PERMISSION.add(new Permission("0-Back", RoleType.FOREIGNER, true, "0"));


        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("1-View Profile Pictures", RoleType.OWNER, true, "1"));
        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("1-View Profile Pictures", RoleType.FOREIGNER, true, "1"));

        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("2-Add New Profile Picture", RoleType.OWNER, true, "2"));
        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("2-Add New Profile Picture", RoleType.FOREIGNER, false, "2"));

        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("0-Back", RoleType.OWNER, true, "0"));
        VIEW_PROFILE_PICTURES_MENU_PERMISSION.add(new Permission("0-Back", RoleType.FOREIGNER, true, "0"));



        BLOCKLIST_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        BLOCKLIST_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        BLOCKLIST_PERMISSIONS.add(new Permission("(U)nblock", RoleType.OWNER, true, "U"));
        BLOCKLIST_PERMISSIONS.add(new Permission("(U)nblock", RoleType.FOREIGNER, false, "U"));

        BLOCKLIST_PERMISSIONS.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        BLOCKLIST_PERMISSIONS.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        BLOCKLIST_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        BLOCKLIST_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));

        CONTACT_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        CONTACT_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        CONTACT_PERMISSIONS.add(new Permission("(O)pen", RoleType.OWNER, true, "O"));
        CONTACT_PERMISSIONS.add(new Permission("(O)pen", RoleType.FOREIGNER, true, "O"));

        CONTACT_PERMISSIONS.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        CONTACT_PERMISSIONS.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        CONTACT_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        CONTACT_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        REQUEST_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        REQUEST_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        REQUEST_PERMISSIONS.add(new Permission("(C)onfirm", RoleType.OWNER, true, "C"));
        REQUEST_PERMISSIONS.add(new Permission("(C)onfirm", RoleType.FOREIGNER, true, "C"));

        REQUEST_PERMISSIONS.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        REQUEST_PERMISSIONS.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        REQUEST_PERMISSIONS.add(new Permission("(R)eject", RoleType.OWNER, true, "R"));
        REQUEST_PERMISSIONS.add(new Permission("(R)eject", RoleType.FOREIGNER, true, "R"));

        REQUEST_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        REQUEST_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(A)dd", RoleType.OWNER, true, "A"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(A)dd", RoleType.FOREIGNER, true, "A"));

        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(F)inish", RoleType.OWNER, true, "F"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(F)inish", RoleType.FOREIGNER, true, "F"));

        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(S)how", RoleType.OWNER, true, "S"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(S)how", RoleType.FOREIGNER, true, "S"));

        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(R)emove", RoleType.OWNER, true, "R"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(R)emove", RoleType.FOREIGNER, true, "R"));

        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        ADD_GROUP_MEMBER_PERMISSION.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        FOLLOWERS_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        FOLLOWERS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.OWNER, true, "O"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.FOREIGNER, true, "O"));

        FOLLOWERS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.OWNER, true, "Q"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.FOREIGNER, true, "Q"));

        FOLLOWERS_PERMISSIONS.add(new Permission("(F)ollowBack", RoleType.OWNER, true, "F"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(F)ollowBack", RoleType.FOREIGNER, true, "F"));

        FOLLOWERS_PERMISSIONS.add(new Permission("(B)lock", RoleType.OWNER, true, "B"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(B)lock", RoleType.FOREIGNER, true, "B"));

        FOLLOWERS_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        FOLLOWERS_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        FOLLOWINGS_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        FOLLOWINGS_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        FOLLOWINGS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.OWNER, true, "O"));
        FOLLOWINGS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.FOREIGNER, true, "O"));

        FOLLOWINGS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.OWNER, true, "Q"));
        FOLLOWINGS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.FOREIGNER, true, "Q"));

        FOLLOWINGS_PERMISSIONS.add(new Permission("(U)nfollow", RoleType.OWNER, true, "U"));
        FOLLOWINGS_PERMISSIONS.add(new Permission("(U)nfollow", RoleType.FOREIGNER, true, "U"));

        FOLLOWINGS_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        FOLLOWINGS_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));



        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(S)end", RoleType.OWNER, true, "S"));
        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(S)end", RoleType.FOREIGNER, true, "S"));

        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(C)ancel", RoleType.OWNER, true, "C"));
        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(C)ancel", RoleType.FOREIGNER, true, "C"));

        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        FORWARD_MESSAGE_TO_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("1-Contact", RoleType.OWNER, true, "1"));
        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("1-Contact", RoleType.FOREIGNER, true, "1"));

        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("2-Group", RoleType.OWNER, true, "2"));
        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("2-Group", RoleType.FOREIGNER, true, "2"));

        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("0-back", RoleType.OWNER, true, "0"));
        FORWARD_CONTACT_OR_GROUP_PERMISSIONS.add(new Permission("0-back", RoleType.FOREIGNER, true, "0"));


        GROUPS_PERMISSIONS.add(new Permission("1- GroupList", RoleType.OWNER, true, "1"));
        GROUPS_PERMISSIONS.add(new Permission("1- GroupList", RoleType.FOREIGNER, true, "1"));

        GROUPS_PERMISSIONS.add(new Permission("2- Create Group", RoleType.OWNER, true, "2"));
        GROUPS_PERMISSIONS.add(new Permission("2- Create Group", RoleType.FOREIGNER, true, "2"));

        GROUPS_PERMISSIONS.add(new Permission("0- Back", RoleType.OWNER, true, "0"));
        GROUPS_PERMISSIONS.add(new Permission("0- Back", RoleType.FOREIGNER, true, "0"));



        MAIN_PERMISSIONS.add(new Permission("1- Home", RoleType.OWNER, true, "1"));
        MAIN_PERMISSIONS.add(new Permission("1- Home", RoleType.FOREIGNER, true, "1"));

        MAIN_PERMISSIONS.add(new Permission("2- Timeline", RoleType.OWNER, true, "2"));
        MAIN_PERMISSIONS.add(new Permission("2- Timeline", RoleType.FOREIGNER, true, "2"));

        MAIN_PERMISSIONS.add(new Permission("3- Explorer", RoleType.OWNER, true, "3"));
        MAIN_PERMISSIONS.add(new Permission("3- Explorer", RoleType.FOREIGNER, true, "3"));

        MAIN_PERMISSIONS.add(new Permission("4- Search", RoleType.OWNER, true, "4"));
        MAIN_PERMISSIONS.add(new Permission("4- Search", RoleType.FOREIGNER, true, "4"));

        MAIN_PERMISSIONS.add(new Permission("5- View Profile", RoleType.OWNER, true, "5"));
        MAIN_PERMISSIONS.add(new Permission("5- View Profile", RoleType.FOREIGNER, true, "5"));

        MAIN_PERMISSIONS.add(new Permission("6- Edit Profile", RoleType.OWNER, true, "6"));
        MAIN_PERMISSIONS.add(new Permission("6- Edit Profile", RoleType.FOREIGNER, true, "6"));

        MAIN_PERMISSIONS.add(new Permission("7- Change Account Type", RoleType.OWNER, true, "7"));
        MAIN_PERMISSIONS.add(new Permission("7- Change Account Type", RoleType.FOREIGNER, true, "7"));

        MAIN_PERMISSIONS.add(new Permission("8- Change Private Or Open Account Type", RoleType.OWNER, true, "8"));
        MAIN_PERMISSIONS.add(new Permission("8- Change Private Or Open Account Type", RoleType.FOREIGNER, true, "8"));

        MAIN_PERMISSIONS.add(new Permission("0- Logout", RoleType.OWNER, true, "0"));
        MAIN_PERMISSIONS.add(new Permission("0- Logout", RoleType.FOREIGNER, true, "0"));


        POSTING_PERMISSIONS.add(new Permission("1- Add New Post", RoleType.OWNER, true, "1"));
        POSTING_PERMISSIONS.add(new Permission("1- Add New Post", RoleType.FOREIGNER, true, "1"));

        POSTING_PERMISSIONS.add(new Permission("2- Delete post", RoleType.OWNER, true, "2"));
        POSTING_PERMISSIONS.add(new Permission("2- Delete post", RoleType.FOREIGNER, true, "2"));

        POSTING_PERMISSIONS.add(new Permission("3- Edit Post", RoleType.OWNER, true, "3"));
        POSTING_PERMISSIONS.add(new Permission("3- Edit Post", RoleType.FOREIGNER, true, "3"));

        POSTING_PERMISSIONS.add(new Permission("0- Back", RoleType.OWNER, true, "0"));
        POSTING_PERMISSIONS.add(new Permission("0- Back", RoleType.FOREIGNER, true, "0"));


        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(O)pen", RoleType.OWNER, true, "O"));
        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(O)pen", RoleType.FOREIGNER, true, "O"));

        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        SEARCH_USERNAME_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));


        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(O)pen", RoleType.OWNER, true, "O"));
        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(O)pen", RoleType.FOREIGNER, true, "O"));

        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(B)ack", RoleType.OWNER, true, "B"));
        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(B)ack", RoleType.FOREIGNER, true, "B"));

        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(D)elete", RoleType.FOREIGNER, true, "D"));
        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(D)elete", RoleType.OWNER, true, "D"));

        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        SEARCHED_ACCOUNTS_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));



        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(P)erior", RoleType.OWNER, true, "P"));
        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(P)erior", RoleType.FOREIGNER, true, "P"));

        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.OWNER, true, "O"));
        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(O)penAccount", RoleType.FOREIGNER, true, "O"));

        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.OWNER, true, "Q"));
        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(Q)uit", RoleType.FOREIGNER, true, "Q"));

        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(F)ollow", RoleType.OWNER, true, "F"));
        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(F)ollow", RoleType.FOREIGNER, true, "F"));

        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(N)ext", RoleType.OWNER, true, "N"));
        RECOMMEND_ACCOUNTS_PERMISSIONS.add(new Permission("(N)ext", RoleType.FOREIGNER, true, "N"));

    }
}
