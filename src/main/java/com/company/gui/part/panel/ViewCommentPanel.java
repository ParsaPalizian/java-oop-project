package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class ViewCommentPanel extends JPanel {

    JPanel pnlComments;
    JPanel pnlUtilities;
    JPanel pnlReactReply;
    JPanel pnlEditDelete;

    JButton btnCommenterProfilePicture;
    JLabel lblCommenterName;
    JButton btnReact;
    JButton btnReply;
    JButton btnEdit;
    JButton btnDelete;

    public ViewCommentPanel(){

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        for (int i=0;i<10;i++) {
            pnlComments = new JPanel();
            pnlUtilities = new JPanel();
            pnlReactReply = new JPanel();
            pnlEditDelete = new JPanel();


            pnlComments.setLayout(new FlowLayout());
            pnlUtilities.setLayout(new BoxLayout(pnlUtilities, BoxLayout.Y_AXIS));
            pnlReactReply.setLayout(new BoxLayout(pnlReactReply, BoxLayout.X_AXIS));
            pnlEditDelete.setLayout(new BoxLayout(pnlEditDelete, BoxLayout.X_AXIS));

            btnCommenterProfilePicture = new JButton("Profile Picture");
            lblCommenterName = new JLabel("CommenterName");
            btnReact = new JButton("React");
            btnReply = new JButton("Reply");
            btnEdit = new JButton("Edit");
            btnDelete = new JButton("Delete");

            pnlEditDelete.add(btnEdit);
            pnlEditDelete.add(btnDelete);
            pnlReactReply.add(btnReact);
            pnlReactReply.add(btnReply);
            pnlUtilities.add(pnlReactReply);
            pnlUtilities.add(pnlEditDelete);

            pnlComments.add(btnCommenterProfilePicture);
            pnlComments.add(lblCommenterName);
            pnlComments.add(pnlUtilities);
            this.add(pnlComments);
        }


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
