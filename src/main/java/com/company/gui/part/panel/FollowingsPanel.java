package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.FollowerItem;
import com.company.gui.assets.FollowingItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.Follow;

import javax.swing.*;
import java.awt.*;

public class FollowingsPanel extends JPanel {


    JScrollPane scrItems;
    JPanel pnlItems;


    public FollowingsPanel() {

        this.setLayout(new BorderLayout());
        pnlItems = new JPanel();
        pnlItems.setLayout(new BoxLayout(pnlItems, BoxLayout.Y_AXIS));
        scrItems = new JScrollPane(pnlItems);
        scrItems.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrItems, BorderLayout.CENTER);


        for (Follow follow : Globals.currentAccount.getFollowings()) {
            FollowingItem followingItem=  new FollowingItem(follow,"assets\\profiles\\general.png", follow.getAccount().getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            followingItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlItems.add(followingItem);
            pnlItems.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        int h = Globals.currentAccount.getFollowings().size() * 42;
        pnlItems.setPreferredSize(new Dimension(600, h));


        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
