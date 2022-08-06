package com.company.gui.part.panel;

import com.company.Result;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.MainMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    JTextField txtUsername;
    JTextField txtPassword;
    JButton btnLogin;

    public LoginPanel() {

        txtUsername = new JTextField();
        txtPassword = new JTextField();
        btnLogin = new JButton("Login");

        this.setLayout(null);
        this.add(btnLogin);
        this.add(txtUsername);
        this.add(txtPassword);



        if (GuiGlobals.DEBUG_MODE) {
            txtUsername.setText("parsa");
            txtPassword.setText("1");
        }

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Result<Account> result = Account.login(txtUsername.getText().trim(), txtPassword.getText().trim());
                    if(!result.isError()) {
                        GuiGlobals.mainFrame.centerPanel.rendered = false;
                        GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.NONE;
                        GuiGlobals.mainFrame.bottomPanel.rendered = false;
                        GuiGlobals.mainFrame.bottomPanel.currentSituationMainMenu = MainMenuSituation.HOME;
                        GuiGlobals.mainFrame.leftPanel.rendered = false;
                        GuiGlobals.mainFrame.topPanel.rendered = false;
                        GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.NONE;

                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });

        Insets insets = this.getInsets();
        Dimension size = btnLogin.getPreferredSize();
        btnLogin.setBounds(25 + insets.left, 65 + insets.top, size.width, size.height);

        insets = this.getInsets();
        size = txtUsername.getPreferredSize();
        txtPassword.setBounds(25 + insets.left, 35 + insets.top, 100, 30);

        insets = this.getInsets();
        size = txtPassword.getPreferredSize();
        txtUsername.setBounds(25 + insets.left, 5 + insets.top, 100, 30);

        insets = this.getInsets();
        this.setBounds(400, 400, 300 + insets.left + insets.right, 400);
        this.setVisible(true);

    }
}
