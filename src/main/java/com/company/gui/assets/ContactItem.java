package com.company.gui.assets;

import com.company.global.Globals;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.MainFrame;
import com.company.gui.part.panel.MessagePanel;
import com.company.model.Account;
import com.company.model.PrivateMessage;
import org.kordamp.ikonli.Ikon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContactItem extends JPanel {

    JButton btn;
    JLabel lbl;
    Account account;

    public ContactItem(Account account, String profile, String text, Color back, Color textColor) {
        super();

        this.account = account;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(back);
        btn = new JButton(new ImageIcon(profile));
        btn.setFont(new Font("Arial", 0, 24));
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setAlignmentY(Component.CENTER_ALIGNMENT);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(account.getUserName());
                if (GuiGlobals.mainFrame.activeCenterPanel instanceof MessagePanel) {
                    Globals.currentPrivateMessages.clear();
                    for (PrivateMessage privateMessage : Globals.loggedInAccount.getPrivateMessages()) {
                        if (privateMessage.getReceiver().getId() == account.getId() || privateMessage.getSender().getId() == account.getId()) {
                            Globals.currentPrivateMessages.add(privateMessage);
                        }
                    }
                    ((MessagePanel) GuiGlobals.mainFrame.activeCenterPanel).messagesRendered = false;
                    ((MessagePanel) GuiGlobals.mainFrame.activeCenterPanel).selectedContact = account;


                }
            }
        });

        this.add(btn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));

        lbl = new JLabel(text);
        lbl.setForeground(textColor);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setFont(new Font("Arial", 0, 24));
        lbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(10, 0)));


    }
}
