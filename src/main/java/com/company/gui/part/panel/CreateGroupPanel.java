package com.company.gui.part.panel;

import com.company.dataadapter.GroupDataAdapter;
import com.company.global.Globals;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.Group;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.HashSet;

public class CreateGroupPanel extends JPanel {

    JLabel lblName;
    JTextField txtName;

    JLabel lblBio;
    JTextField txtBio;

    JLabel lblProfilePictureAddress;
    JTextField txtProfilePictureAddress;
    JButton btnSelectFile;

    JLabel lblLink;
    JTextField txtLink;

    JButton btnFinish;

    public CreateGroupPanel() {

        lblName = new JLabel("Name");
        txtName = new JTextField();

        lblBio = new JLabel("Bio");
        txtBio = new JTextField();

        lblProfilePictureAddress = new JLabel("Profile Picture Address");
        txtProfilePictureAddress = new JTextField();
        btnSelectFile = new JButton("Choose");

        lblLink = new JLabel("Link");
        txtLink = new JTextField();

        btnFinish = new JButton("Finish");

        this.setLayout(null);
        this.add(lblName);
        this.add(txtName);

        this.add(lblBio);
        this.add(txtBio);

        this.add(lblProfilePictureAddress);
        this.add(txtProfilePictureAddress);
        this.add(btnSelectFile);

        this.add(lblLink);
        this.add(txtLink);

        this.add(btnFinish);


        lblName.setBounds(25 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtName.setBounds(200 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblBio.setBounds(25 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtBio.setBounds(200 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblProfilePictureAddress.setBounds(25 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtProfilePictureAddress.setBounds(200 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSelectFile.setBounds(400 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSelectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(CreateGroupPanel.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    txtProfilePictureAddress.setText(selectedFile.getAbsolutePath());
                }
            }
        });


        lblLink.setBounds(25 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtLink.setBounds(200 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnFinish.setBounds(100 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    HashSet<Account> members = new HashSet<>();
                    members.add(Globals.currentAccount);
                    Group group = new Group();
                    group.setName(txtName.getText().trim());
                    group.setBio(txtBio.getText().trim());
                    group.setProfilePicture(FileUtility.copyGroupAvatarImage(txtProfilePictureAddress.getText().trim()));
                    group.setLink(txtLink.getText().trim());
                    group.setCreator(Globals.currentAccount);
                    Group.create(group, members);

                    GuiGlobals.mainFrame.topPanel.rendered = false;
                    GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.GROUPS;
                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                    GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.GROUPS;

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.setBounds(100, 100, 500 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
