package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockItem extends JPanel {

    JButton btn;
    JLabel lbl;
    IconButton btnUnblock;

    Block block;

    public BlockItem(Block block, String profile, String text, Color back, Color textColor) {
        super();
        this.block = block;
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

        btnUnblock = new IconButton(
                GuiSetting.selectedIconSet.action.unblock,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        btnUnblock.setFont(new Font("Arial", 0, 24));

        btnUnblock.setBorder(BorderFactory.createEmptyBorder());
        btnUnblock.setContentAreaFilled(false);
        btnUnblock.setRolloverEnabled(true);
        btnUnblock.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnUnblock.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnUnblock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Account.unBlock(block);
                    Globals.currentAccount.getBlocklist().remove(block);
                    GuiGlobals.mainFrame.centerPanel.rendered = false;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.add(btnUnblock);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
    }

}
