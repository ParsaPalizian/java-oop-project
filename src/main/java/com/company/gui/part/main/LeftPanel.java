package com.company.gui.part.main;

import com.company.global.Globals;
import com.company.gui.assets.widget.IconTextButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.utility.PostUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.TimerTask;

/**
 * Created by kami on 7/29/2022.
 */
public class LeftPanel extends JPanel {

    public static final int ICON_SIZE = 28;
    public static final int VERTICAL_GAP = 5;
    public static final int PANEL_WIDTH = 64;

    public boolean rendered = false;
    public boolean themeRendered = true;

    IconTextButton btnProfilePictures;
    IconTextButton btnAddPost;
    IconTextButton btnFollowers;
    IconTextButton btnFollowings;
    IconTextButton btnPosts;
    IconTextButton btnImages;
    IconTextButton btnVideos;
    IconTextButton btnAudios;
    IconTextButton btnTexts;
    IconTextButton btnGroups;
    IconTextButton btnMessages;
    IconTextButton btnBlocks;
    IconTextButton btnRequests;
    IconTextButton btnRecommends;

    IconTextButton btnSearch;
    IconTextButton btnViewSearchedHistory;
    IconTextButton btnClearSearch;


    public LeftPanel() {

        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, 0));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());

        btnProfilePictures = new IconTextButton(GuiSetting.selectedIconSet.home.profilePictures, "Profile", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnProfilePictures.setToolTipText("Profile Pictures");
        btnProfilePictures.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProfilePictures.setVisible(false);
        this.add(btnProfilePictures);

        btnProfilePictures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.VIEW_PROFILE_PICTURES;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });

        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));

        btnAddPost = new IconTextButton(GuiSetting.selectedIconSet.home.newPost, "New Post", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnAddPost.setToolTipText("Add New Post");
        btnAddPost.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddPost.setVisible(false);
        this.add(btnAddPost);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnAddPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.NEW_POST;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });


        btnFollowers = new IconTextButton(GuiSetting.selectedIconSet.home.followers, "Followers", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnFollowers.setToolTipText("FOLLOWERS");
        btnFollowers.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFollowers.setVisible(false);
        this.add(btnFollowers);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnFollowers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.FOLLOWERS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });

        btnFollowings = new IconTextButton(GuiSetting.selectedIconSet.home.followings, "Followings", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnFollowings.setToolTipText("FOLLOWINGS");
        btnFollowings.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFollowings.setVisible(false);
        this.add(btnFollowings);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnFollowings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.FOLLOWINGS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });

        btnPosts = new IconTextButton(GuiSetting.selectedIconSet.home.posts, "Posts", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnPosts.setToolTipText("POSTS");
        btnPosts.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPosts.setVisible(false);
        this.add(btnPosts);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnImages = new IconTextButton(GuiSetting.selectedIconSet.home.images, "Images", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnImages.setToolTipText("IMAGES");
        btnImages.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImages.setVisible(false);
        this.add(btnImages);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnImages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.IMAGE_PANEL;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
                Globals.currentPosts = PostUtility.getImagePosts(Globals.currentAccount.getPosts());
            }
        });

        btnVideos = new IconTextButton(GuiSetting.selectedIconSet.home.videos, "Videos", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnVideos.setToolTipText("VIDEOS");
        btnVideos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVideos.setVisible(false);
        this.add(btnVideos);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));

        btnAudios = new IconTextButton(GuiSetting.selectedIconSet.home.audios, "Audios", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnAudios.setToolTipText("AUDIOS");
        btnAudios.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAudios.setVisible(false);
        this.add(btnAudios);

        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnTexts = new IconTextButton(GuiSetting.selectedIconSet.home.texts, "Texts", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnTexts.setToolTipText("TEXTS");
        btnTexts.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTexts.setVisible(false);
        this.add(btnTexts);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));

        btnGroups = new IconTextButton(GuiSetting.selectedIconSet.home.groups, "Groups", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnGroups.setToolTipText("GROUPS");
        btnGroups.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGroups.setVisible(false);
        this.add(btnGroups);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.GROUPS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
                GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.GROUPS;
                GuiGlobals.mainFrame.topPanel.rendered = false;
            }
        });

        btnMessages = new IconTextButton(GuiSetting.selectedIconSet.home.messages, "Messages", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnMessages.setToolTipText("MESSAGES");
        btnMessages.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMessages.setVisible(false);
        this.add(btnMessages);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnMessages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.MESSAGES;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });


        btnBlocks = new IconTextButton(GuiSetting.selectedIconSet.home.blobks, "Block List", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnBlocks.setToolTipText("BLOCK LIST");
        btnBlocks.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBlocks.setVisible(false);
        this.add(btnBlocks);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnBlocks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.BLOCKLIST;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });

        btnRequests = new IconTextButton(GuiSetting.selectedIconSet.home.requests, "Requests", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnRequests.setToolTipText("REQUESTS");
        btnRequests.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRequests.setVisible(false);
        this.add(btnRequests);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.REQUESTS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });

        btnRecommends = new IconTextButton(GuiSetting.selectedIconSet.home.recommends, "Recommends", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnRecommends.setToolTipText("RECOMMENDS");
        btnRecommends.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRecommends.setVisible(false);
        this.add(btnRecommends);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));
        btnRecommends.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Globals.recommendAccounts = Globals.currentAccount.recommend(10).getData();
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.RECOMMENDS;
                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });


        btnSearch = new IconTextButton(GuiSetting.selectedIconSet.search.search, "Search", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnSearch.setToolTipText("SEARCH");
        btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearch.setVisible(false);
        this.add(btnSearch);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));


        btnViewSearchedHistory = new IconTextButton(GuiSetting.selectedIconSet.search.viewHistory, "History", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnViewSearchedHistory.setToolTipText("VIEW HISTORY");
        btnViewSearchedHistory.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewSearchedHistory.setVisible(false);
        this.add(btnViewSearchedHistory);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));


        btnClearSearch = new IconTextButton(GuiSetting.selectedIconSet.search.clear, "Clear", ICON_SIZE, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        btnClearSearch.setToolTipText("CLEAR");
        btnClearSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnClearSearch.setVisible(false);
        this.add(btnClearSearch);
        this.add(Box.createRigidArea(new Dimension(5, VERTICAL_GAP)));


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (rendered == false && GuiGlobals.mainFrame.bottomPanel.currentSituationMainMenu != null) {
                        switch (GuiGlobals.mainFrame.bottomPanel.currentSituationMainMenu) {
                            case NONE:
                                btnProfilePictures.setVisible(false);
                                btnAddPost.setVisible(false);
                                btnFollowers.setVisible(false);
                                btnFollowings.setVisible(false);
                                btnPosts.setVisible(false);
                                btnImages.setVisible(false);
                                btnVideos.setVisible(false);
                                btnAudios.setVisible(false);
                                btnTexts.setVisible(false);
                                btnGroups.setVisible(false);
                                btnMessages.setVisible(false);
                                btnBlocks.setVisible(false);
                                btnRequests.setVisible(false);
                                btnRecommends.setVisible(false);
                                btnSearch.setVisible(false);
                                btnViewSearchedHistory.setVisible(false);
                                btnClearSearch.setVisible(false);
                                break;
                            case HOME:

                                btnProfilePictures.setVisible(true);
                                btnAddPost.setVisible(true);
                                btnFollowers.setVisible(true);
                                btnFollowings.setVisible(true);
                                btnPosts.setVisible(true);
                                btnImages.setVisible(true);
                                btnVideos.setVisible(true);
                                btnAudios.setVisible(true);
                                btnTexts.setVisible(true);
                                btnGroups.setVisible(true);
                                btnMessages.setVisible(true);
                                btnBlocks.setVisible(true);
                                btnRequests.setVisible(true);
                                btnRecommends.setVisible(true);
                                btnViewSearchedHistory.setVisible(false);
                                btnClearSearch.setVisible(false);
                                break;
                            case TIMELINE:
                                break;
                            case EXPLORER:
                                break;
                            case SEARCH:
                                btnProfilePictures.setVisible(false);
                                btnAddPost.setVisible(false);
                                btnFollowers.setVisible(false);
                                btnFollowings.setVisible(false);
                                btnPosts.setVisible(false);
                                btnImages.setVisible(false);
                                btnVideos.setVisible(false);
                                btnAudios.setVisible(false);
                                btnTexts.setVisible(false);
                                btnGroups.setVisible(false);
                                btnMessages.setVisible(false);
                                btnBlocks.setVisible(false);
                                btnRequests.setVisible(false);
                                btnRecommends.setVisible(false);
                                btnSearch.setVisible(true);
                                btnViewSearchedHistory.setVisible(true);
                                btnClearSearch.setVisible(true);
                                break;
                            case SETTINGS:
                                btnProfilePictures.setVisible(false);
                                btnAddPost.setVisible(false);
                                btnFollowers.setVisible(false);
                                btnFollowings.setVisible(false);
                                btnPosts.setVisible(false);
                                btnImages.setVisible(false);
                                btnVideos.setVisible(false);
                                btnAudios.setVisible(false);
                                btnTexts.setVisible(false);
                                btnGroups.setVisible(false);
                                btnMessages.setVisible(false);
                                btnBlocks.setVisible(false);
                                btnRequests.setVisible(false);
                                btnRecommends.setVisible(false);
                                btnSearch.setVisible(false);
                                btnViewSearchedHistory.setVisible(false);
                                btnClearSearch.setVisible(false);
                                break;
                        }

                        rendered = true;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!themeRendered) {

                    LeftPanel.this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    btnProfilePictures.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnAddPost.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnFollowers.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnFollowings.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnPosts.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnImages.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnVideos.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnAudios.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnTexts.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnGroups.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnMessages.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnBlocks.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnRequests.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnRecommends.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnSearch.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnViewSearchedHistory.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnClearSearch.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());

                    themeRendered = true;

                }

            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100); //call the run() method at 1 second intervals

    }

}

