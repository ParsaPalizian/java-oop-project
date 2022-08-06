package com.company.gui.part.panel;

import com.company.gui.global.GuiGlobals;

import javax.swing.*;

public class ForwardToContactOrGroupPanel extends JPanel {

    JButton btnContact;
    JButton btnGroup;

    public ForwardToContactOrGroupPanel(){

        btnContact=new JButton("Contact");
        btnGroup=new JButton("Group");


        this.setLayout(null);
        this.add(btnContact);
        this.add(btnGroup);

        btnContact.setBounds(125 + this.getInsets().left, 50 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnGroup.setBounds(125 + this.getInsets().left, 100 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
