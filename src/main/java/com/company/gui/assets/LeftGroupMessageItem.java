package com.company.gui.assets;

import com.company.gui.assets.widget.ImageButton;
import com.company.model.GroupMessage;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;

public class LeftGroupMessageItem extends JPanel {
    JPanel pnlMain;
    ImageButton btnSenderProfilePicture;
    JLabel lblMessage;
    GroupMessage groupMessage;

    public LeftGroupMessageItem(GroupMessage groupMessage) {
        super();
        this.groupMessage = groupMessage;
        this.setLayout(new BorderLayout());
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
        this.add(pnlMain, BorderLayout.WEST);

        if (FileUtility.isAvatarExists(groupMessage.getSender().getAvatar())) {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\" + groupMessage.getSender().getAvatar(), new Dimension(32, 32));
        } else {
            btnSenderProfilePicture = new ImageButton("assets\\profiles\\general0.5x.png", new Dimension(32, 32));
        }

        lblMessage = new JLabel(groupMessage.getContent());

        pnlMain.add(btnSenderProfilePicture);
        pnlMain.add(Box.createRigidArea(new Dimension(10,1)));

        pnlMain.add(lblMessage);

    }
}
