package com.company.gui.part.main;

import com.company.global.Globals;
import com.company.gui.assets.GroupItem;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.assets.widget.ImageButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.MainMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.CreateGroupPanel;
import com.company.gui.part.panel.GroupsPanel;
import com.company.model.Group;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TimerTask;

/**
 * Created by kami on 7/29/2022.
 */
public class TopPanel extends JPanel {

    public boolean rendered = false;
    public boolean themeRendered = false;
    ImageButton btnProfile;
    IconButton btnChangeColor;
    IconButton btnChangeTheme;
    IconButton btnLogout;

    JPanel leftPanel;
    JPanel midPanel;
    JPanel rightPanel;

    IconButton btnGroupCreate;
    IconButton btnGroupBack;
    IconButton btnGroupSave;


    IconButton btnGroupRemove;
    IconButton btnGroupLeave;
    IconButton btnGroupChangeAvatar;


    public TopMenuSituation currentMenuSituation = TopMenuSituation.NONE;

    public TopPanel() {

        super(new BorderLayout(2, 0));

        this.setPreferredSize(new Dimension(64, 64));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());

        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        this.add(leftPanel, BorderLayout.WEST);

        midPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        midPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        this.add(midPanel, BorderLayout.CENTER);

        rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        this.add(rightPanel, BorderLayout.EAST);

