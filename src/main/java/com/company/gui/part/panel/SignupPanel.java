package com.company.gui.part.panel;

import com.company.dataadapter.AccountDataAdapter;
import com.company.gui.enums.CenterMenuSituation;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.utility.DataUtility;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class SignupPanel extends JPanel {

    JLabel lblFirstName;
    JTextField txtFirstName;
    JLabel lblFirstNameError;

    JLabel lblLastName;
    JTextField txtLastName;
    JLabel lblLastNameError;

    JLabel lblUsername;
    JTextField txtUserName;
    JLabel lblUserNameError;

    JLabel lblPassword;
    JTextField txtPassword;
    JLabel lblPasswordError;

    JLabel lblRepeatedPassword;
    JTextField txtRepeatedPassword;
    JLabel lblRepeatedPasswordError;

    JLabel lblEmail;
    JTextField txtEmail;
    JLabel lblEmailError;

    JLabel lblForgetPasswordQuestion;
    JTextField txtForgetPasswordAnswer;
    JLabel lblForgetPasswordAnswerError;

    JLabel lblAvatar;
    JTextField txtAvatar;
    JButton btnAvatar;

    JButton btnFinish;


    public SignupPanel() {

        lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField();
        lblFirstNameError = new JLabel("");
        lblFirstNameError.setForeground(Color.RED);

        lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField();
        lblLastNameError = new JLabel("");
        lblLastNameError.setForeground(Color.RED);

        lblUsername = new JLabel("Username:");
        txtUserName = new JTextField();
        lblUserNameError = new JLabel("");
        lblUserNameError.setForeground(Color.RED);

        lblPassword = new JLabel("Password:");
        txtPassword = new JTextField();
        lblPasswordError = new JLabel("");
        lblPasswordError.setForeground(Color.RED);

        lblRepeatedPassword = new JLabel("Repeated password:");
        txtRepeatedPassword = new JTextField();
        lblRepeatedPasswordError = new JLabel("");
        lblRepeatedPasswordError.setForeground(Color.RED);

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        lblEmailError = new JLabel("");
        lblEmailError.setForeground(Color.RED);

        lblForgetPasswordQuestion = new JLabel("Who Was Your First School Teacher ?");
        txtForgetPasswordAnswer = new JTextField();
        lblForgetPasswordAnswerError = new JLabel("");
        lblForgetPasswordAnswerError.setForeground(Color.RED);

        lblAvatar=new JLabel("Avatar");
        txtAvatar=new JTextField();
        btnAvatar=new JButton("Choose");

        btnFinish = new JButton("Finish");


        this.setLayout(null);
        this.add(lblFirstName);
        this.add(txtFirstName);
        this.add(lblFirstNameError);

        this.add(lblLastName);
        this.add(txtLastName);
        this.add(lblLastNameError);

        this.add(lblUsername);
        this.add(txtUserName);
        this.add(lblUserNameError);

        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblPasswordError);

        this.add(lblRepeatedPassword);
        this.add(txtRepeatedPassword);
        this.add(lblRepeatedPasswordError);

        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblEmailError);

        this.add(lblForgetPasswordQuestion);
        this.add(txtForgetPasswordAnswer);
        this.add(lblForgetPasswordAnswerError);

        this.add(lblAvatar);
        this.add(txtAvatar);
        this.add(btnAvatar);

        this.add(btnFinish);

        lblFirstName.setBounds(25 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtFirstName.setBounds(200 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblFirstNameError.setBounds(410 + this.getInsets().left, 5 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblLastName.setBounds(25 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtLastName.setBounds(200 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblLastNameError.setBounds(410 + this.getInsets().left, 35 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblUsername.setBounds(25 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtUserName.setBounds(200 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblUserNameError.setBounds(410 + this.getInsets().left, 65 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblPassword.setBounds(25 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtPassword.setBounds(200 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblPasswordError.setBounds(410 + this.getInsets().left, 95 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblRepeatedPassword.setBounds(25 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtRepeatedPassword.setBounds(200 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblRepeatedPasswordError.setBounds(410 + this.getInsets().left, 125 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblEmail.setBounds(25 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtEmail.setBounds(200 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblEmailError.setBounds(410 + this.getInsets().left, 155 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblForgetPasswordQuestion.setBounds(25 + this.getInsets().left, 185 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtForgetPasswordAnswer.setBounds(200 + this.getInsets().left, 185 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        lblForgetPasswordAnswerError.setBounds(410 + this.getInsets().left, 185 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH*3, GuiGlobals.TEXT_FIELD_HEIGHT);

        lblAvatar.setBounds(25 + this.getInsets().left, 215 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        txtAvatar.setBounds(200 + this.getInsets().left, 215 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);
        btnAvatar.setBounds(410 + this.getInsets().left, 215 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(SignupPanel.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    txtAvatar.setText(selectedFile.getAbsolutePath());
                }

            }
        });



        btnFinish.setBounds(25 + this.getInsets().left, 400 + this.getInsets().top, GuiGlobals.TEXT_FIELD_WIDTH, GuiGlobals.TEXT_FIELD_HEIGHT);

        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean toSave = true;

                if (txtFirstName.getText().trim().isEmpty()) {
                    toSave = false;
                    lblFirstNameError.setText("Enter Your FirstName");
                } else if (!DataUtility.isStringCorrectFirstNameOrLastName(txtFirstName.getText().trim())) {
                    toSave = false;
                    lblFirstNameError.setText("Your FirstName Format Is Invalid.\nYou Can Only Use a-z A-Z");
                } else {
                    lblFirstNameError.setText("");
                }

                if (txtLastName.getText().trim().isEmpty()) {
                    toSave = false;
                    lblLastNameError.setText("Enter Your LastName");
                } else if (!DataUtility.isStringCorrectFirstNameOrLastName(txtLastName.getText().trim())) {
                    toSave = false;
                    lblLastNameError.setText("Your LastName Format Is Invalid.\nYou Can Only Use a-z A-Z");
                } else {
                    lblLastNameError.setText("");
                }

                if (txtUserName.getText().trim().isEmpty()) {
                    toSave = false;
                    lblUserNameError.setText("Enter Your Username");
                } else if (!DataUtility.isStringOnlyAlphabetOrNumber(txtUserName.getText().trim())) {
                    toSave = false;
                    lblUserNameError.setText("Your Username Format Is Invalid.\nYou Can Only Use a-z A-Z 0-9 _");
                } else {
                    lblUserNameError.setText("");
                }

                if (txtPassword.getText().trim().isEmpty()) {
                    toSave = false;
                    lblPasswordError.setText("Enter Your Password");
                } else if (txtPassword.getText().trim().length()<6) {
                    toSave = false;
                    lblPasswordError.setText("Your Password Must Have At Least 6 characters");
                }else if(txtPassword.getText().trim().length()>10){
                    toSave = false;
                    lblPasswordError.setText("Your Password Must Have At Last 10 characters");
                }else {
                    lblPasswordError.setText("");
                }

                if (txtRepeatedPassword.getText().trim().isEmpty()) {
                    toSave = false;
                    lblRepeatedPasswordError.setText("Repeat Your Password");
                } else if (!txtPassword.getText().trim().equals(txtRepeatedPassword.getText().trim())) {
                    toSave = false;
                    lblRepeatedPasswordError.setText("Password not matched");
                } else {
                    lblRepeatedPasswordError.setText("");
                }

                try {

                    if (txtEmail.getText().trim().isEmpty()) {
                        toSave = false;
                        lblEmailError.setText("Enter Your Email");
                    } else if (!DataUtility.isStringCorrectEmail(txtEmail.getText().trim())) {
                        toSave = false;
                        lblEmailError.setText("Your Email Format Is Invalid.\nYou Can Only Use a-z A-Z 0-9 _ @ .");
                    } else if (!txtEmail.getText().trim().contains("@")) {
                        toSave = false;
                        lblEmailError.setText("Email Format Is Invalid");
                    } else if (Account.isEmailExists(txtEmail.getText().trim())) {
                        toSave = false;
                        lblEmailError.setText("Email is already exists");
                    } else {
                        lblEmailError.setText("");
                    }
                } catch (Exception ex) {
                }

                if (txtForgetPasswordAnswer.getText().trim().isEmpty()) {
                    toSave = false;
                    lblForgetPasswordAnswerError.setText("Answer Question");
                } else if (!DataUtility.isStringCorrectFirstNameOrLastName(txtForgetPasswordAnswer.getText().trim())) {
                    toSave = false;
                    lblForgetPasswordAnswerError.setText("Your Answer Format Is Invalid.\nYou Can Only Use a-z A-Z");
                } else {
                    lblForgetPasswordAnswerError.setText("");
                }


                if (toSave) {
                    AccountDataAdapter accountDataAdapter = null;
                    try {
                        accountDataAdapter = new AccountDataAdapter();
                        accountDataAdapter.insert(
                                new Account(
                                        txtFirstName.getText().trim(),
                                        txtLastName.getText().trim(),
                                        txtUserName.getText().trim(),
                                        txtEmail.getText().trim(),
                                        txtPassword.getText().trim(),
                                        "Who Was Your First School Teacher",
                                        txtForgetPasswordAnswer.getText().trim(),
                                        FileUtility.copyAvatarImage(txtAvatar.getText().trim())
                                )
                        );

                        GuiGlobals.mainFrame.centerPanel.rendered = false;
                        GuiGlobals.mainFrame.centerPanel.currentSituationCenterPanel = CenterMenuSituation.NONE;


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
//                return null;
            }
        });

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);


    }
}
