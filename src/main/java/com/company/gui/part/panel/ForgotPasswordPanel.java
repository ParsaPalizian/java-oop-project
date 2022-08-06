package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.utility.DataUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ForgotPasswordPanel extends JPanel {

    JLabel lblUsername;
    JTextField txtUsername;
    JLabel lblUsernameError;

    JLabel lblForgetPasswordQuestion;

    JLabel lblForgetPasswordAnswer;
    JTextField txtForgetPasswordAnswer;
    JLabel lblForgetPasswordAnswerError;

    JLabel lblPassword;
    JTextField txtPassword;
    JLabel lblPasswordError;

    JLabel lblRepeatedPassword;
    JTextField txtRepeatedPassword;
    JLabel lblRepeatedPasswordError;

    JButton btnCheckAnswer;
    JButton btnChangePassword;

    public ForgotPasswordPanel() {
        lblUsername = new JLabel("Username");
        txtUsername = new JTextField();
        lblUsernameError = new JLabel("");
        lblUsernameError.setForeground(Color.red);

        lblForgetPasswordQuestion = new JLabel("Who was your first school teacher?");

        lblForgetPasswordAnswer = new JLabel("Answer");
        txtForgetPasswordAnswer = new JTextField();
        lblForgetPasswordAnswerError = new JLabel("");
        lblForgetPasswordAnswerError.setForeground(Color.red);

        lblPassword = new JLabel("Password:");
        txtPassword = new JTextField();
        lblPasswordError = new JLabel("");
        lblPasswordError.setForeground(Color.RED);
        lblPassword.setVisible(false);
        txtPassword.setVisible(false);
        lblPasswordError.setVisible(false);

        lblRepeatedPassword = new JLabel("Repeated password:");
        txtRepeatedPassword = new JTextField();
        lblRepeatedPasswordError = new JLabel("");
        lblRepeatedPasswordError.setForeground(Color.RED);
        lblRepeatedPassword.setVisible(false);
        txtRepeatedPassword.setVisible(false);
        lblRepeatedPasswordError.setVisible(false);

        btnCheckAnswer = new JButton("Check Answer");
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setVisible(false);

        this.setLayout(null);

        this.add(lblUsername);
        this.add(txtUsername);
        this.add(lblUsernameError);

        this.add(lblForgetPasswordQuestion);

        this.add(lblForgetPasswordAnswer);
        this.add(txtForgetPasswordAnswer);
        this.add(lblForgetPasswordAnswerError);

        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblPasswordError);

        this.add(lblRepeatedPassword);
        this.add(txtRepeatedPassword);
        this.add(lblRepeatedPasswordError);

        this.add(btnCheckAnswer);
        this.add(btnChangePassword);

        lblUsername.setBounds(25 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtUsername.setBounds(200 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblUsernameError.setBounds(375 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH * 3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblForgetPasswordQuestion.setBounds(25 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblForgetPasswordAnswer.setBounds(25 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtForgetPasswordAnswer.setBounds(200 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblForgetPasswordAnswerError.setBounds(375 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH * 3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblPassword.setBounds(25 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtPassword.setBounds(200 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblPasswordError.setBounds(375 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH * 3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblRepeatedPassword.setBounds(25 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtRepeatedPassword.setBounds(200 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblRepeatedPasswordError.setBounds(375 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH * 3, GuiGlobals.TEXT_FIELD_HEIGHT);


        btnCheckAnswer.setBounds(100 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnChangePassword.setBounds(100 + this.getInsets().left, 185 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnCheckAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean toCheck = true;

                try {

                    if (txtUsername.getText().trim().isEmpty()) {
                        toCheck = false;
                        lblUsernameError.setText("Enter Your Username");
                    } else if (!DataUtility.isStringOnlyAlphabetOrNumber(txtUsername.getText().trim())) {
                        toCheck = false;
                        lblUsernameError.setText("Your FirstName Format Is Invalid.\nYou Can Only Use a-z A-Z 0-9 _");
                    } else if (!Account.isUsernameExists(txtUsername.getText().trim())) {
                        toCheck = false;
                        lblUsernameError.setText("Username does not Exist");
                    }else if(Account.findBaseOnUserName(txtUsername.getText().trim()).getData() == null){
                        toCheck=false;
                        lblForgetPasswordAnswerError.setText("There is No Account with This UserName");
                    }else {
                        Globals.forgetAccount = (Account) Account.findBaseOnUserName(txtUsername.getText().trim()).getData();
                        lblUsernameError.setText("");
                    }
                } catch (Exception ex) {
                }

                try {
                    if (txtForgetPasswordAnswer.getText().trim().isEmpty()) {
                        toCheck = false;
                        lblForgetPasswordAnswerError.setText("Answer Question");
                    } else if (!DataUtility.isStringOnlyAlphabetOrNumber(txtForgetPasswordAnswer.getText().trim())) {
                        toCheck = false;
                        lblForgetPasswordAnswerError.setText("Your FirstName Format Is Invalid.\nYou Can Only Use a-z A-Z 0-9 _");
                    }else if (!Globals.forgetAccount.getForgetPasswordAnswer().equals(txtForgetPasswordAnswer.getText().trim())){
                        toCheck=false;
                        lblForgetPasswordAnswerError.setText("Wrong Answer");
                    }else {
                        lblForgetPasswordAnswerError.setText("");
                    }

                } catch (Exception ex) {
                }

                if (toCheck) {

                    lblPassword.setVisible(true);
                    txtPassword.setVisible(true);
                    lblPasswordError.setVisible(true);
                    lblRepeatedPassword.setVisible(true);
                    txtRepeatedPassword.setVisible(true);
                    lblRepeatedPasswordError.setVisible(true);
                    btnChangePassword.setVisible(true);

                    btnChangePassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            boolean toChange = true;

                            if (txtPassword.getText().trim().isEmpty()) {
                                toChange = false;
                                lblPasswordError.setText("Enter Your Password");
                            } else if (txtPassword.getText().trim().length() < 6) {
                                toChange = false;
                                lblPasswordError.setText("Your Password Must Have At Least 6 characters");
                            } else if (txtPassword.getText().trim().length() > 10) {
                                toChange = false;
                                lblPasswordError.setText("Your Password Must Have At Last 10 characters");
                            } else {
                                lblPasswordError.setText("");
                            }

                            if (txtRepeatedPassword.getText().trim().isEmpty()) {
                                toChange = false;
                                lblRepeatedPasswordError.setText("Repeat Your Password");
                            } else if (!txtPassword.getText().trim().equals(txtRepeatedPassword.getText().trim())) {
                                toChange = false;
                                lblRepeatedPasswordError.setText("Password not matched");
                            } else {
                                lblRepeatedPasswordError.setText("");
                            }


                            if (toChange) {
                                Globals.forgetAccount.setPassword(txtPassword.getText().trim());
                                try {
                                    Account.updatePassword(Globals.forgetAccount);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }


                        }
                    });
                }
            }
        });

        this.setBounds(100, 100, 500 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
