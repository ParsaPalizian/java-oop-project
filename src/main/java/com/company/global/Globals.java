package com.company.global;

import com.company.CustomArrayList;
import com.company.enums.MenuLevel;
import com.company.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Globals {


    public static final boolean DEBUG_MODE = true;

    public static Account currentAccount = null;
    public static Account loggedInAccount = null;
    public static Account forgetAccount = null;
    public static Account currentContact = null;
    public static CustomArrayList<Account> currentContacts = null;
    public static PrivateMessage currentForwardedPrivateMessage = null;
    public static GroupMessage currentForwardedGroupMessage = null;
    public static Post currentPost = null;

    public static CustomArrayList<Account> searchedAccounts = new CustomArrayList<>(Account::new);
    public static CustomArrayList<Account> historyAccounts = new CustomArrayList<>(Account::new);
    public static CustomArrayList<Account> recommendAccounts = new CustomArrayList<>(Account::new);


    public static int currentFollowerIndex = 0;
    public static int currentFollowingIndex = 0;
    public static int currentGroupIndex = 0;
    public static int currentMemberIndex = 0;
    public static int currentProfilePictureIndex = 0;
    public static int currentGroupContentIndex = 0;
    public static int currentContactIndex = 0;
    public static int currentForwardContactIndex = 0;
    public static int currentForwardGroupIndex = 0;
    public static int currentPrivateMessageIndex = 0;
    public static int currentGroupMessageIndex = 0;
    public static int currentAddGroupMemberAccountIndex = 0;
    public static int currentRecommendIndex = 0;
    public static int currentTimelineAccountIndex = 0;
    public static int currentTimelinePostIndex = 0;






    public static Stack<MenuLevel> menuLevels = new Stack<>(); //TODO FOR MENU LEVELS WE SHOULD USE IT TO COMEBACK TO BACK
    public static Stack<Account> usingAccounts = new Stack<>(); //TODO FOR MENU LEVELS WE SHOULD USE IT TO COMEBACK TO BACK

    public static CustomArrayList<PrivateMessage> currentPrivateMessages = new CustomArrayList<>(PrivateMessage::new);
    public static ArrayList<GroupMessage> currentGroupMessages = new ArrayList<>();
    public static CustomArrayList<Post> currentPosts = new CustomArrayList<>(Post::new);
    public static CustomArrayList<Comment> currentComments = new CustomArrayList<>(Comment::new);
    public static HashSet<Account> addGroupMemberList = new HashSet<>();

    public static Group groupToInsert = new Group();


}
