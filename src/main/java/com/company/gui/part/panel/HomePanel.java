package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.widget.ImageButton;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.main.TopPanel;
import com.company.model.Account;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HomePanel extends JPanel {


    public Account account;

    public JPanel pnlTop;
    public JPanel pnlAvatar;
    public JPanel pnlDetails;
    public ImageButton avatar;

    public HomePanel(Account account) {
        super();
        this.account = account;
        this.setLayout(new BorderLayout());
        pnlTop = new JPanel();
        pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.Y_AXIS));
        this.add(pnlTop, BorderLayout.NORTH);
        if (FileUtility.isAvatarExists(account.getAvatar())) {
            avatar = new ImageButton("assets\\profiles\\" + account.getAvatar(), new Dimension(256, 256));
        } else {
            avatar = new ImageButton("assets\\profiles\\general.png", new Dimension(128, 128));
        }

        avatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Globals.loggedInAccount.equals(account)) {

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    int result = fileChooser.showOpenDialog(HomePanel.this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {

                            File selectedFile = fileChooser.getSelectedFile();
                            String path = selectedFile.getAbsolutePath();
                            if (GuiGlobals.mainFrame.activeCenterPanel instanceof HomePanel) {
                                String newPath = FileUtility.copyAvatarImage(path);
                                ((HomePanel) GuiGlobals.mainFrame.activeCenterPanel).avatar.changeImage("assets\\profiles\\" + newPath);
                                ((HomePanel) GuiGlobals.mainFrame.activeCenterPanel).account.setAvatar(newPath);
                                ((HomePanel) GuiGlobals.mainFrame.activeCenterPanel).account.changeAvatar();
                                GuiGlobals.mainFrame.centerPanel.rendered = false;
                                GuiGlobals.mainFrame.topPanel.rendered = false;

                            }
                        } catch (Exception ex) {
                        }
                    }


                }
            }
        });


        pnlAvatar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlAvatar.add(avatar);
        pnlTop.add(pnlAvatar);

        pnlDetails = new JPanel(new FlowLayout(FlowLayout.CENTER, 36, 20));
        pnlTop.add(pnlDetails);
        JPanel pnlPostsDetail = new JPanel();
        pnlPostsDetail.setLayout(new BoxLayout(pnlPostsDetail, BoxLayout.X_AXIS));
        JLabel lblPostTitle = new JLabel("Posts : ");
        lblPostTitle.setFont(new Font("Arial", Font.BOLD, 36));
        pnlPostsDetail.add(lblPostTitle);
        JLabel lblPostCount = new JLabel(account.getPosts().size() + "");
        lblPostCount.setFont(new Font("Arial", Font.BOLD, 36));
        pnlPostsDetail.add(lblPostCount);
        pnlDetails.add(pnlPostsDetail);

        JPanel pnlFollowersDetail = new JPanel();
        pnlFollowersDetail.setLayout(new BoxLayout(pnlFollowersDetail, BoxLayout.X_AXIS));

        JLabel lblFollowersTitle = new JLabel("Followers : ");
        lblFollowersTitle.setFont(new Font("Arial", Font.BOLD, 36));
        pnlFollowersDetail.add(lblFollowersTitle);

        JLabel lblFollowersCount = new JLabel(account.getFollowers().size() + "");
        lblFollowersCount.setFont(new Font("Arial", Font.BOLD, 36));
        pnlFollowersDetail.add(lblFollowersCount);
        pnlDetails.add(pnlFollowersDetail);

        JPanel pnlFollowingsDetail = new JPanel();
        pnlFollowingsDetail.setLayout(new BoxLayout(pnlFollowingsDetail, BoxLayout.X_AXIS));

        JLabel lblFollowingsTitle = new JLabel("Followers : ");
        lblFollowingsTitle.setFont(new Font("Arial", Font.BOLD, 36));
        pnlFollowingsDetail.add(lblFollowingsTitle);

        JLabel lblFollowingsCount = new JLabel(account.getFollowings().size() + "");
        lblFollowingsCount.setFont(new Font("Arial", Font.BOLD, 36));
        pnlFollowingsDetail.add(lblFollowingsCount);
        pnlDetails.add(pnlFollowingsDetail);

    }


}
