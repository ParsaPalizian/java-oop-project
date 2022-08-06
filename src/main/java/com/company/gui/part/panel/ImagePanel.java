package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.*;
import com.company.gui.assets.widget.BasePanel;
import com.company.gui.configuration.GuiSetting;
import com.company.gui.global.GuiGlobals;
import com.company.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class ImagePanel extends BasePanel {

    JPanel pnlImages;
    JScrollPane  scrImages;
    JPanel pnlImageAndUtility;
    JPanel pnlImage;
    JPanel pnlUtility;
    JPanel pnlViewComments;
    JPanel pnlViewReacts;

    public boolean rendered = true;

    public Post selectedPost;

    public ImagePanel() {

        this.setLayout(new BorderLayout());
        pnlImages = new JPanel();
        pnlImageAndUtility = new JPanel(new BorderLayout());
        pnlImage = new JPanel();
        pnlUtility = new JPanel();
        pnlViewComments = new JPanel();
        pnlViewReacts = new JPanel();


        pnlImages.setLayout(new BoxLayout(pnlImages, BoxLayout.Y_AXIS));

        scrImages = new JScrollPane(pnlImages);
        scrImages.getVerticalScrollBar().setUnitIncrement(32);


        pnlImageAndUtility.setLayout(new BorderLayout());
        pnlUtility.setLayout(new BoxLayout(pnlUtility, BoxLayout.X_AXIS));
        pnlViewComments.setLayout(new BoxLayout(pnlViewComments, BoxLayout.Y_AXIS));
        pnlViewReacts.setLayout(new BoxLayout(pnlViewReacts, BoxLayout.Y_AXIS));

        this.add(scrImages, BorderLayout.WEST);
        this.add(pnlImageAndUtility, BorderLayout.CENTER);
        pnlImageAndUtility.add(pnlImage, BorderLayout.CENTER);
        pnlImageAndUtility.add(pnlUtility, BorderLayout.SOUTH);
        pnlUtility.add(pnlViewComments);
        pnlUtility.add(pnlViewReacts);

        for (Post post : Globals.currentPosts) {
            ImageItem imageItem = new ImageItem(post, "assets\\profiles\\general2x.png",  GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
            imageItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlImages.add(imageItem);
            pnlImages.add(Box.createRigidArea(new Dimension(10, 10)));
        }

        int h = Globals.currentPosts.size() * 150;
        pnlImages.setPreferredSize(new Dimension(150, h));


        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);

//        GuiGlobals.mainFrame.activeCenterPanel = this;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (rendered == false) {
                        ImagePanel.this.pnlImageAndUtility.removeAll();
                        if (selectedPost != null) {

                            ImageItem imageItem = new ImageItem(selectedPost, "assets\\UNNAMED.png",  GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor());
                            pnlImageAndUtility.add(imageItem, BorderLayout.CENTER);
                            for (Comment comment : selectedPost.getComments()) {
                                CommentItem commentItem = new CommentItem(comment);
                                commentItem.setAlignmentX(Component.LEFT_ALIGNMENT);
                                pnlViewComments.add(commentItem);
                                pnlViewComments.add(Box.createRigidArea(new Dimension(10, 10)));
                            }

                            rendered = true;
                            ImagePanel.this.revalidate();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task, 100, 100); //call the run() method at 1 second intervals


    }

    @Override
    public void changeColor() {

    }
}
