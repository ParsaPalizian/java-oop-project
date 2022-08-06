package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class GroupMembersPanel extends JPanel {

    JPanel pnlMembers;
    JPanel pnlItems;
    JButton btnMembersProfilePicture;
    JLabel lblMembersName;
    JButton btnKick;
    JButton btnShow;

    public GroupMembersPanel(){

        this.setLayout(new BorderLayout());


        pnlMembers =new JPanel();
        pnlMembers.setLayout(new BoxLayout(pnlMembers,BoxLayout.Y_AXIS));


        for (int i=0;i<10;i++) {
            pnlItems=new JPanel();
            pnlItems.setLayout(new FlowLayout());
            btnMembersProfilePicture = new JButton("Profile Picture");
            lblMembersName = new JLabel("Name");
            btnKick = new JButton("Kick");
            btnShow = new JButton("Show");


            pnlItems.add(btnMembersProfilePicture);
            pnlItems.add(lblMembersName);
            pnlItems.add(btnKick);

            pnlMembers.add(pnlItems);
        }


        this.add(pnlMembers,BorderLayout.CENTER);
        this.add(btnShow,BorderLayout.SOUTH);


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
