package com.company.gui.assets;

import com.company.gui.assets.widget.ImageButton;
import com.company.model.Comment;

import javax.swing.*;
import java.awt.*;

public class CommentItem extends JPanel {
    JPanel pnlMain;
    ImageButton btnSenderProfilePicture;
    JLabel lblMessage;
    Comment comment;
    public CommentItem(Comment comment) {
        super();
        this.comment = comment;
        this.setLayout(new BorderLayout());
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
        this.add(pnlMain, BorderLayout.WEST);

        btnSenderProfilePicture = new ImageButton("assets\\profiles\\general0.5x.png",new Dimension(32,32));
        lblMessage = new JLabel(comment.getContent());

        pnlMain.add(btnSenderProfilePicture);
        pnlMain.add(Box.createRigidArea(new Dimension(10,1)));

        pnlMain.add(lblMessage);

    }


}
