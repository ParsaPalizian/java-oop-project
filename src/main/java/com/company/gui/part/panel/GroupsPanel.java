package com.company.gui.part.panel;

import com.company.dataadapter.GroupMessageDataAdapter;
import com.company.global.Globals;
import com.company.gui.assets.GroupItem;
import com.company.gui.assets.LeftGroupMessageItem;
import com.company.gui.assets.RightGroupMessageItem;
import com.company.gui.assets.widget.BasePanel;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.TopMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Group;
import com.company.model.GroupMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TimerTask;

public class GroupsPanel extends BasePanel {
    JPanel pnlMessageAndTypeAndSend;
    JPanel pnlMessages;
    JScrollPane scrMessages;
    JPanel pnlTypeAndSend;
    JTextField txtType;
    JButton btnSend;
    JPanel pnlGroups;
    JScrollPane scrGroups;
    public boolean messagesRendered = true;

    public Group selectedGroup = null;

    public GroupsPanel() {

        this.setLayout(new BorderLayout());
        pnlMessageAndTypeAndSend = new JPanel();
        pnlMessages = new JPanel();
        pnlTypeAndSend = new JPanel();
        pnlMessageAndTypeAndSend.setLayout(new BorderLayout());
        pnlMessages.setLayout(new BoxLayout(pnlMessages, BoxLayout.Y_AXIS));
        scrMessages = new JScrollPane(pnlMessages);
        scrMessages.getVerticalScrollBar().setUnitIncrement(32);


        pnlTypeAndSend.setLayout(new BorderLayout());
        pnlMessageAndTypeAndSend.add(scrMessages, BorderLayout.CENTER);
        pnlMessageAndTypeAndSend.add(pnlTypeAndSend, BorderLayout.SOUTH);
        txtType = new JTextField();
        btnSend = new JButton("send");
        pnlTypeAndSend.add(txtType, BorderLayout.CENTER);
        pnlTypeAndSend.add(btnSend, BorderLayout.EAST);
        pnlGroups = new JPanel();
        pnlGroups.setLayout(new BoxLayout(pnlGroups, BoxLayout.Y_AXIS));
        pnlGroups.setBackground(GuiSetting.selectedTheme.getSecondaryColor());
        scrGroups = new JScrollPane(pnlGroups);


        this.add(scrGroups, BorderLayout.WEST);
        this.add(pnlMessageAndTypeAndSend, BorderLayout.CENTER);

        for (Group group : Globals.loggedInAccount.getGroups()) {


            GroupItem groupItem = null;
            if (new File("assets\\groups\\profiles\\" + group.getProfilePicture()).exists()) {
                 groupItem = new GroupItem(group, "assets\\groups\\profiles\\" + group.getProfilePicture(), group.getName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            } else {
                 groupItem = new GroupItem(group, "assets\\profiles\\general.png", group.getName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            }

            groupItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlGroups.add(groupItem);
            pnlGroups.add(Box.createRigidArea(new Dimension(10, 10)));

        }

        int h = Globals.loggedInAccount.getGroups().size() * 42;
        pnlGroups.setPreferredSize(new Dimension(150, h));

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedGroup != null && !txtType.getText().trim().isEmpty()) {
                        GroupMessage groupMessage = new GroupMessage();
                        groupMessage.setContent(txtType.getText().trim());
                        groupMessage.setSender(Globals.currentAccount);
                        groupMessage.setGroup(selectedGroup);
                        GroupMessageDataAdapter adapter = new GroupMessageDataAdapter();
                        groupMessage = adapter.insert(groupMessage);
                        selectedGroup.getMessages().add(groupMessage);
                        txtType.setText("");
                        messagesRendered = false;

                    }

                } catch (Exception ex) {
                }
            }
        });

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);

//        GuiGlobals.mainFrame.activeCenterPanel = this;


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (messagesRendered == false) {
                        GroupsPanel.this.pnlMessages.removeAll();
                        if (selectedGroup != null) {
                            for (GroupMessage groupMessage : selectedGroup.getMessages()) {
                                if (groupMessage.getSender().getId() == Globals.currentAccount.getId()) {
                                    RightGroupMessageItem rightMessageItem = new RightGroupMessageItem(groupMessage);
                                    pnlMessages.add(rightMessageItem);
                                } else {
                                    LeftGroupMessageItem leftPrivateMessageItem = new LeftGroupMessageItem(groupMessage);
                                    pnlMessages.add(leftPrivateMessageItem);
                                }
                            }
                            GuiGlobals.mainFrame.topPanel.rendered = false;
                            GuiGlobals.mainFrame.topPanel.currentMenuSituation = TopMenuSituation.SELECT_GROUP;

                            int h = selectedGroup.getMessages().size() * 100;
                            pnlMessages.setPreferredSize(new Dimension(600, h));

                            messagesRendered = true;
                            GroupsPanel.this.revalidate();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100); //call the run() method at 1 second intervals


    }

    @Override
    public void changeColor() {
        pnlGroups.setBackground(GuiSetting.selectedTheme.getSecondaryColor());

    }
}
