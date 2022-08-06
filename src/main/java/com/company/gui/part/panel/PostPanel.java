package com.company.gui.part.panel;

import com.company.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPanel extends JPanel {
    JPanel pnlHeader;
    JPanel pnlContent;
    JPanel pnlUtilities;

    JButton btnPostersProfilePicture;
    JLabel lblPostersName;
    JButton btnPost;
    JLabel lblCaption;
    JButton btnReact;
    JButton btnComment;
    JButton btnViewComment;
    JButton btnDelete;


    public PostPanel() {

        this.setLayout(new BorderLayout());

        pnlHeader = new JPanel();
        pnlContent = new JPanel();
        pnlUtilities = new JPanel();

        pnlHeader.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlContent.setLayout(new BorderLayout());
        pnlUtilities.setLayout(new FlowLayout());


        btnPostersProfilePicture = new JButton("Profile Picture");
        lblPostersName = new JLabel("Posters Name");
        btnPost = new JButton("Post");
        lblCaption = new JLabel("Caption");
        btnReact = new JButton("React");
        btnComment = new JButton("Comment");
        btnViewComment = new JButton("View Comment");
        btnDelete = new JButton("Delete");

        pnlHeader.add(btnPostersProfilePicture);
        pnlHeader.add(lblPostersName);

        pnlContent.add(btnPost);
        pnlContent.setBackground(Color.RED);
        pnlContent.add(lblCaption);

        pnlUtilities.add(btnReact);
        pnlUtilities.add(btnComment);
        pnlUtilities.add(btnViewComment);
        pnlUtilities.add(btnDelete);

        this.add(pnlHeader, BorderLayout.NORTH);
        this.add(pnlContent, BorderLayout.CENTER);
        this.add(pnlUtilities, BorderLayout.SOUTH);


        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
