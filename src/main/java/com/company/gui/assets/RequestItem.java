package com.company.gui.assets;

import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;

import javax.swing.*;
import java.awt.*;

public class RequestItem extends JPanel{
    JButton btn;
    JLabel lbl;
    IconButton accept;
    IconButton reject;

    public RequestItem(String profile, String text, Color back, Color textColor) {
        super();
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

        accept = new IconButton(
                GuiSetting.selectedIconSet.action.accept,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        accept.setFont(new Font("Arial", 0, 24));

        accept.setBorder(BorderFactory.createEmptyBorder());
        accept.setContentAreaFilled(false);
        accept.setRolloverEnabled(true);
        accept.setAlignmentX(Component.LEFT_ALIGNMENT);
        accept.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(accept);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        reject = new IconButton(
                GuiSetting.selectedIconSet.action.reject,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        reject.setFont(new Font("Arial", 0, 24));

        reject.setBorder(BorderFactory.createEmptyBorder());
        reject.setContentAreaFilled(false);
        reject.setRolloverEnabled(true);
        reject.setAlignmentX(Component.LEFT_ALIGNMENT);
        reject.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(reject);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
    }
}
