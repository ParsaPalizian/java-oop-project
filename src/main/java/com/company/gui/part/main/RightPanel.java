package com.company.gui.part.main;

import com.company.global.Globals;
import com.company.gui.assets.widget.IconButton;
import com.company.gui.configuration.GuiSetting;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * Created by kami on 7/29/2022.
 */
public class RightPanel extends JPanel {

    IconButton btnMenu;
    IconButton btnProfile;

    public boolean themeRendered = true;

    public RightPanel() {

        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(64, 64));
        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
        btnProfile = new IconButton(GuiSetting.selectedIconSet.main.defaultAvatar, 64, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        this.add(btnProfile);

        btnMenu = new IconButton(GuiSetting.selectedIconSet.main.hamburgerMenu, 64, GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
        this.add(btnMenu);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (!themeRendered) {

                    RightPanel.this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());
                    btnProfile.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    btnMenu.changeColor(GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getSecondaryVariantColor());
                    themeRendered = true;
                }

            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100);







    }

}
