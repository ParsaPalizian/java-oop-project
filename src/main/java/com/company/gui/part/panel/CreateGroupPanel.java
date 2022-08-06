package com.company.gui.part.panel;

import com.company.dataadapter.GroupDataAdapter;
import com.company.global.Globals;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.Follow;
import com.company.model.Group;
import com.company.utility.FileUtility;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

    JPanel pnlAddMember;


    JButton btnFinish;
    HashSet<Account> members = new HashSet<>();

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

        pnlAddMember = new JPanel();
        pnlAddMember.setLayout(new BorderLayout());
        pnlAddMember.setBackground(Color.orange);

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

        this.add(pnlAddMember);


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

        pnlAddMember.setBounds(100 + this.getInsets().left, 155 + this.getInsets().top, 600, 600);
        JPanel pnlMembers = new JPanel();
        pnlMembers.setLayout(new BoxLayout(pnlMembers, BoxLayout.Y_AXIS));

        for (Follow follow : Globals.loggedInAccount.getFollowers()) {
            JCheckBox checkBox = new JCheckBox(follow.getAccount().getUserName());
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        members.add(follow.getAccount());
                    } else if (e.getStateChange() == 2){
                        members.remove(follow.getAccount());
                    }
                    System.out.println("MEMEBERS SIZE :" + members.size());
                }
            });

            pnlMembers.add(checkBox);
        }

        pnlMembers.setPreferredSize(new Dimension(500, Globals.loggedInAccount.getFollowers().size() * 24));
        JScrollPane scrollPane = new JScrollPane(pnlMembers);
        scrollPane.getVerticalScrollBar().setUnitIncrement(32);
        scrollPane.setSize(new Dimension(600, 600));
        pnlAddMember.add(scrollPane, BorderLayout.CENTER);

        this.setBounds(100, 100, 500 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
