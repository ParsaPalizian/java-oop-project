package com.company.gui.part.panel;

import com.company.dataadapter.PrivateMessageDataAdapter;
import com.company.global.Globals;
import com.company.gui.assets.ContactItem;
import com.company.gui.assets.LeftPrivateMessageItem;
import com.company.gui.assets.RightPrivateMessageItem;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.model.Account;
import com.company.model.PrivateMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class MessagePanel extends JPanel {
    JPanel pnlMessageAndTypeAndSend;
    JPanel pnlMessages;
    JScrollPane scrMessages;
    JPanel pnlTypeAndSend;
    JTextField txtType;
    JButton btnSend;
    JPanel pnlContacts;
    JScrollPane scrContacts;

    public boolean messagesRendered = true;
    public Account selectedContact = null;

    public MessagePanel() {


        this.setLayout(new BorderLayout());
        pnlMessageAndTypeAndSend = new JPanel();
        pnlMessages = new JPanel();
        pnlTypeAndSend = new JPanel();
        pnlMessageAndTypeAndSend.setLayout(new BorderLayout());
        pnlMessages.setLayout(new BoxLayout(pnlMessages, BoxLayout.Y_AXIS));
        pnlMessages.setBackground(Color.MAGENTA);



        scrMessages = new JScrollPane(pnlMessages);
        scrMessages.getVerticalScrollBar().setUnitIncrement(32);


        pnlTypeAndSend.setLayout(new BorderLayout());
        pnlMessageAndTypeAndSend.add(scrMessages, BorderLayout.CENTER);
        pnlMessageAndTypeAndSend.add(pnlTypeAndSend, BorderLayout.SOUTH);
        txtType = new JTextField();
        btnSend = new JButton("send");
        pnlTypeAndSend.add(txtType, BorderLayout.CENTER);
        pnlTypeAndSend.add(btnSend, BorderLayout.EAST);
        pnlContacts = new JPanel();
        pnlContacts.setLayout(new BoxLayout(pnlContacts, BoxLayout.Y_AXIS));
        pnlContacts.setBackground(GuiSetting.selectedTheme.getSecondaryColor());
        scrContacts = new JScrollPane(pnlContacts);
        scrContacts.getVerticalScrollBar().setUnitIncrement(32);


        this.add(scrContacts, BorderLayout.WEST);
        this.add(pnlMessageAndTypeAndSend, BorderLayout.CENTER);

        for (Account account : Globals.currentAccount.getContacts()) {
            ContactItem contactItem = new ContactItem(account, "assets\\profiles\\general.png", account.getUserName(), GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            contactItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlContacts.add(contactItem);
            pnlContacts.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        int h = Globals.currentAccount.getContacts().size() * 42;
        pnlContacts.setPreferredSize(new Dimension(150, h));



        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedContact != null && !txtType.getText().trim().isEmpty()) {
                        PrivateMessage privateMessage = new PrivateMessage();
                        privateMessage.setContent(txtType.getText().trim());
                        privateMessage.setSender(Globals.currentAccount);
                        privateMessage.setReceiver(selectedContact);
                        PrivateMessageDataAdapter adapter = new PrivateMessageDataAdapter();
                        privateMessage = adapter.insert(privateMessage);
                        Globals.currentAccount.getPrivateMessages().add(privateMessage);
                        Globals.currentPrivateMessages.add(privateMessage);
                        messagesRendered = false;
                        txtType.setText("");
                    }

                } catch (Exception ex) {
                }
            }
        });

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);


//        GuiGlobals.mainFrame.activeCenterPanel = this;


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (messagesRendered == false) {
                        MessagePanel.this.pnlMessages.removeAll();
                        for (PrivateMessage privateMessage : Globals.currentPrivateMessages) {
                            if (privateMessage.getSender().getId() == Globals.currentAccount.getId()) {
                                RightPrivateMessageItem rightMessageItem = new RightPrivateMessageItem(privateMessage);
                                pnlMessages.add(rightMessageItem);
                            } else {
                                LeftPrivateMessageItem leftPrivateMessageItem = new LeftPrivateMessageItem(privateMessage);
                                pnlMessages.add(leftPrivateMessageItem);
                            }
                        }

                        int h = Globals.currentPrivateMessages.size() * 100;
//                        System.out.println(h);
                        pnlMessages.setPreferredSize(new Dimension(600, h));
//                        System.out.println(scrMessages.getVerticalScrollBar().getMaximum());
//                        scrMessages.getVerticalScrollBar().setValue(scrMessages.getVerticalScrollBar().getMaximum());


                        messagesRendered = true;
                        MessagePanel.this.revalidate();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100); //call the run() method at 1 second intervals


    }
}
