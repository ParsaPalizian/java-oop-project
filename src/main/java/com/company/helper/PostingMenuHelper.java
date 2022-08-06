package com.company.helper;

import com.company.Result;
import com.company.enums.CommandColors;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Post;
import com.company.ui.PostUI;
import com.company.utility.PrintUtility;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLException;

public class PostingMenuHelper {
    public static void printPosting() {
        System.out.println("POSTING MENU");
        PrintUtility.printlnCommands(PrintUtility.createPostingMenu(RoleType.OWNER));
    }

    public static void performPostingCommand(String command) throws SQLException {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1: {
                    String Media = PostUI.createMediaForm(Main.scanner, null, true);
                    String content = PostUI.createContentForm(Main.scanner, null, true);

                    Post post = new Post();
                    post.setAccount(Globals.currentAccount);

                    File file = new File(Media);
                    if (file.exists()) {
                        String dest = "uploads\\posts\\";
                        String[] prts = file.getName().split("\\.");
                        String ext = prts[prts.length - 1];
                        dest += Globals.currentAccount.getId() + "_" + System.currentTimeMillis() + "." + ext;
                        post.setMedia(dest);
                        Files.copy(new File(Media).toPath(), new File(dest).toPath());
                    }

                    post.setContent(content);
                    Globals.currentPost = post;
                    Result<Post> result = Post.sendPost(post);
                    if (!result.isError()) {
                        Globals.currentAccount.getPosts().add(result.getData());
                        System.out.println(CommandColors.ANSI_BLUE + "Post Successful");
                        System.out.print(CommandColors.ANSI_RESET);
                        Globals.currentPost = null;
                    } else {
                        PrintUtility.printlnFail("Error Raised");
                        System.out.print(CommandColors.ANSI_RESET);
                    }
                    break;
                }
                case 2: {
                    for (Post post : Globals.currentAccount.getPosts()) {
                        System.out.println(CommandColors.ANSI_PURPLE + post.getId() + "_" + post.getContent());
                        System.out.print(CommandColors.ANSI_RESET);
                    }
                    System.out.println("Enter Post Id :");
                    int postId = Integer.parseInt(Main.scanner.nextLine().trim());

                    Result<Post> result = Post.deletePost(postId);
                    if (!result.isError()) {
                        Post deletePost = new Post();
                        for (Post post : Globals.currentAccount.getPosts()) {
                            if (post.getId() == postId) {
                                deletePost = post;
                            }
                        }
                        Globals.currentPosts.remove(deletePost);
                        Globals.currentAccount.getPosts().remove(deletePost);
                        System.out.println(CommandColors.ANSI_BLUE + "Delete Successful");
                        System.out.print(CommandColors.ANSI_RESET);
                    } else {
                        PrintUtility.printlnFail("Error Raised");
                    }

                    break;
                }
                case 3: {
                    for (Post post : Globals.currentAccount.getPosts()) {
                        System.out.println(CommandColors.ANSI_PURPLE + post.getId() + "_" + post.getContent());
                        System.out.print(CommandColors.ANSI_RESET);
                    }
                    System.out.println("Enter Post Id :");
                    int postId = Integer.parseInt(Main.scanner.nextLine().trim());
                    Post post = Globals.currentAccount.getPosts().get(Globals.currentAccount.getPosts().indexOf(
                            new Post(postId, null)));
                    String content = PostUI.createContentForm(Main.scanner, post.getContent(), false);

                    Result<Post> result = Post.editPost(postId, content);
                    post = result.getData();
                    if (!result.isError()) {
                        for (Post post1 : Globals.currentAccount.getPosts()) {
                            if (post1.getId() == post.getId()) {
                                post1.setContent(content);
                            }
                        }
                        System.out.println(CommandColors.ANSI_BLUE + "Edit Successful");
                        System.out.print(CommandColors.ANSI_RESET);
                    } else {
                        PrintUtility.printlnFail("Error Raised");
                    }

                    break;
                }
                case 0: {
                    Globals.menuLevels.pop();

                    break;
                }
            }
        } catch (Exception ex) {
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }

}
