package com.company.gui.part.panel;

import com.company.gui.global.GuiGlobals;

import javax.swing.*;
import java.io.File;

public class PostingPanel extends JPanel {

    JButton btnAddNewPost;
    JButton btnEditPost;
    JButton btnDeletePost;

    public PostingPanel() {

        btnAddNewPost = new JButton("Add New Post");
        btnEditPost = new JButton("Edit Post");
        btnDeletePost = new JButton("Delete Post");

        this.setLayout(null);
        this.add(btnAddNewPost);
        this.add(btnEditPost);
        this.add(btnDeletePost);

        btnAddNewPost.setBounds(125 + this.getInsets().left, 50 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnEditPost.setBounds(125 + this.getInsets().left, 100 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnDeletePost.setBounds(125 + this.getInsets().left, 150 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);


        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
//        this.add(fileChooser);


        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);


    }
}
