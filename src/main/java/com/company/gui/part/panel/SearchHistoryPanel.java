package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class SearchHistoryPanel extends JPanel {
    JPanel pnlAccounts;
    JButton btnAccountsProfilePicture;
    JLabel lblAccountsName;
    JButton btnDelete;

    public SearchHistoryPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        for (int i =1 ; i <= 10; i++) {
            pnlAccounts =new JPanel();
            pnlAccounts.setLayout(new FlowLayout());


            btnAccountsProfilePicture =new JButton("Profile Picture");
            lblAccountsName =new JLabel("Name");
            btnDelete =new JButton("Delete");


            pnlAccounts.add(btnAccountsProfilePicture);
            pnlAccounts.add(lblAccountsName);
            pnlAccounts.add(btnDelete);
            this.add(pnlAccounts);

        }






        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
