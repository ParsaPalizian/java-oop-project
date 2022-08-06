package com.company.gui.assets;

import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;

import javax.swing.*;
import java.awt.*;

public class RecommendItem extends JPanel{
    JButton btn;
    JLabel lbl;
    IconButton request;

    public RecommendItem(String profile, String text, Color back , Color textColor) {
        super();
        this.setLayout(new BoxLayout(this , BoxLayout.X_AXIS));
        this.setBackground(back);
        this.setPreferredSize(new Dimension(400,30));
        btn = new JButton(new ImageIcon(profile));
        btn.setFont(new Font("Arial" , 0,24));
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
        lbl.setFont(new Font("Arial" , 0,24));
        lbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        request=new IconButton(
                GuiSetting.selectedIconSet.action.request,
                36,
                GuiSetting.selectedTheme.getPrimaryColor(),
                GuiSetting.selectedTheme.getSecondaryVariantColor()
        );
        request.setFont(new Font("Arial" , 0,24));

        request.setBorder(BorderFactory.createEmptyBorder());
        request.setContentAreaFilled(false);
        request.setRolloverEnabled(true);
        request.setAlignmentX(Component.LEFT_ALIGNMENT);
        request.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(request);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
    }
}
