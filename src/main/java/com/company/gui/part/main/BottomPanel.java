package com.company.gui.part.main;

import com.company.global.Globals;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.MainMenuSituation;
import com.company.gui.global.GuiGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

/**
 * Created by kami on 7/29/2022.
 */
public class BottomPanel extends JPanel {

    public boolean rendered = false;
    public boolean themeRendered = true;
    public MainMenuSituation currentSituationMainMenu = MainMenuSituation.NONE;

    public IconButton btnHome;
    public IconButton btnTimeline;
    public IconButton btnExplorer;
    public IconButton btnSearch;
    public IconButton btnSettings;

    public IconButton btnLogin;
    public IconButton btnRegister;
    public IconButton btnForgot;


    public BottomPanel() {

        super(new FlowLayout(FlowLayout.CENTER, 48, 4));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());

        btnHome = new IconButton(
                GuiSetting.selectedIconSet.main.home,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );


        btnTimeline = new IconButton(
                GuiSetting.selectedIconSet.main.timeline,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnExplorer = new IconButton(
                GuiSetting.selectedIconSet.main.explorer,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnSearch = new IconButton(
                GuiSetting.selectedIconSet.main.search,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnSettings = new IconButton(
                GuiSetting.selectedIconSet.main.settings,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnLogin = new IconButton(
                GuiSetting.selectedIconSet.main.login,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnRegister = new IconButton(
                GuiSetting.selectedIconSet.main.register,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        btnForgot = new IconButton(
                GuiSetting.selectedIconSet.main.forgot,
                64,
                GuiSetting.selectedTheme.getSecondaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        this.add(btnHome);
        this.add(btnTimeline);
        this.add(btnExplorer);
        this.add(btnSearch);
        this.add(btnSettings);
        this.add(btnLogin);
        this.add(btnRegister);
        this.add(btnForgot);

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSituationMainMenu = MainMenuSituation.HOME;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
            }
        });

        btnTimeline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSituationMainMenu = MainMenuSituation.TIMELINE;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
            }
        });

        btnExplorer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSituationMainMenu = MainMenuSituation.EXPLORER;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSituationMainMenu = MainMenuSituation.SEARCH;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
            }
        });

        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSituationMainMenu = MainMenuSituation.SETTINGS;
                GuiGlobals.mainFrame.leftPanel.rendered = false;
            }
        });


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
//                    Account.login("parsa", "1");

                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.LOGIN;
//                    rendered = false;
                    GuiGlobals.mainFrame.topPanel.rendered = false;


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    Account.login("parsa", "1");

                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.SIGNUP;
//                    rendered = false;
                    GuiGlobals.mainFrame.topPanel.rendered = false;


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        btnForgot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    Account.login("parsa", "1");

                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.FORGET_PASSWORD;
//                    rendered = false;
                    GuiGlobals.mainFrame.topPanel.rendered = false;


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {

                    if (Globals.currentAccount != null && rendered == false) {

                        btnHome.setVisible(true);
                        btnTimeline.setVisible(true);
                        btnExplorer.setVisible(true);
                        btnSearch.setVisible(true);
                        btnSettings.setVisible(true);

                        btnLogin.setVisible(false);
                        btnRegister.setVisible(false);
                        btnForgot.setVisible(false);

                        rendered = true;

                    } else if (Globals.currentAccount == null && rendered == false) {

                        btnHome.setVisible(false);
                        btnTimeline.setVisible(false);
                        btnExplorer.setVisible(false);
                        btnSearch.setVisible(false);
                        btnSettings.setVisible(false);

                        btnLogin.setVisible(true);
                        btnRegister.setVisible(true);
                        btnForgot.setVisible(true);

                        rendered = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!themeRendered ) {

                    BottomPanel.this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    btnHome.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnExplorer.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnForgot.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnLogin.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnRegister.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnSearch.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnSettings.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    btnTimeline.changeColor(GuiSetting.selectedTheme.getSecondaryColor(),GuiSetting.selectedTheme.getSecondaryVariantColor() );
                    themeRendered = true;
                }


            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100);

    }

}
