package com.company.gui.part.panel;

import com.company.gui.assets.widget.ImageButton;
import com.company.model.Account;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {


    public Account account;

    public JPanel pnlAvatar;
    public JPanel pnlDetails;
    public ImageButton avatar;

    public HomePanel(Account account) {
        super();
        this.account = account;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        pnlAvatar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(pnlAvatar);
        if (FileUtility.isAvatarExists(account.getAvatar())) {
            avatar = new ImageButton("assets\\profiles\\" + account.getAvatar(), new Dimension(256, 256));
        } else {
            avatar = new ImageButton("assets\\profiles\\general.png", new Dimension(128, 128));
        }
        pnlAvatar.add(avatar);
        pnlDetails = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(pnlDetails);
        JPanel pnlPosts = new JPanel();
        pnlPosts.setLayout(new BoxLayout(pnlPosts, BoxLayout.X_AXIS));



    }


}
