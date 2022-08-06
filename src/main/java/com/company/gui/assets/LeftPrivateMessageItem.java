package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.assets.widget.ImageButton;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.PrivateMessage;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPrivateMessageItem extends JPanel {
    JPanel pnlMain;
    ImageButton btnSenderProfilePicture;
    JLabel lblMessage;
    PrivateMessage privateMessage;

    public LeftPrivateMessageItem(PrivateMessage privateMessage) {
        super();
        this.privateMessage = privateMessage;
        this.setLayout(new BorderLayout());
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
        this.add(pnlMain, BorderLayout.WEST);


        if (FileUtility.isAvatarExists(privateMessage.getSender().getAvatar())) {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\" + privateMessage.getSender().getAvatar(), new Dimension(32, 32));
        } else {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\general0.5x.png", new Dimension(32, 32));
        }

        btnSenderProfilePicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GuiGlobals.mainFrame.centerPanel.rendered = false;
                GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.HOME;
                GuiGlobals.mainFrame.topPanel.rendered = false;
                GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.HOME;
                Globals.currentAccount = privateMessage.getSender();

            }
        });
        lblMessage = new JLabel(privateMessage.getContent());

        pnlMain.add(btnSenderProfilePicture);
        pnlMain.add(Box.createRigidArea(new Dimension(10, 1)));

        pnlMain.add(lblMessage);

    }
}
