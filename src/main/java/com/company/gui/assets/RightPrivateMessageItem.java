package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.assets.widget.ImageButton;
import com.company.model.PrivateMessage;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;

public class RightPrivateMessageItem extends JPanel {

    JPanel pnlMain;
    ImageButton btnSenderProfilePicture;
    JLabel lblMessage;
    PrivateMessage privateMessage;

    public RightPrivateMessageItem(PrivateMessage privateMessage) {
        super();
        this.privateMessage = privateMessage;
        this.setLayout(new BorderLayout());
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
        this.add(pnlMain, BorderLayout.EAST);

        lblMessage = new JLabel(privateMessage.getContent());


        if (FileUtility.isAvatarExists(Globals.currentAccount.getAvatar())) {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\" + Globals.currentAccount.getAvatar(), new Dimension(32, 32));
        } else {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\general0.5x.png", new Dimension(32, 32));
        }

        pnlMain.add(lblMessage);
        pnlMain.add(Box.createRigidArea(new Dimension(10,1)));
        pnlMain.add(btnSenderProfilePicture);

    }
}
