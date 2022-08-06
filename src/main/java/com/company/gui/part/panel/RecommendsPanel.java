package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.BlockItem;
import com.company.gui.assets.RecommendItem;
import com.company.gui.assets.RequestItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.Account;
import com.company.model.Block;

import javax.swing.*;
import java.awt.*;

public class RecommendsPanel extends JPanel {

    JScrollPane scrItems;
    JPanel pnlItems;


    public RecommendsPanel(){


        this.setLayout(new BorderLayout());
        pnlItems = new JPanel();
        pnlItems.setLayout(new BoxLayout(pnlItems, BoxLayout.Y_AXIS));
        scrItems = new JScrollPane(pnlItems);
        scrItems.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrItems, BorderLayout.CENTER);


        for (Account account : Globals.recommendAccounts) {

            RecommendItem recommendItem=  new RecommendItem("assets\\profiles\\general.png", account.getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            recommendItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlItems.add(recommendItem);
            pnlItems.add(Box.createRigidArea(new Dimension(10, 10)));

        }

        int h = Globals.recommendAccounts.size() * 42;
        pnlItems.setPreferredSize(new Dimension(600, h));

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
