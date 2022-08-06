package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.assets.widget.ImageButton;
import com.company.model.PrivateMessage;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;

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

        lblMessage = new JLabel(privateMessage.getContent());

        pnlMain.add(btnSenderProfilePicture);
        pnlMain.add(Box.createRigidArea(new Dimension(10,1)));

        pnlMain.add(lblMessage);

    }
}
