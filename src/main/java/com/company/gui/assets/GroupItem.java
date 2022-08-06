package com.company.gui.assets;

import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.GroupsPanel;
import com.company.gui.part.panel.MessagePanel;
import com.company.model.Account;
import com.company.model.Group;
import com.company.model.GroupMessage;
import com.company.model.PrivateMessage;
import com.company.utility.ImageUtility;
import com.company.utility.PrintUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupItem extends JPanel {
    JButton btn;
    JLabel lbl;
    Group group;


    public GroupItem(Group group, String profile, String text, Color back, Color textColor) {
        super();
        this.group = group;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(back);
        btn = new JButton(new ImageIcon(ImageUtility.resize(new ImageIcon(profile).getImage(), new Dimension(32,32))));
        btn.setFont(new Font("Arial", 0, 24));
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setAlignmentY(Component.CENTER_ALIGNMENT);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (GuiGlobals.mainFrame.activeCenterPanel instanceof GroupsPanel) {

                    ((GroupsPanel) GuiGlobals.mainFrame.activeCenterPanel).messagesRendered = false;
                    ((GroupsPanel) GuiGlobals.mainFrame.activeCenterPanel).selectedGroup = group;

                }
            }
        });


        this.add(btn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        lbl = new JLabel(text);
        lbl.setForeground(textColor);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setFont(new Font("Arial", 0, 24));
        lbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(10, 0)));


    }
}
