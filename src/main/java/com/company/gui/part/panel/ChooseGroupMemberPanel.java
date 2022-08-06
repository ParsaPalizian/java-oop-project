package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class ChooseGroupMemberPanel extends JPanel {

    JPanel pnlContacts;
    JPanel pnlItems;
    JButton btnContactsProfilePicture;
    JLabel lblContactsName;
    JButton btnAdd;
    JButton btnRemove;
    JButton btnShow;

    public ChooseGroupMemberPanel(){

        this.setLayout(new BorderLayout());


        pnlContacts=new JPanel();
        pnlContacts.setLayout(new BoxLayout(  pnlContacts,BoxLayout.Y_AXIS));


        for (int i=0;i<10;i++) {
            pnlItems=new JPanel();
            pnlItems.setLayout(new FlowLayout());
            btnContactsProfilePicture = new JButton("Profile Picture");
            lblContactsName = new JLabel("Name");
            btnAdd = new JButton("Add");
            btnRemove = new JButton("Remove");
            btnShow = new JButton("Show");


            pnlItems.add(btnContactsProfilePicture);
            pnlItems.add(lblContactsName);
            pnlItems.add(btnAdd);
            pnlItems.add(btnRemove);

            pnlContacts.add(pnlItems);
        }

        this.add(pnlContacts,BorderLayout.CENTER);
        this.add(btnShow,BorderLayout.SOUTH);


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
