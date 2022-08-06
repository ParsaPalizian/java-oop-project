package com.company.gui.part.panel;

import com.company.gui.global.GuiGlobals;

import javax.swing.*;

public class PrimePagePanel extends JPanel{

    JButton btnLogin;
    JLabel lblNotice;
    JButton btnSignup;

    public PrimePagePanel(){
        btnLogin=new JButton("Login");
        lblNotice =new JLabel("Dont have an Account?");
        btnSignup=new JButton("Signup");

        this.setLayout(null);
        this.add(btnLogin);
        this.add(lblNotice);
        this.add(btnSignup);


        btnLogin.setBounds(25 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblNotice.setBounds(25 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnSignup.setBounds(25 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);


        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
