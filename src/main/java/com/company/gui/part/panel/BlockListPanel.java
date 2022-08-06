package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.BlockItem;
import com.company.gui.assets.ContactItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.Account;
import com.company.model.Block;

import javax.swing.*;
import java.awt.*;

public class BlockListPanel extends JPanel {

    JScrollPane scrItems;
    JPanel pnlItems;



    public BlockListPanel(){


        this.setLayout(new BorderLayout());
        pnlItems = new JPanel();
        pnlItems.setLayout(new BoxLayout(pnlItems, BoxLayout.Y_AXIS));
        scrItems = new JScrollPane(pnlItems);
        scrItems.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrItems, BorderLayout.CENTER);

        for (Block block : Globals.currentAccount.getBlocklist()) {

            BlockItem blockItem =  new BlockItem(block , "assets\\profiles\\general.png", block.getBlocked().getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            blockItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlItems.add(blockItem);
            pnlItems.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        int h = Globals.currentAccount.getBlocklist().size() * 42;
        pnlItems.setPreferredSize(new Dimension(600, h));

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
