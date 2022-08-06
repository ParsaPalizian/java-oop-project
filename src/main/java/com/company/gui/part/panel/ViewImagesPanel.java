package com.company.gui.part.panel;

import com.company.gui.global.GuiGlobals;

import javax.swing.*;

public class ViewImagesPanel extends JPanel {

    JButton btnViewProfilePicture;
    JButton btnAddNewProfilePicture;

    public ViewImagesPanel(){

    btnViewProfilePicture =new JButton("View Profile Picture");
    btnAddNewProfilePicture =new JButton("Add New Profile Picture");

    this.setLayout(null);
    this.add(btnViewProfilePicture);
    this.add(btnAddNewProfilePicture);

        btnViewProfilePicture.setBounds(125 + this.getInsets().left, 50 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnAddNewProfilePicture.setBounds(125 + this.getInsets().left, 100 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
