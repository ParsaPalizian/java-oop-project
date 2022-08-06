package com.company.gui.part.panel;

import com.company.Result;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.enums.MainMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyPanel extends JPanel {


    public EmptyPanel() {


        this.setLayout(null);

        this.setBackground(GuiSetting.selectedTheme.getPrimaryColor());


        Insets insets = this.getInsets();
        this.setBounds(400, 400, 300 + insets.left + insets.right, 400);
        this.setVisible(true);



    }
}
