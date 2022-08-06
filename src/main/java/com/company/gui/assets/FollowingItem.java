package com.company.gui.assets;

import com.company.Result;
import com.company.dataadapter.FollowDataAdapter;
import com.company.global.Globals;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.Follow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FollowingItem extends JPanel {
    JButton btn;
    JLabel lbl;
    IconButton unfollow;

    Follow follow;

    public FollowingItem(Follow follow, String profile, String text, Color back, Color textColor) {
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

        unfollow = new IconButton(
                GuiSetting.selectedIconSet.action.unfollow,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );

        unfollow.setToolTipText("unfollow");
        unfollow.setFont(new Font("Arial", 0, 24));

        unfollow.setBorder(BorderFactory.createEmptyBorder());
        unfollow.setContentAreaFilled(false);
        unfollow.setRolloverEnabled(true);
        unfollow.setAlignmentX(Component.LEFT_ALIGNMENT);
        unfollow.setAlignmentY(Component.CENTER_ALIGNMENT);
        unfollow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Account.unFollow(follow);
                    Globals.currentAccount.getFollowings().remove(follow);
                    GuiGlobals.mainFrame.centerPanel.rendered = false;

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(unfollow);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
    }
}
