package com.company.gui.part.main;

import com.company.global.Globals;
import com.company.gui.assets.widget.BasePanel;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.*;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * Created by kami on 7/29/2022.
 */
public class CenterPanel extends JPanel {

    public static final int ICON_SIZE = 28;
    public static final int VERTICAL_GAP = 5;
    public static final int PANEL_WIDTH = 64;
    public CenterMenuSituation currentSituationCenterPanel = CenterMenuSituation.NONE;

    public boolean rendered = false;
    public boolean themeRendered = true;

    public CenterPanel() {

        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(PANEL_WIDTH, 0));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (rendered == false) {
                        switch (currentSituationCenterPanel) {
                            case NONE:
                                CenterPanel.this.removeAll();
                                EmptyPanel emptyPanel = new EmptyPanel();
                                CenterPanel.this.add(emptyPanel);
                                GuiGlobals.mainFrame.activeCenterPanel = emptyPanel;
                                CenterPanel.this.revalidate();
                                break;
                            case BLOCKLIST:
                                CenterPanel.this.removeAll();
                                BlockListPanel blockListPanel = new BlockListPanel();
                                CenterPanel.this.add(blockListPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case CHOOSE_GROUP_MEMBER:
                                CenterPanel.this.removeAll();
                                ChooseGroupMemberPanel chooseGroupMemberPanel = new ChooseGroupMemberPanel();
                                CenterPanel.this.add(chooseGroupMemberPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case MESSAGES:
                                CenterPanel.this.removeAll();
                                MessagePanel messagePanel = new MessagePanel();
                                GuiGlobals.mainFrame.activeCenterPanel = messagePanel;
                                CenterPanel.this.add(messagePanel);
                                CenterPanel.this.revalidate();
                                break;
                            case CONTENT:
                                CenterPanel.this.removeAll();
                                ContentPanel contentPanel = new ContentPanel();
                                CenterPanel.this.add(contentPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case CREATE_GROUP:
                                CenterPanel.this.removeAll();
                                CreateGroupPanel createGroupPanel = new CreateGroupPanel();
                                CenterPanel.this.add(createGroupPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case EXPLORER:
                                CenterPanel.this.removeAll();
                                ExplorerPanel explorerPanel = new ExplorerPanel();
                                CenterPanel.this.add(explorerPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case EXPLORER_POST:
                                CenterPanel.this.removeAll();
                                ExplorerPostPanel explorerPostPanel = new ExplorerPostPanel();
                                CenterPanel.this.add(explorerPostPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case FOLLOWERS:
                                CenterPanel.this.removeAll();
                                FollowersPanel followersPanel = new FollowersPanel();
                                CenterPanel.this.add(followersPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case FOLLOWINGS:
                                CenterPanel.this.removeAll();
                                FollowingsPanel followingsPanel = new FollowingsPanel();
                                CenterPanel.this.add(followingsPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case FORWARD_TO_CONTACT_OR_GROUP:
                                CenterPanel.this.removeAll();
                                ForwardToContactOrGroupPanel forwardToContactOrGroupPanel = new ForwardToContactOrGroupPanel();
                                CenterPanel.this.add(forwardToContactOrGroupPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case GROUP_LIST:
                                CenterPanel.this.removeAll();
                                GroupListPanel groupListPanel = new GroupListPanel();
                                CenterPanel.this.add(groupListPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case GROUP_MEMBERS:
                                CenterPanel.this.removeAll();
                                GroupMembersPanel groupMembersPanel = new GroupMembersPanel();
                                CenterPanel.this.add(groupMembersPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case GROUP:
                                CenterPanel.this.removeAll();
                                GroupsPanel groupPanel = new GroupsPanel();
                                GuiGlobals.mainFrame.activeCenterPanel = groupPanel;
                                CenterPanel.this.add(groupPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case GROUPS:
                                CenterPanel.this.removeAll();
                                GroupsPanel groupsPanel = new GroupsPanel();
                                GuiGlobals.mainFrame.activeCenterPanel = groupsPanel;
                                CenterPanel.this.add(groupsPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case HOME:
                                CenterPanel.this.removeAll();
                                HomePanel homePanel = new HomePanel(Globals.currentAccount);
                                CenterPanel.this.add(homePanel);
                                CenterPanel.this.revalidate();
                                break;
                            case LOGIN:
                                CenterPanel.this.removeAll();
                                LoginPanel loginPanel = new LoginPanel();
                                CenterPanel.this.add(loginPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case MAIN:
                                CenterPanel.this.removeAll();
                                MainPanel mainPanel = new MainPanel();
                                CenterPanel.this.add(mainPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case POSTING:
                                CenterPanel.this.removeAll();
                                PostingPanel postingPanel = new PostingPanel();
                                CenterPanel.this.add(postingPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case POST:
                                CenterPanel.this.removeAll();
                                PostPanel postPanel = new PostPanel();
                                CenterPanel.this.add(postPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case PRIME_PAGE:
                                CenterPanel.this.removeAll();
                                PrimePagePanel primePagePanel = new PrimePagePanel();
                                CenterPanel.this.add(primePagePanel);
                                CenterPanel.this.revalidate();
                                break;
                            case SEARCH_HISTORY:
                                CenterPanel.this.removeAll();
                                SearchHistoryPanel searchHistoryPanel = new SearchHistoryPanel();
                                CenterPanel.this.add(searchHistoryPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case SEARCH_ACCOUNTS:
                                CenterPanel.this.removeAll();
                                SearchAccountsPanel searchAccountsPanel = new SearchAccountsPanel();
                                CenterPanel.this.add(searchAccountsPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case SEARCH:
                                CenterPanel.this.removeAll();
                                SearchPanel searchPanel = new SearchPanel();
                                CenterPanel.this.add(searchPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case SIGNUP:
                                CenterPanel.this.removeAll();
                                SignupPanel signupPanel = new SignupPanel();
                                CenterPanel.this.add(signupPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case TIMELINE:
                                CenterPanel.this.removeAll();
                                TimelinePanel TimelinePanel = new TimelinePanel();
                                CenterPanel.this.add(TimelinePanel);
                                CenterPanel.this.revalidate();
                                break;
                            case VIEW_COMMENT:
                                CenterPanel.this.removeAll();
                                ViewCommentPanel viewCommentPanel = new ViewCommentPanel();
                                CenterPanel.this.add(viewCommentPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case VIEW_IMAGE:
                                CenterPanel.this.removeAll();
                                ViewImagesPanel viewImagesPanel = new ViewImagesPanel();
                                CenterPanel.this.add(viewImagesPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case VIEW_PROFILE_PICTURES:
                                CenterPanel.this.removeAll();
                                ViewProfilePicturesPanel viewProfilePicturesPanel = new ViewProfilePicturesPanel();
                                CenterPanel.this.add(viewProfilePicturesPanel);
                                CenterPanel.this.revalidate();
                                break;

                            case IMAGE_PANEL:
                                CenterPanel.this.removeAll();
                                ImagePanel imagePanel = new ImagePanel();
                                GuiGlobals.mainFrame.activeCenterPanel = imagePanel;
                                CenterPanel.this.add(imagePanel);
                                CenterPanel.this.revalidate();
                                break;

                            case REQUESTS:
                                CenterPanel.this.removeAll();
                                RequestsPanel requestsPanel = new RequestsPanel();
                                CenterPanel.this.add(requestsPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case RECOMMENDS:
                                CenterPanel.this.removeAll();
                                RecommendsPanel recommends = new RecommendsPanel();
                                CenterPanel.this.add(recommends);
                                CenterPanel.this.revalidate();
                                break;
                            case NEW_POST:
                                CenterPanel.this.removeAll();
                                NewPostPanel newPostPanel = new NewPostPanel();
                                CenterPanel.this.add(newPostPanel);
                                CenterPanel.this.revalidate();
                                break;
                            case FORGET_PASSWORD:
                                CenterPanel.this.removeAll();
                                ForgotPasswordPanel forgotPasswordPanel = new ForgotPasswordPanel();
                                CenterPanel.this.add(forgotPasswordPanel);
                                CenterPanel.this.revalidate();
                                break;
                        }

                        rendered = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!themeRendered) {

                    if (GuiGlobals.mainFrame.activeCenterPanel instanceof BasePanel) {
                        ((BasePanel) GuiGlobals.mainFrame.activeCenterPanel).changeColor();
                    } else {
                        GuiGlobals.mainFrame.activeCenterPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    }

                    CenterPanel.this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    themeRendered = true;

                }

            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100); //call the run() method at 1 second intervals

    }

}

