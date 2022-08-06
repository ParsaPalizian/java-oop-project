package com.company.helper;

public class MenuHelper {


//    public static void printLogin() {
//        System.out.println("LOGIN MENU");
//        System.out.println("1- Login");
//        System.out.println("2- Sign up");
//        System.out.println("0- Exit");
//    }
//
//    public static void performLogInCommand(String command) throws SQLException, ParseException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//
//                while (true) {
//                    System.out.println("enter username :");
//                    String username = Main.scanner.nextLine();
//                    System.out.println("enter password :");
//                    String password = Main.scanner.nextLine();
//                    Result result = Account.login(username, password);
//                    if (result.isError()) {
//                        System.out.println("jngbgfscdxa");
//                        for (String alert : result.getAlerts()) {
//                            System.out.println(alert);
//                        }
//                    } else {
//
//                        level = MenuLevel.MAIN;
//                        break;
//                    }
//                }
//                break;
//            }
//            case 2: {
//                String firstName = AccountUI.createFirstNameForm(Main.scanner, null, true);
//
//                String lastName = AccountUI.createLastNameForm(Main.scanner, null, true);
//
//                String username = AccountUI.createUsernameForm(Main.scanner, null, true);
//
//                String password = AccountUI.createPasswordForm(Main.scanner, null, true);
//
//                String email = AccountUI.createEmailForm(Main.scanner, null, true);
//                Result result = Account.signUp(firstName, lastName, username, password, email);
//
//                System.out.println(CommandColors.ANSI_BLUE + "REGISTER SUCCESSFUL");
//                System.out.print(CommandColors.ANSI_RESET);
//
//                level = MenuLevel.LOGIN;
//
//                break;
//            }
//            case 0: {
//
//                System.exit(0);
//                break;
//            }
//        }
//    }

//    public static void printGroups() {
//        System.out.println("Groups MENU");
//        System.out.println("1- GroupList");
//        System.out.println("2- Create Group");
//        System.out.println("0- Back");
//    }
//
//    public static void performGroupsCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                level = MenuLevel.GROUP_LIST;
//                break;
//            }
//            case 2: {
//                System.out.println("Enter GroupName :");
//                String groupName = Main.scanner.nextLine();
//
//                System.out.println("Enter groupBio :");
//                String groupBio = Main.scanner.nextLine();
//
//                System.out.println("Enter GroupProfilePictureAddress :");
//                String groupProfilePictureAddress = Main.scanner.nextLine();
//
//                System.out.println("Enter groupLink :");
//                String groupLink = Main.scanner.nextLine();
//                Group.create(groupName, groupBio, groupProfilePictureAddress, groupLink);
//
//
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printGroupsList() {
//        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getName());
//        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getBio());
//        PrintUtility.printlnCommands("(P)erior---(M)ember---(C)ontent---(B)ack---(L)eave---(D)elete---(N)ext");
//
//    }
//
//    public static void performGroupListCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentGroupIndex == 0) {
//                    System.out.println("You Are On First Group");
//                    printGroupsList();
//                    performGroupListCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentGroupIndex--;
//                    printGroupsList();
//                    performGroupListCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "M":
//                level = MenuLevel.MEMBER;
//                break;
//
//            case "C":
//                level= MenuLevel.GROUP_CONTENT;
//                break;
//
//            case "B":
//                Globals.currentPostIndex = 0;
//                level = MenuLevel.GROUPS;
//                break;
//
//            case "D":
//                break;
//
//            case "L":
//                break;
//
//            case "N":
//                if (Globals.currentGroupIndex == Globals.currentAccount.getGroups().size() - 1) {
//                    System.out.println("You Reached To Last Groups");
//                    printGroupsList();
//                    performGroupListCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentGroupIndex++;
//                    printGroupsList();
//                    performGroupListCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printGroupContent() {
//        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().get(Globals.currentGroupContentIndex).getSender().getUserName()+" :");
//        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().get(Globals.currentGroupContentIndex).getContent());
//        PrintUtility.printlnCommands("(P)erior---Rep(l)y---(R)eact---(F)orward---(B)ack---(D)elete---(E)dit---(N)ext");
//
//    }
//
//    public static void performGroupContentCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentGroupContentIndex == 0) {
//                    System.out.println("You Are On First GroupContent");
//                    printGroupContent();
//                    performGroupContentCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentGroupContentIndex--;
//                    printGroupContent();
//                    performGroupContentCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "L":
//                break;
//
//            case "R":
//                break;
//
//            case "F":
//
//                break;
//
//            case "B":
//                Globals.currentGroupContentIndex=0;
//                level= MenuLevel.GROUP_LIST;
//                break;
//
//            case "D":
//                Account.deleteGroupContent(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().get(Globals.currentGroupContentIndex));
//                break;
//
//
//            case "E":
//                break;
//
//
//
//            case "N":
//                if (Globals.currentGroupContentIndex == Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().size() - 1) {
//                    System.out.println("You Reached To Last GroupContent");
//                    printGroupContent();
//                    performGroupContentCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentGroupContentIndex++;
//                    printGroupContent();
//                    performGroupContentCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printMember() {
//        System.out.println(Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().get(Globals.currentMemberIndex).getMember().getUserName());
//        PrintUtility.printlnCommands("(P)erior---(K)ick---(B)ack---(O)pen---(N)ext");
//
//    }
//
//    public static void performMemberCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentMemberIndex==0) {
//                    System.out.println("You Are On First Member");
//                    printMember();
//                    performMemberCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentMemberIndex--;
//                    printMember();
//                    performMemberCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "K":
//
//                break;
//
//            case "B":
//                level=MenuLevel.GROUP_LIST;
//                break;
//
//            case "O":
//                break;
//
//            case "N":
//                if (Globals.currentMemberIndex == Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().size() - 1) {
//                    System.out.println("You Reached To Last Member");
//                    printMember();
//                    performMemberCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentMemberIndex++;
//                    printMember();
//                    performMemberCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printMain() {
//        System.out.println("MAIN MENU");
//        System.out.println("1- Home");
//        System.out.println("2- Timeline");
//        System.out.println("3- Explorer");
//        System.out.println("4- Search");
//        System.out.println("5- View Profile");
//        System.out.println("6- Edit Profile");
//        System.out.println("0- Logout");
//    }
//
//    public static void performMainCommand(String command) throws SQLException, ParseException {
//
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//
//            case 1:
//                level = MenuLevel.HOME;
//                break;
//
//            case 2:
//                level = MenuLevel.TIMELINE;
//                break;
//
//            case 3:
//                level = MenuLevel.EXPLORER;
//                break;
//
//            case 4:
//                level = MenuLevel.SEARCH;
//                break;
//
//            case 5:
//                System.out.println(CommandColors.ANSI_YELLOW + "UserName : " + CommandColors.ANSI_CYAN + Globals.currentAccount.getUserName());
//                System.out.println(CommandColors.ANSI_YELLOW + "First Name : " + Globals.currentAccount.getFirstName());
//                System.out.println(CommandColors.ANSI_YELLOW + "Last Name : " + Globals.currentAccount.getLastName());
//                System.out.println(CommandColors.ANSI_YELLOW + "PhoneNumber : " + Globals.currentAccount.getPhoneNumber());
//                System.out.println(CommandColors.ANSI_YELLOW + "Email : " + Globals.currentAccount.getEmail());
//                System.out.println(CommandColors.ANSI_YELLOW + "Location : " + Globals.currentAccount.getLocation());
//                System.out.println(CommandColors.ANSI_YELLOW + "Birthday : " + Globals.currentAccount.getBirthday());
//                System.out.println(CommandColors.ANSI_YELLOW + "Bio : " + Globals.currentAccount.getBio());
//                System.out.print(CommandColors.ANSI_RESET);
//                break;
//
//            case 6:
//                String username = AccountUI.createUsernameForm(Main.scanner, Globals.currentAccount.getUserName(), false);
//                String password = AccountUI.createPasswordForm(Main.scanner, Globals.currentAccount.getPassword(), false);
//                String firstName = AccountUI.createFirstNameForm(Main.scanner, Globals.currentAccount.getFirstName(), false);
//                String lastName = AccountUI.createLastNameForm(Main.scanner, Globals.currentAccount.getLastName(), false);
//                ;
//                String phoneNumber = AccountUI.createPhoneNumberForm(Main.scanner, Globals.currentAccount.getPhoneNumber(), false);
//                ;
//                String email = AccountUI.createEmailForm(Main.scanner, Globals.currentAccount.getEmail(), false);
//                String location = AccountUI.createLocationForm(Main.scanner, Globals.currentAccount.getLocation(), false);
//                LocalDate birthday = AccountUI.createBirthdayForm(Main.scanner, Globals.currentAccount.getBirthday(), false);
//                String bio = AccountUI.createBioForm(Main.scanner, Globals.currentAccount.getBio(), false);
//                Result result = Account.editProfile(Globals.currentAccount);
//
//                System.out.println(CommandColors.ANSI_BLUE + "Edit SUCCESSFUL");
//                System.out.print(CommandColors.ANSI_RESET);
//            case 0:
//                level = MenuLevel.LOGIN;
//
//        }
//
//    }


//    public static void printHome() {
//        System.out.println("HOME MENU");
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
//        System.out.println("0- Back");
//    }
//
//    public static void performHomeCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level = MenuLevel.PROFILE;
//                break;
//
//            case 2:
//                level = MenuLevel.POSTING;
//                break;
//
//            case 3:
//                level = MenuLevel.FOLLOWERS;
//                break;
//
//            case 4:
//                level = MenuLevel.FOLLOWINGS;
//                break;
//
//            case 5:
//                level = MenuLevel.VIEW_POSTS;
//                break;
//
//            case 6:
//                level = MenuLevel.VIEW_IMAGES;
//                Temp.images = PostUtility.getImagePosts(Globals.currentAccount.getPosts());
//                break;
//
//            case 7:
//                level = MenuLevel.VIEW_VIDEOS;
//                Temp.videos = PostUtility.getVideosPosts(Globals.currentAccount.getPosts());
//                break;
//
//            case 8:
//                level = MenuLevel.VIEW_AUDIOS;
//                Temp.audios = PostUtility.getAudiosPosts(Globals.currentAccount.getPosts());
//                break;
//
//            case 9:
//                level = MenuLevel.VIEW_TEXTS;
//                Temp.texts = PostUtility.getTextPosts(Globals.currentAccount.getPosts());
//                break;
//
//            case 10:
//                level = MenuLevel.GROUPS;
//                break;
//
//
//            case 0:
//                level = MenuLevel.MAIN;
//                break;
//
//        }
//
//    }

//    public static void printProfile() {
//        System.out.println("Profile Menu");
//        System.out.println("1- View Profile Pictures");
//        System.out.println("2- Add  New Profile Picture");
//        System.out.println("0- Back");
//    }
//
//    public static void performProfileCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level=MenuLevel.VIEW_PROFILE_PICTURE;
//                break;
//
//            case 2:
//                System.out.println("Enter Your New Profile Picture Address :");
//                String address=Main.scanner.nextLine();
//                ProfilePicture profilePicture=new ProfilePicture();
//                profilePicture.setAddress(address);
//                Account.AddProfilePicture(profilePicture , Globals.currentAccount);
//                break;
//
//            case 3:
//                level = MenuLevel.HOME;
//                break;
//        }
//    }

//    public static void printViewProfilePictures() {
//
//        System.out.println(Globals.currentAccount.getProfilePictures().get(Globals.currentProfilePictureIndex).getAddress());
//
//        PrintUtility.printlnCommands("(P)erior---(Q)uit---(D)elet---(N)ext");
//    }
//
//    public static void performViewProfilePicturesCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentProfilePictureIndex = 0;
//                if (Globals.currentProfilePictureIndex == 0) {
//                    System.out.println("You Are On First Profile Picture");
//                    printViewProfilePictures();
//                    performViewProfilePicturesCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentProfilePictureIndex--;
//                    printViewProfilePictures();
//                    performViewProfilePicturesCommand(Main.scanner.nextLine());
//                }
//                break;
//
//
//            case "Q":
//                Globals.currentProfilePictureIndex =0;
//                level=MenuLevel.PROFILE;
//                break;
//
//            case "D":
//                Account.deleteProfilePicture(Globals.currentAccount.getProfilePictures().get(Globals.currentProfilePictureIndex));
//                break;
//
//
//            case "N":
//                if (Globals.currentProfilePictureIndex == Globals.currentAccount.getProfilePictures().size() - 1) {
//                    System.out.println("You Reached To Last Profile Picture");
//                    printViewProfilePictures();
//                    performViewProfilePicturesCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentProfilePictureIndex++;
//                    printViewProfilePictures();
//                    performViewProfilePicturesCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printViewPosts() {
//        System.out.println(Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getMedia());
//        System.out.println(Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getContent());
//        PrintUtility.printlnCommands("(P)erior---(R)eact---(C)omment---(v)iewComments---(Q)uit---(E)dit---(D)elet---(N)ext");
//    }
//
//    public static void performViewPostsCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentPostIndex == 0) {
//                    System.out.println("You Are On First Post");
//                    printViewPosts();
//                    performViewPostsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentPostIndex--;
//                    printViewPosts();
//                    performViewPostsCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
//                System.out.println("Enter Your Comment :");
//                String content = Main.scanner.nextLine();
//                Comment comment = new Comment();
//                comment.setSender(Globals.currentAccount);
//                comment.setContent(content);
//                Account.comment(Globals.currentAccount, Globals.currentAccount.getPosts().get(Globals.currentPostIndex), comment);
//                Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentPostIndex = 0;
//                level = MenuLevel.HOME;
//                break;
//
//            case "V":
//                level = MenuLevel.VIEW_COMMENTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentPostIndex == Globals.currentAccount.getPosts().size() - 1) {
//                    System.out.println("You Reached To Last Post");
//                    printViewPosts();
//                    performViewPostsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentPostIndex++;
//                    printViewPosts();
//                    performViewPostsCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printViewImages() {
//        System.out.println(Temp.images.get(Globals.currentImageIndex).getContent());
//        System.out.println(Temp.images.get(Globals.currentImageIndex).getMedia());
//        PrintUtility.printlnCommands("(P)erior---(R)eact---(C)omment---(v)iewComments---(Q)uit---(E)dit---(D)elet---(N)ext");
//    }
//
//    public static void performViewImagesCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentImageIndex == 0) {
//                    System.out.println("You Are On The First Image");
//                    printViewImages();
//                    performViewImagesCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentImageIndex--;
//                    printViewImages();
//                    performViewImagesCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
//                System.out.println("Enter Your Comment :");
//                String content = Main.scanner.nextLine();
//                Comment comment = new Comment();
//                comment.setSender(Globals.currentAccount);
//                comment.setContent(content);
//                Account.comment(Globals.currentAccount, Temp.images.get(Globals.currentImageIndex), comment);
//                Temp.images.get(Globals.currentImageIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentImageIndex = 0;
//                level = MenuLevel.HOME;
//                break;
//
//            case "V":
//                level = MenuLevel.VIEW_COMMENTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentImageIndex == Temp.images.size() - 1) {
//                    System.out.println("You Reached To Last Post");
//                    printViewImages();
//                    performViewImagesCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentImageIndex++;
//                    printViewImages();
//                    performViewImagesCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printViewVideos() {
//        System.out.println(Temp.videos.get(Globals.currentVideoIndex).getContent());
//        System.out.println(Temp.videos.get(Globals.currentVideoIndex).getMedia());
//        PrintUtility.printlnCommands("(P)erior---(R)eact---(C)omment---(v)iewComments---(Q)uit---(E)dit---(D)elet---(N)ext");
//    }
//
//    public static void performViewVideosCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentVideoIndex == 0) {
//                    System.out.println("You Are On The First Video");
//                    printViewVideos();
//                    performViewVideosCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentVideoIndex--;
//                    printViewVideos();
//                    performViewVideosCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
//                System.out.println("Enter Your Comment :");
//                String content = Main.scanner.nextLine();
//                Comment comment = new Comment();
//                comment.setSender(Globals.currentAccount);
//                comment.setContent(content);
//                Account.comment(Globals.currentAccount, Temp.videos.get(Globals.currentVideoIndex), comment);
//                Temp.videos.get(Globals.currentVideoIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentVideoIndex = 0;
//                level = MenuLevel.HOME;
//                break;
//
//            case "V":
//                level = MenuLevel.VIEW_COMMENTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentVideoIndex == Temp.videos.size() - 1) {
//                    System.out.println("You Reached To Last Video");
//                    printViewVideos();
//                    performViewVideosCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentVideoIndex++;
//                    printViewVideos();
//                    performViewVideosCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }
//
//    public static void printViewAudios() {
//        System.out.println(Temp.audios.get(Globals.currentAudioIndex).getContent());
//        System.out.println(Temp.audios.get(Globals.currentAudioIndex).getMedia());
//        PrintUtility.printlnCommands("(P)erior---(R)eact---(C)omment---(v)iewComments---(Q)uit---(E)dit---(D)elet---(N)ext");
//    }
//
//    public static void performViewAudiosCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentAudioIndex == 0) {
//                    System.out.println("You Are On The First Audio");
//                    printViewAudios();
//                    performViewAudiosCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentAudioIndex--;
//                    printViewAudios();
//                    performViewAudiosCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
//                System.out.println("Enter Your Comment :");
//                String content = Main.scanner.nextLine();
//                Comment comment = new Comment();
//                comment.setSender(Globals.currentAccount);
//                comment.setContent(content);
//                Account.comment(Globals.currentAccount, Temp.audios.get(Globals.currentAudioIndex), comment);
//                Temp.audios.get(Globals.currentAudioIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentAudioIndex = 0;
//                level = MenuLevel.HOME;
//                break;
//
//            case "V":
//                level = MenuLevel.VIEW_COMMENTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentAudioIndex == Temp.audios.size() - 1) {
//                    System.out.println("You Reached To Last Audio");
//                    printViewAudios();
//                    performViewAudiosCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentAudioIndex++;
//                    printViewAudios();
//                    performViewAudiosCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }
//
//
//
//
//    public static void printViewTexts() {
//        System.out.println(Temp.videos.get(Globals.currentTextIndex).getContent());
//        System.out.println(Temp.texts.get(Globals.currentTextIndex).getMedia());
//        PrintUtility.printlnCommands("(P)erior---(R)eact---(C)omment---(v)iewComments---(Q)uit---(E)dit---(D)elet---(N)ext");
//    }
//
//    public static void performViewTextsCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentTextIndex == 0) {
//                    System.out.println("You Are On The First Video");
//                    printViewTexts();
//                    performViewTextsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentTextIndex--;
//                    printViewTexts();
//                    performViewTextsCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
//                System.out.println("Enter Your Comment :");
//                String content = Main.scanner.nextLine();
//                Comment comment = new Comment();
//                comment.setSender(Globals.currentAccount);
//                comment.setContent(content);
//                Account.comment(Globals.currentAccount, Temp.texts.get(Globals.currentTextIndex), comment);
//                Temp.texts.get(Globals.currentTextIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentTextIndex = 0;
//                level = MenuLevel.HOME;
//                break;
//
//            case "V":
//                level = MenuLevel.VIEW_COMMENTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                Globals.currentCommentIndex = 0;
//                if (Globals.currentTextIndex == Temp.texts.size() - 1) {
//                    System.out.println("You Reached To Last Text");
//                    printViewTexts();
//                    performViewTextsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentTextIndex++;
//                    printViewTexts();
//                    performViewTextsCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }


//    public static void printViewComments() {
////        System.out.println(Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getMedia());
//        if (Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getComments().size() != 0) {
//            System.out.println(CommandColors.ANSI_PURPLE + Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getComments().get(Globals.currentCommentIndex).getContent());
//            System.out.println(CommandColors.ANSI_YELLOW + "(P)erior---(R)eact---(C)omment---(Q)uit---(E)dit---(D)elet---(N)ext" + CommandColors.ANSI_RESET);
//        } else {
//            System.out.println(CommandColors.ANSI_RED + "No Comment Found" + CommandColors.ANSI_RESET);
//            System.out.println(CommandColors.ANSI_YELLOW + "(Q)uit" + CommandColors.ANSI_RESET);
//        }
//
//    }
//
//    public static void performViewCommentsCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentCommentIndex == 0) {
//                    System.out.println("You Are On First Comment");
//                    printViewComments();
//                    performViewCommentsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentCommentIndex--;
//                    printViewComments();
//                    performViewCommentsCommand(Main.scanner.nextLine());
//                }
//                break;
//            case "R":
//                //todo react for post
////                System.out.println("Choose Your React :");
////                String react=Main.scanner.nextLine();
////                Reaction reaction =new Reaction();
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
//                break;
//
//            case "C":
////                System.out.println("Enter Your Comment :");
////                String content=Main.scanner.nextLine();
////                Comment comment=new Comment();
////                comment.setSender(Globals.currentAccount);
////                comment.setContent(content);
////                Account.comment(Globals.currentAccount,Globals.currentAccount.getPosts().get(Globals.currentPostIndex),comment);
////                Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getComments().add(comment);
//                break;
//
//            case "Q":
//                Globals.currentCommentIndex = 0;
//                level = MenuLevel.VIEW_POSTS;
//                break;
//
//            case "E":
//
//                break;
//
//            case "D":
//
//                break;
//
//            case "N":
//                if (Globals.currentCommentIndex == Globals.currentAccount.getPosts().get(Globals.currentPostIndex).getComments().size() - 1) {
//                    System.out.println("You Reached To Last Comment");
//                    printViewComments();
//                    performViewCommentsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentCommentIndex++;
//                    printViewComments();
//                    performViewCommentsCommand(Main.scanner.nextLine());
//                }
//                break;
//        }
//    }

//    public static void printTimeline() {
//        System.out.println("TIMELINE MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("4- Next");
//        System.out.println("5- Previous");
//        System.out.println("6- OpenAccount");
//        System.out.println("0- Back");
//    }
//
//    public static void performTimelineCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 4: {
//                //TODO NEXT;
//                break;
//            }
//            case 5: {
//                //TODO PREVIOUS;
//                break;
//            }
//            case 6: {
//                //TODO OPEN_ACCOUNT;
//                break;
//            }
//            case 0: {
//                level = MenuLevel.MAIN;
//                break;
//            }
//        }
//    }


//    public static void printExplorer() {
//        System.out.println("EXPLORER MENU");
//        System.out.println("1- Open Post");
//        System.out.println("0- Back");
//    }
//
//    public static void performExplorerCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level = MenuLevel.EXPLORER_POSTS;
//                break;
//            case 0:
//                level = MenuLevel.MAIN;
//                break;
//
//        }
//    }

//    public static void printSearch() {
//        System.out.println("SEARCH MENU");
//        System.out.println("1- Filter");
//        System.out.println("2- Username");
//        System.out.println("3- Clear");
//        System.out.println("0- Back");
//    }
//
//    public static void performSearchCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
////                level = MenuLevel.FILTER_ITEMS;
//                break;
//
//            case 2:
////                level = MenuLevel.ACCOUNTS;
//                break;
//
//            case 3:
//                //TODO CLEAR;
//                break;
//            case 0:
//                level = MenuLevel.MAIN;
//                break;
//
//        }
//    }

//    public static void printViewImages() {
//        System.out.println("VIEW_IMAGES MENU");
//        System.out.println("1- Next Image");
//        System.out.println("2- Previous Image");
//        System.out.println("0- Back");
//    }
//
//    public static void performViewImagesCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                //TODO NEXT_IMAGE
//                break;
//
//            case 2:
//                //TODO PREVIOUS_IMAGE
//                break;
//
//            case 0:
//                level = MenuLevel.HOME;
//                break;
//
//        }
//    }

//    public static void printPosting() {
//        System.out.println("POSTING MENU");
//        System.out.println("1- Add New Post");
//        System.out.println("2- Delete post");
//        System.out.println("3- Edit Post");
//        System.out.println("0- Back");
//    }
//
//    public static void performPostingCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                String Media = PostUI.createMediaForm(Main.scanner, null, true);
//                String content = PostUI.createContentForm(Main.scanner, null, true);
//
//                Post post = new Post();
//                post.setAccount(Globals.currentAccount);
//                post.setMedia(Media);
//                post.setContent(content);
//                Globals.currentPost = post;
//                Account.sendPost(post);
//                System.out.println(CommandColors.ANSI_BLUE + "Post Successful");
//                System.out.print(CommandColors.ANSI_RESET);
//                break;
//            }
//            case 2: {
//                for (Post post : Globals.currentAccount.getPosts()) {
//                    System.out.println(CommandColors.ANSI_PURPLE + post.getId() + "_" + post.getContent());
//                    System.out.print(CommandColors.ANSI_RESET);
//                }
//                System.out.println("Enter Post Id :");
//                int postId = Integer.parseInt(Main.scanner.nextLine().trim());
//                Account.deletePost(postId);
//                System.out.println(CommandColors.ANSI_BLUE + "Delete Successful");
//                System.out.print(CommandColors.ANSI_RESET);
//                break;
//            }
//            case 3: {
//                for (Post post : Globals.currentAccount.getPosts()) {
//                    System.out.println(CommandColors.ANSI_PURPLE + post.getId() + "_" + post.getContent());
//                    System.out.print(CommandColors.ANSI_RESET);
//                }
//                System.out.println("Enter Post Id :");
//                int postId = Integer.parseInt(Main.scanner.nextLine().trim());
//                Post post = Globals.currentAccount.getPosts().get(Globals.currentAccount.getPosts().indexOf(
//                        new Post(postId, null)));
//                String content = PostUI.createContentForm(Main.scanner, post.getContent(), false);
//                Account.editPost(postId, content);
//                System.out.println(CommandColors.ANSI_BLUE + "Edit Successful");
//                System.out.print(CommandColors.ANSI_RESET);
//
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printFollowers() {
//        System.out.println(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount().getUserName());
//        PrintUtility.printlnCommands("(P)erior---(O)penAccount---(Q)uit---(F)ollowBack---(B)lock---(N)ext");
//    }
//
//    public static void performFollowersCommand(String command) throws SQLException {
//
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentFollowerIndex == 0) {
//                    System.out.println("You Are Watching Your First Followers");
//                    printFollowers();
//                    performFollowersCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentFollowerIndex--;
//                    printFollowers();
//                    performFollowersCommand(Main.scanner.nextLine());
//                }
//                break;
//
//            case "B":
//                //todo we should create blocklist
//                Account.block(Globals.currentAccount, Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex));
//                Globals.currentAccount.getFollowers().remove(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex));
//
//                break;
//            case "O":
//                break;
//
//            case "F":
//                boolean shouldBeFollow = false;
//                for (Follow follow : Globals.currentAccount.getFollowings()) {
//                    if (follow.getAccount().equals(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount())) {
//                        shouldBeFollow = true;
//                    }
//                }
//                if (shouldBeFollow) {
//                    Account.follow(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex));
//                }
//                break;
//
//
//            case "Q":
//                level = MenuLevel.HOME;
//                Globals.currentFollowerIndex = 0;
//                break;
//
//            case "N":
//                if (Globals.currentFollowerIndex == Globals.currentAccount.getFollowers().size() - 1) {
//                    System.out.println("You Are Watching Your Last Followers");
//                    printFollowers();
//                    performFollowersCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentFollowerIndex++;
//                    printFollowers();
//                    performFollowersCommand(Main.scanner.nextLine());
//                }
//                break;
//
//        }
//    }

//    public static void printFollowings() {
//        System.out.println(Globals.currentAccount.getFollowers().get(Globals.currentFollowerIndex).getAccount().getUserName());
//        PrintUtility.printlnCommands("(P)erior---(O)penAccount---(Q)uit---(U)nfollow---(N)ext");
//    }
//
//    public static void performFollowingsCommand(String command) throws SQLException {
//        switch (command.toUpperCase(Locale.ROOT)) {
//            case "P":
//                if (Globals.currentFollowingIndex == 0) {
//                    System.out.println("You Are Watching Your First Following");
//                    printFollowings();
//                    performFollowingsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentFollowingIndex--;
//                    printFollowings();
//                    performFollowingsCommand(Main.scanner.nextLine());
//                }
//                break;
//
//            case "U":
//
//
//                Account.unFollow(Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex));
//                Globals.currentAccount.getFollowings().remove(Globals.currentAccount.getFollowings().get(Globals.currentFollowingIndex));
//
//                break;
//            case "O":
//                break;
//
//
//            case "Q":
//                level = MenuLevel.HOME;
//                Globals.currentFollowingIndex = 0;
//                break;
//
//            case "N":
//                if (Globals.currentFollowingIndex == Globals.currentAccount.getFollowings().size() - 1) {
//                    System.out.println("You Are Watching Your Last Followings");
//                    printFollowings();
//                    performFollowingsCommand(Main.scanner.nextLine());
//                } else {
//                    Globals.currentFollowingIndex++;
//                    printFollowings();
//                    performFollowingsCommand(Main.scanner.nextLine());
//                }
//                break;
//
//        }
//    }

//    public static void printVideos() {
//        System.out.println("VIDEOS MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("0- Back");
//    }
//
//    public static void performVideoCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printImages() {
//        System.out.println("IMAGES MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("0- Back");
//    }
//
//    public static void performImageCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printAudio() {
//        System.out.println("AUDIOS MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("0- Back");
//    }
//
//    public static void performAudioCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printText() {
//        System.out.println("TEXTS MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("0- Back");
//    }
//
//    public static void performTextCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 0: {
//                level = MenuLevel.HOME;
//                break;
//            }
//        }
//    }

//    public static void printTimelineAccount() {
//        System.out.println("TIMELINE_ACCOUNT MENU");
//        System.out.println("1- Timeline Account Menu");
//        System.out.println("2- Followers");
//        System.out.println("3- Followings");
//        System.out.println("4- Videos");
//        System.out.println("5- Videos");
//        System.out.println("6- Audios");
//        System.out.println("7- Texts");
//        System.out.println("8- Call");
//        System.out.println("9- Email");
//        System.out.println("0- Back");
//    }

//    public static void printExplorerAccount() {
//        System.out.println("EXPLORER_ACCOUNT MENU");
//        System.out.println("1- Explorer Account Menu");
//        System.out.println("2- Followers");
//        System.out.println("3- Followings");
//        System.out.println("4- Images");
//        System.out.println("5- Videos");
//        System.out.println("6- Audios");
//        System.out.println("7- Texts");
//        System.out.println("0- Back");
//    }

//    public static void printSearchAccount() {
//        System.out.println("SEARCH_ACCOUNT MENU");
//        System.out.println("1- Search Account Menu");
//        System.out.println("2- Followers");
//        System.out.println("3- Followings");
//        System.out.println("4- Images");
//        System.out.println("5- Videos");
//        System.out.println("6- Audios");
//        System.out.println("7- Texts");
//        System.out.println("0- Back");
//    }

//    public static void performTimelineAccountCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level = MenuLevel.VIEW_IMAGES;
//                break;
//
//            case 2:
//                level = MenuLevel.FOLLOWERS;
//                break;
//
//            case 3:
//                level = MenuLevel.FOLLOWINGS;
//                break;
//
//            case 4:
//                level = MenuLevel.IMAGES;
//                break;
//
//            case 5:
//                level = MenuLevel.VIDEOS;
//                break;
//
//            case 6:
//                level = MenuLevel.AUDIOS;
//                break;
//
//            case 7:
//                level = MenuLevel.TEXT;
//                break;
//
//            case 8:
//                //TODO CALL
//                break;
//
//            case 9:
//                //TODO EMAIL
//                break;
//
//            case 0:
//                level = MenuLevel.SEARCH;
//                break;
//
//        }
//
//    }

//    public static void performExplorerAccountCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level = MenuLevel.VIEW_IMAGES;
//                break;
//
//            case 2:
//                level = MenuLevel.FOLLOWERS;
//                break;
//
//            case 3:
//                level = MenuLevel.FOLLOWINGS;
//                break;
//
//            case 4:
//                level = MenuLevel.IMAGES;
//                break;
//
//            case 5:
//                level = MenuLevel.VIDEOS;
//                break;
//
//            case 6:
//                level = MenuLevel.AUDIOS;
//                break;
//
//            case 7:
//                level = MenuLevel.TEXT;
//                break;
//
//            case 0:
//                level = MenuLevel.SEARCH;
//                break;
//
//        }
//
//    }

//    public static void performSearchAccountCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                level = MenuLevel.VIEW_IMAGES;
//                break;
//
//            case 2:
//                level = MenuLevel.FOLLOWERS;
//                break;
//
//            case 3:
//                level = MenuLevel.FOLLOWINGS;
//                break;
//
//            case 4:
//                level = MenuLevel.IMAGES;
//                break;
//
//            case 5:
//                level = MenuLevel.VIDEOS;
//                break;
//
//            case 6:
//                level = MenuLevel.AUDIOS;
//                break;
//
//            case 7:
//                level = MenuLevel.TEXT;
//                break;
//
//            case 0:
//                level = MenuLevel.SEARCH;
//                break;
//
//        }
//
//    }


//    public static void printAccounts() {
//        System.out.println("ACCOUNT MENU");
//        System.out.println("1- Open Search_Account");
//        System.out.println("0- Back");
//    }
//
//    public static void performAccountsCommand(String command) {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1:
//                //TODO LEVEL=???;
//                break;
//
//            case 0:
//                level = MenuLevel.SEARCH;
//                break;
//
//        }
//    }

//    public static void printExplorerPosts() {
//        System.out.println("EXPLORER_POSTS MENU");
//        System.out.println("1- React");
//        System.out.println("2- Comment");
//        System.out.println("3- Share");
//        System.out.println("4- Next");
//        System.out.println("5- Previous");
//        System.out.println("1- Open Account");
//        System.out.println("0- Back");
//    }
//
//    public static void performExplorerPostsCommand(String command) throws SQLException {
//        int intComm = Integer.parseInt(command);
//        switch (intComm) {
//            case 1: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("choose reactType");
//                System.out.println("1- ");
//                System.out.println("2- ");
//                System.out.println("3- ");
//                System.out.println("4- ");
//                System.out.println("5- ");
//                System.out.println("6- ");
//                System.out.println("7- ");
//                System.out.println("8- ");
//                System.out.println("9- ");
//                System.out.println("10- ");
//                String reactType = Main.scanner.nextLine();
//
//                Account.react(Globals.currentAccount, null, null);
//                break;
//            }
//            case 2: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter your comment :");
//                String postComment = Main.scanner.nextLine();
//
//                Globals.currentAccount.comment(Globals.currentAccount, null, null);
//                break;
//            }
//            case 3: {
//                System.out.println("enter postId :");
//                String postId = Main.scanner.nextLine();
//
//                System.out.println("enter receiversId");
//                ArrayList<Integer> receiversId = new ArrayList<>();
//                //todo getReceiversId
//
//                Account.share(Globals.currentAccount, null, null);
//                break;
//            }
//            case 4: {
//                //TODO NEXT;
//                break;
//            }
//            case 5: {
//                //TODO PREVIOUS;
//                break;
//            }
//            case 6: {
//                //TODO level=???
//                break;
//            }
//            case 0: {
//                level = MenuLevel.EXPLORER;
//                break;
//            }
//        }
//    }
}
