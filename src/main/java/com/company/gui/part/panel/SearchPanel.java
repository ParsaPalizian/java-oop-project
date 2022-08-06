package com.company.gui.part.panel;

import com.company.gui.global.GuiGlobals;

import javax.swing.*;

public class SearchPanel extends JPanel {

    JButton btnSearchHistory;
    JButton btnSearchUserName;
    JButton btnClearSearchHistory;

    public SearchPanel(){

        btnSearchHistory =new JButton("Search History");
        btnSearchUserName =new JButton("Search UserName");
        btnClearSearchHistory=new JButton("Clear Search History");

        this.setLayout(null);
        this.add(btnSearchHistory);
        this.add(btnSearchUserName);
        this.add(btnClearSearchHistory);

        btnSearchHistory.setBounds(125 + this.getInsets().left, 50 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSearchUserName.setBounds(125 + this.getInsets().left, 100 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnClearSearchHistory.setBounds(125 + this.getInsets().left, 150 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
