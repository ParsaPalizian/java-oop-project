package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class GroupListPanel extends JPanel {

    JPanel pnlMembers;
    JButton btnMembersProfilePicture;
    JLabel lblMembersName;

    public GroupListPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        for (int i =1 ; i <= 10; i++) {
            pnlMembers=new JPanel();
            pnlMembers.setLayout(new FlowLayout());


            btnMembersProfilePicture=new JButton("ProfilePicture");
            lblMembersName=new JLabel("Name");


            pnlMembers.add(btnMembersProfilePicture);
            pnlMembers.add(lblMembersName);
            this.add(pnlMembers);
        }


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
