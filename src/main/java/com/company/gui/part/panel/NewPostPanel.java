package com.company.gui.part.panel;

import com.company.dataadapter.PostDataAdapter;
import com.company.global.Globals;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Post;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

public class NewPostPanel extends JPanel {

    JLabel lblMedia;
    JTextField txtMedia;
    JLabel lblMediaError;

    JLabel lblContent;
    JTextField txtContent;
    JLabel lblContentError;

    JButton btnSelectFile;
    JButton btnFinish;


    public NewPostPanel() {
        lblMedia = new JLabel("Media");
        txtMedia = new JTextField();
        lblMediaError = new JLabel("");
        lblMediaError.setForeground(Color.RED);

        lblContent = new JLabel("Content");
        txtContent = new JTextField();
        lblContentError = new JLabel("");
        lblContentError.setForeground(Color.RED);

        btnSelectFile = new JButton("Choose");
        btnFinish = new JButton("Finish");

        this.setLayout(null);

        this.add(lblMedia);
        this.add(txtMedia);
        this.add(lblMediaError);

        this.add(lblContent);
        this.add(txtContent);
        this.add(lblContentError);


        this.add(btnSelectFile);
        this.add(btnFinish);

        lblMedia.setBounds(25 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtMedia.setBounds(200 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblMediaError.setBounds(600 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSelectFile.setBounds(400 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSelectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(NewPostPanel.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    txtMedia.setText(selectedFile.getAbsolutePath());
                }
            }
        });


        lblContent.setBounds(25 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtContent.setBounds(200 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblContentError.setBounds(300 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnFinish.setBounds(100 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostDataAdapter postDataAdapter = null;
                try {

                    boolean toSave = true;
                    if (txtContent.getText().trim().isEmpty()) {
                        toSave = false;
                        lblContentError.setText("fill content");
                    } else {
                        lblContentError.setText("");
                    }

                    if (txtMedia.getText().trim().isEmpty()) {
                        toSave = false;
                        lblMediaError.setText("fill media");
                    } else {
                        lblMediaError.setText("");
                    }

                    if (toSave) {

                        Post post = new Post();
                        post.setContent(txtContent.getText().trim());
                        post.setMedia(FileUtility.copyPostFile(txtMedia.getText()));
                        post.getAccount().setId(Globals.currentAccount.getId());
                        postDataAdapter = new PostDataAdapter();
                        post = postDataAdapter.insert(post).clone();
                        Globals.currentAccount.getPosts().add(post);
                        Globals.currentPosts.add(post);
                        GuiGlobals.mainFrame.centerPanel.rendered = false;
                        GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.IMAGE_PANEL;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        this.setBounds(100, 100, 500 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
