package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.FollowerItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.Follow;

import javax.swing.*;
import java.awt.*;


public class FollowersPanel extends JPanel {

    JScrollPane scrItems;
    JPanel pnlItems;

    public FollowersPanel() {

        this.setLayout(new BorderLayout());
        pnlItems = new JPanel();
        pnlItems.setLayout(new BoxLayout(pnlItems, BoxLayout.Y_AXIS));
        scrItems = new JScrollPane(pnlItems);
        scrItems.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrItems, BorderLayout.CENTER);

        for (Follow follow : Globals.currentAccount.getFollowers()) {
            FollowerItem followerItem = new FollowerItem(follow,"assets\\profiles\\general.png", follow.getAccount().getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            followerItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlItems.add(followerItem);
            pnlItems.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        int h = Globals.currentAccount.getFollowers().size() * 42;
        pnlItems.setPreferredSize(new Dimension(600, h));

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