        btnProfile = new ImageButton("assets\\profiles\\general.png", new Dimension(64, 64));
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Globals.currentAccount != null) {
                    Globals.currentAccount = Globals.loggedInAccount;
                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.HOME;
                }
            }
        });

        leftPanel.add(btnProfile);

        btnChangeColor = new IconButton(
                GuiSetting.selectedIconSet.theme.changeColor,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnChangeColor.setVisible(false);
        btnChangeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(btnChangeColor);


        btnChangeTheme = new IconButton(
                GuiSetting.selectedIconSet.theme.changeTheme,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnChangeTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiSetting.changeTheme();
                GuiGlobals.mainFrame.bottomPanel.themeRendered = false;
                GuiGlobals.mainFrame.centerPanel.themeRendered = false;
                GuiGlobals.mainFrame.leftPanel.themeRendered = false;
                GuiGlobals.mainFrame.rightPanel.themeRendered = false;
                themeRendered = false;


            }
        });
        rightPanel.add(btnChangeTheme);

        btnLogout = new IconButton(
                GuiSetting.selectedIconSet.main.logout,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Globals.currentAccount = null;
                rendered = false;
                GuiGlobals.mainFrame.bottomPanel.rendered = false;
                GuiGlobals.mainFrame.bottomPanel.currentSituationMainMenu = MainMenuSituation.NONE;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
                GuiGlobals.mainFrame.topPanel.rendered = false;
                GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.NONE;
                rendered = false;
                currentMenuSituation = TopMenuSituation.NONE;

            }
        });

        rightPanel.add(btnLogout);

        btnGroupCreate = new IconButton(
                GuiSetting.selectedIconSet.action.add,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupCreate.setToolTipText("ADD GROUP");
        btnGroupCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.CREATE_GROUP;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
                rendered = false;
                currentMenuSituation = TopMenuSituation.CREATE_GROUP;
            }
        });
        btnGroupCreate.setVisible(false);
        midPanel.add(btnGroupCreate);


        btnGroupBack = new IconButton(
                GuiSetting.selectedIconSet.action.back,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupBack.setToolTipText("BACK");
        btnGroupBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.GROUPS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
                rendered = false;
                currentMenuSituation = TopMenuSituation.GROUPS;
            }
        });
        midPanel.add(btnGroupBack);


        btnGroupSave = new IconButton(
                GuiSetting.selectedIconSet.action.save,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupSave.setToolTipText("SAVE");
        midPanel.add(btnGroupSave);
        btnGroupSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.GROUPS;
                GuiGlobals.mainFrame.centerPanel.rendered = false;
                rendered = false;
                currentMenuSituation = TopMenuSituation.GROUPS;

            }
        });


        btnGroupRemove = new IconButton(
                GuiSetting.selectedIconSet.action.remove,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupRemove.setToolTipText("DELETE GROUP");
        btnGroupRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        midPanel.add(btnGroupRemove);

        btnGroupLeave = new IconButton(
                GuiSetting.selectedIconSet.action.remove,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupLeave.setToolTipText("LEAVE");
        btnGroupLeave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        midPanel.add(btnGroupLeave);

        btnGroupChangeAvatar = new IconButton(
                GuiSetting.selectedIconSet.action.changeAvatar,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnGroupChangeAvatar.setToolTipText("CHANGE AVATAR");
        btnGroupChangeAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(TopPanel.this);
                if (result == JFileChooser.APPROVE_OPTION) {

                    try {

                        File selectedFile = fileChooser.getSelectedFile();
                        String path = selectedFile.getAbsolutePath();
                        if (GuiGlobals.mainFrame.activeCenterPanel instanceof GroupsPanel) {
                            String newPath = FileUtility.copyGroupAvatarImage(path);
                            ((GroupsPanel) GuiGlobals.mainFrame.activeCenterPanel).selectedGroup.setProfilePicture(newPath);
                            ((GroupsPanel) GuiGlobals.mainFrame.activeCenterPanel).selectedGroup.changeAvatar();
                            GuiGlobals.mainFrame.centerPanel.rendered = false;

                        }
                    } catch (Exception ex) {
                    }
                }
            }
        });
        midPanel.add(btnGroupChangeAvatar);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (rendered == false) {

                        if (Globals.currentAccount != null) {
                            btnLogout.setVisible(true);
                            if (new File("assets\\profiles\\" + Globals.loggedInAccount.getAvatar()).exists()) {
                                btnProfile.changeImage("assets\\profiles\\" + Globals.loggedInAccount.getAvatar());
                            } else {
                                btnProfile.changeImage("assets\\profiles\\general.png");
                            }
                        } else if (Globals.currentAccount == null) {
                            btnLogout.setVisible(false);
                            btnProfile.changeImage("assets\\profiles\\general.png");
//                            btnProfile.setVisible(false);
                        }


                        switch (currentMenuSituation) {
                            case NONE:
                                btnGroupCreate.setVisible(false);
                                btnGroupSave.setVisible(false);
                                btnGroupBack.setVisible(false);
                                btnGroupRemove.setVisible(false);
                                btnGroupLeave.setVisible(false);
                                btnGroupChangeAvatar.setVisible(false);
                                break;
                            case GROUPS:
                                btnGroupCreate.setVisible(true);
                                btnGroupSave.setVisible(false);
                                btnGroupBack.setVisible(false);
                                btnGroupRemove.setVisible(false);
                                btnGroupLeave.setVisible(false);
                                btnGroupChangeAvatar.setVisible(false);
                                break;
                            case CREATE_GROUP:
                                btnGroupCreate.setVisible(false);
                                btnGroupSave.setVisible(true);
                                btnGroupBack.setVisible(true);
                                btnGroupRemove.setVisible(false);
                                btnGroupLeave.setVisible(false);
                                btnGroupChangeAvatar.setVisible(false);
                                break;
                            case SELECT_GROUP:
                                btnGroupCreate.setVisible(false);
                                btnGroupSave.setVisible(false);
                                btnGroupBack.setVisible(true);
                                btnGroupRemove.setVisible(true);
                                btnGroupLeave.setVisible(true);
                                btnGroupChangeAvatar.setVisible(true);
                                break;
                            default:
                                btnGroupCreate.setVisible(false);
                                btnGroupSave.setVisible(false);
                                btnGroupBack.setVisible(false);
                                btnGroupRemove.setVisible(false);
                                btnGroupLeave.setVisible(false);
                                btnGroupChangeAvatar.setVisible(false);
                                break;
                        }

                        midPanel.revalidate();
                        rendered = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!themeRendered) {

                    TopPanel.this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    btnChangeColor.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnChangeTheme.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnLogout.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());

                    leftPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    midPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    rightPanel.setBackground(GuiSetting.selectedTheme.getPrimaryColor());

                    btnGroupCreate.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnGroupBack.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnGroupSave.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());

                    btnGroupRemove.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnGroupLeave.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());


                    themeRendered = true;
                }

            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100);

    }

}
