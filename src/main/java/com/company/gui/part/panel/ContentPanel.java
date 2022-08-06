package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    JPanel pnlOthersContent;
    JPanel pnlMyContent;
    JButton btnMembersProfilePicture;
    JLabel lblMembersName;

    public ContentPanel() {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        for (int i=0;i<10;i++) {
            if (i%2==0) {
                pnlOthersContent = new JPanel();
                pnlOthersContent.setLayout(new FlowLayout());


                btnMembersProfilePicture = new JButton("Profile Picture");
                lblMembersName = new JLabel("Members Name");


                pnlOthersContent.add(btnMembersProfilePicture);
                pnlOthersContent.add(lblMembersName);


                this.add(pnlOthersContent);
            }else{
                pnlMyContent = new JPanel();
                pnlMyContent.setLayout(new FlowLayout(FlowLayout.RIGHT));


                btnMembersProfilePicture = new JButton("Profile Picture");
                lblMembersName = new JLabel("Members Name");


                pnlMyContent.add(btnMembersProfilePicture);
                pnlMyContent.add(lblMembersName);


                this.add(pnlOthersContent);
            }
        }


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }


}
