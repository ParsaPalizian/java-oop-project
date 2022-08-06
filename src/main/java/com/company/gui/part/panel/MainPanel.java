package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    JPanel pnlCommands;
    JButton btnHome;
    JButton btnTimeline;
    JButton btnExplorer;
    JButton btnSearch;
    JButton btnEditProfile;
    JButton btnLogout;
    JPanel pnlRight;

    public MainPanel(){

        this.setLayout(new BorderLayout());
        pnlCommands=new JPanel();
        pnlCommands.setLayout(new BoxLayout(pnlCommands,BoxLayout.Y_AXIS));

        btnHome=new JButton("Home");
        btnTimeline=new JButton("Timeline");
        btnExplorer=new JButton("Explorer");
        btnSearch=new JButton("Search");
        btnEditProfile=new JButton("EditProfile");
        btnLogout=new JButton("Logout");

        pnlCommands.add(btnHome);
        pnlCommands.add(btnTimeline);
        pnlCommands.add(btnExplorer);
        pnlCommands.add(btnSearch);
        pnlCommands.add(btnEditProfile);
        pnlCommands.add(btnLogout);

        pnlCommands.setBackground(Color.BLACK);

        pnlRight=new JPanel();
        pnlRight.setLayout(null);
        pnlRight.setBackground(Color.GREEN);

        this.add(pnlCommands,BorderLayout.WEST);
        this.add(pnlRight,BorderLayout.CENTER);


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);


    }
}
