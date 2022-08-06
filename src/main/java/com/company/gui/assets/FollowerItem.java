package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.Block;
import com.company.model.Follow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FollowerItem extends JPanel {

    JButton btn;
    JLabel lbl;
    IconButton btnFollowBack;
    IconButton btnBlock;

    Follow follow;

    public FollowerItem(Follow follow, String profile, String text, Color back, Color textColor) {
        super();
        this.follow = follow;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(back);
        this.setPreferredSize(new Dimension(400, 30));
        btn = new JButton(new ImageIcon(profile));
        btn.setFont(new Font("Arial", 0, 24));
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(btn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        lbl = new JLabel(text);
        lbl.setForeground(textColor);
        lbl.setBackground(Color.CYAN);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setFont(new Font("Arial", 0, 24));
        lbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        btnFollowBack = new IconButton(
                GuiSetting.selectedIconSet.action.followBack,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );


        btnFollowBack.setFont(new Font("Arial", 0, 24));
        btnFollowBack.setBorder(BorderFactory.createEmptyBorder());
        btnFollowBack.setContentAreaFilled(false);
        btnFollowBack.setRolloverEnabled(true);
        btnFollowBack.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnFollowBack.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnFollowBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO FOLLOW BACK CODE HERE
                boolean shouldBeFollow = true;
                for (Follow follow1 : Globals.currentAccount.getFollowings()) {
                    if (follow1.getAccount().equals(follow.getAccount())) {
                        shouldBeFollow = false;
                    }
                }
                if (shouldBeFollow) {
                    try {
                        Follow f =  Follow.follow(Globals.currentAccount, follow.getAccount()).getData();
                        f.setAccount(follow.getAccount());
                        Globals.currentAccount.getFollowings().add(f);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }


                GuiGlobals.mainFrame.centerPanel.rendered = false;
            }
        });


        boolean showFollowBack = true;
        for (Follow follow1 : Globals.currentAccount.getFollowings()) {
            if (follow1.getAccount().equals(follow.getAccount())) {
                showFollowBack = false;
                break;
            }
        }

        btnFollowBack.setVisible(showFollowBack);


        this.add(btnFollowBack);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        btnBlock = new IconButton(
                GuiSetting.selectedIconSet.action.block,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnBlock.setFont(new Font("Arial", 0, 24));

        btnBlock.setBorder(BorderFactory.createEmptyBorder());
        btnBlock.setContentAreaFilled(false);
        btnBlock.setRolloverEnabled(true);
        btnBlock.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnBlock.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnBlock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Account.block(Globals.currentAccount, follow.getAccount());
                    Globals.currentAccount.getFollowers().remove(follow);
                    GuiGlobals.mainFrame.centerPanel.rendered = false;

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(btnBlock);
        this.add(Box.createRigidArea(new Dimension(10, 0)));


    }
}
