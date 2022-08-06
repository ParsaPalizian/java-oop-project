package com.company.launcher;

import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.helper.*;
import com.company.utility.PostUtility;

import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) throws Exception {


        Globals.menuLevels.add(MenuLevel.LOGIN);

        scanner = new Scanner(System.in);
        String command = "";
        while (true) {
            switch (Globals.menuLevels.get(Globals.menuLevels.size() - 1)) {
                case LOGIN:
                    LoginMenuHelper.printLogin();
                    command = scanner.nextLine();
                    LoginMenuHelper.performLogInCommand(command);
                    break;


                case VIEW_POSTS:
                    Globals.currentPosts = Globals.currentAccount.getPosts();
                    ViewPostsMenuHelper.printViewPosts();
                    command = scanner.nextLine();
                    ViewPostsMenuHelper.performViewPostsCommand(command);
                    break;


                case VIEW_IMAGES:
                    Globals.currentPosts = PostUtility.getImagePosts(Globals.currentAccount.getPosts());
                    ViewPostsMenuHelper.printViewPosts();
                    command = scanner.nextLine();
                    ViewPostsMenuHelper.performViewPostsCommand(command);
                    break;

                case VIEW_VIDEOS:
                    Globals.currentPosts = PostUtility.getVideosPosts(Globals.currentAccount.getPosts());
                    ViewPostsMenuHelper.printViewPosts();
                    command = scanner.nextLine();
                    ViewPostsMenuHelper.performViewPostsCommand(command);
                    break;


                case VIEW_AUDIOS:
                    Globals.currentPosts = PostUtility.getAudiosPosts(Globals.currentAccount.getPosts());
                    ViewPostsMenuHelper.printViewPosts();
                    command = scanner.nextLine();
                    ViewPostsMenuHelper.performViewPostsCommand(command);
                    break;

                case VIEW_TEXTS:
                    Globals.currentPosts = PostUtility.getTextPosts(Globals.currentAccount.getPosts());
                    ViewPostsMenuHelper.printViewPosts();
                    command = scanner.nextLine();
                    ViewPostsMenuHelper.performViewPostsCommand(command);
                    break;


                case VIEW_COMMENTS:
                    ViewCommentsMenuHelper.printViewComments();
                    command = scanner.nextLine();
                    ViewCommentsMenuHelper.performViewCommentsCommand(command);
                    break;


                case MAIN:
                    MainMenuHelper.printMain();
                    command = scanner.nextLine();
                    MainMenuHelper.performMainCommand(command);
                    break;


                case HOME:
                    HomeMenuHelper.printHome();
                    command = scanner.nextLine();
                    HomeMenuHelper.performHomeCommand(command);
                    break;


                case TIMELINE:
                    TimelineMenuHelper.printTimeline();
                    command = scanner.nextLine();
                    TimelineMenuHelper.performTimelineCommand(command);
                    break;


                case EXPLORER:
                    ExplorerMenuHelper.printExplorer();
                    command = scanner.nextLine();

                    ExplorerMenuHelper.performExplorerCommand(command);
                    break;


                case SEARCH:
                    SearchMenuHelper.printSearch();
                    command = scanner.nextLine();
                    SearchMenuHelper.performSearchCommand(command);
                    break;


                case GROUPS:
                    GroupsMenuHelper.printGroups();
                    command = scanner.nextLine();
                    GroupsMenuHelper.performGroupsCommand(command);
                    break;


                case GROUP_LIST:
                    GroupListMenuHelper.printGroupsList();
                    command = scanner.nextLine();
                    GroupListMenuHelper.performGroupListCommand(command);
                    break;


                case MEMBER:
                    MemberMenuHelper.printMember();
                    command = scanner.nextLine();
                    MemberMenuHelper.performMemberCommand(command);
                    break;


                case GROUP_CONTENT:
                    GroupMessageMenuHelper.printGroupContent();
                    command = scanner.nextLine();
                    GroupMessageMenuHelper.performGroupContentCommand(command);
                    break;


                case PROFILE:
                    ProfileMenuHelper.printProfile();
                    command = scanner.nextLine();
                    ProfileMenuHelper.performProfileCommand(command);
                    break;


                case VIEW_PROFILE_PICTURE:
                    ViewProfilePictureMenuHelper.printViewProfilePictures();
                    command = scanner.nextLine();
                    ViewProfilePictureMenuHelper.performViewProfilePicturesCommand(command);
                    break;



                case POSTING:
                    PostingMenuHelper.printPosting();
                    command = scanner.nextLine();
                    PostingMenuHelper.performPostingCommand(command);
                    break;


                case FOLLOWERS:
                    FollowersMenuHelper.printFollowers();
                    command = scanner.nextLine();
                    FollowersMenuHelper.performFollowersCommand(command);
                    break;


                case FOLLOWINGS:
                    FollowingMenuHelper.printFollowings();
                    command = scanner.nextLine();
                    FollowingMenuHelper.performFollowingsCommand(command);

                    break;
                case VIDEOS:
                    VideosMenuHelper.printVideos();
                    command = scanner.nextLine();
                    VideosMenuHelper.performVideoCommand(command);
                    break;

                case IMAGES:
                    ImagesMenuHelper.printImages();
                    command = scanner.nextLine();
                    ImagesMenuHelper.performImageCommand(command);
                    break;

                case AUDIOS:
                    AudiosMenuHelper.printAudio();
                    command = scanner.nextLine();
                    AudiosMenuHelper.performAudioCommand(command);

                    break;
                case TEXT:
                    TextMenuHelper.printText();
                    command = scanner.nextLine();
                    TextMenuHelper.performTextCommand(command);
                    break;

                case MESSAGES:
                    ContactMenuHelper.printContacts();
                    command = scanner.nextLine();
                    ContactMenuHelper.performContactsCommand(command);
                    break;

                case PRIVATE_MESSAGE:
                    PrivateMessageMenuHelper.printMessages();
                    command = scanner.nextLine();
                    PrivateMessageMenuHelper.performMessagesCommand(command);
                    break;

                case FORWARD_CONTACT_OR_GROUP:
                    ForwardContactOrGroupMenuHelper.printForwardContactOrGroup();
                    command = scanner.nextLine();
                    ForwardContactOrGroupMenuHelper.performForwardContactOrGroupCommand(command);
                    break;

                case FORWARD_TO_CONTACT:
                    if (Globals.currentForwardedPrivateMessage != null) {
                        ForwardPrivateMessageToContactMenuHelper.printForwardToContacts();
                        command = scanner.nextLine();
                        ForwardPrivateMessageToContactMenuHelper.performForwardToContactsCommand(command);
                    } else if (Globals.currentForwardedGroupMessage != null) {
                        ForwardGroupMessageToContactMenuHelper.printForwardToContacts();
                        command = scanner.nextLine();
                        ForwardGroupMessageToContactMenuHelper.performForwardToContactsCommand(command);
                    }
                    break;

                case FORWARD_TO_GROUP:

                    if (Globals.currentForwardedPrivateMessage != null) {
                        ForwardPrivateMessageToGroupMenuHelper.printForwardToGroup();
                        command = scanner.nextLine();
                        ForwardPrivateMessageToGroupMenuHelper.performForwardToGroupCommand(command);
                    } else if (Globals.currentForwardedGroupMessage != null) {
                        ForwardGroupMessageToGroupMenuHelper.printForwardToGroup();
                        command = scanner.nextLine();
                        ForwardGroupMessageToGroupMenuHelper.performForwardToGroupCommand(command);
                    }
                    break;

                case BLOCKLIST:
                    BlocklistMenuHelper.printBlocklist();
                    command = scanner.nextLine();
                    BlocklistMenuHelper.performBlocklistCommand(command);
                    break;

                case ADD_GROUP_MEMBER:
                    AddGroupMemberMenuHelper.printAddGroupMember();
                    command = scanner.nextLine();
                    AddGroupMemberMenuHelper.performAddGroupMemberCommand(command);
                    break;

                case TIMELINE_ACCOUNT:
                    TimelineAccountMenuHelper.printTimelineAccount();
                    command = scanner.nextLine();
                    TimelineMenuHelper.performTimelineCommand(command);
                    break;

                case POST_REACT:
                    PostReactMenuHelper.printReact();
                    command = scanner.nextLine();
                    PostReactMenuHelper.performReactCommand(command);
                    break;

                case COMMENT_REACT:
                    CommentReactMenuHelper.printReact();
                    command = scanner.nextLine();
                    CommentReactMenuHelper.performReactCommand(command);
                    break;

                case PRIVATE_MESSAGE_REACT:
                    PrivateMessageReactMenuHelper.printReact();
                    command = scanner.nextLine();
                    PrivateMessageReactMenuHelper.performReactCommand(command);
                    break;

                case GROUP_MESSAGE_REACT:
                    GroupMessageReactMenuHelper.printReact();
                    command = scanner.nextLine();
                    GroupMessageReactMenuHelper.performReactCommand(command);
                    break;

                case EXPLORER_ACCOUNT:
                    ExplorerAccountMenuHelper.printExplorerAccount();
                    command = scanner.nextLine();
                    ExplorerMenuHelper.performExplorerCommand(command);
                    break;


                case SEARCH_ACCOUNT:
                    SearchAccountMenuHelper.printSearchAccount();
                    command = scanner.nextLine();
                    SearchMenuHelper.performSearchCommand(command);
                    break;


                case EXPLORER_POSTS:
                    ExplorerPostsMenuHelper.printExplorerPosts();
                    command = scanner.nextLine();
                    ExplorerPostsMenuHelper.performExplorerPostsCommand(command);
                    break;



                case SHARE:
                    ShareMenuHelper.printShare();
                    command = scanner.nextLine();
                    ShareMenuHelper.performShareCommand(command);
                    break;

                case SEARCH_USERNAME:
                    SearchUsernameMenuHelper.printSearchUsername();
                    command = scanner.nextLine();
                    SearchUsernameMenuHelper.performSearchUsernameCommand(command);
                    break;

                case HISTORY_ACCOUNTS:
                    SearchHistoryMenuHelper.printSearchHistory();
                    command = scanner.nextLine();
                    SearchHistoryMenuHelper.performSearchHistoryCommand(command);
                    break;

                case REQUEST_LIST:
                    RequestListMenuHelper.printRequestList();
                    command = scanner.nextLine();
                    RequestListMenuHelper.performRequestListCommand(command);

                case RECOMMEND:
                    RecommendMenuHelper.printRecommend();;
                    command = scanner.nextLine();
                    RecommendMenuHelper.performRecommendCommand(command);
            }
        }

    }


}
