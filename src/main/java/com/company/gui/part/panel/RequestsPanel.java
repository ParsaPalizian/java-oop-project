package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.FollowerItem;
import com.company.gui.assets.RequestItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.Follow;
import com.company.model.Request;

import javax.swing.*;
import java.awt.*;

public class RequestsPanel extends JPanel {
    JScrollPane scrItems;
    JPanel pnlItems;


    public RequestsPanel() {

        this.setLayout(new BorderLayout());
        pnlItems = new JPanel();
        pnlItems.setLayout(new BoxLayout(pnlItems, BoxLayout.Y_AXIS));
        scrItems = new JScrollPane(pnlItems);
        scrItems.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrItems, BorderLayout.CENTER);


        for (Request request : Globals.currentAccount.getRequests()) {
            RequestItem requestItem=  new RequestItem("assets\\profiles\\general.png", request.getFrom().getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            requestItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlItems.add(requestItem);
            pnlItems.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        int h = Globals.currentAccount.getRequests().size() * 42;
        pnlItems.setPreferredSize(new Dimension(600, h));


        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }

}
