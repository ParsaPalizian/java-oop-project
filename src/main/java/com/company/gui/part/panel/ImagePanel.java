package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.*;
import com.company.gui.assets.widget.BasePanel;
import com.company.gui.configuration.GuiSetting;
import com.company.model.*;
import com.company.utility.FileUtility;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;

public class ImagePanel extends BasePanel {

    JPanel pnlImages;
    JScrollPane scrImages;

    JPanel pnlPost;
    JPanel pnlTop;
    JPanel pnlPostDetails;
    JPanel pnlComments;

    public boolean rendered = true;

    public Post selectedPost;

    public ImagePanel() throws IOException {

        this.setLayout(new BorderLayout());
        pnlImages = new JPanel();
        pnlImages.setLayout(new BoxLayout(pnlImages, BoxLayout.Y_AXIS));
        scrImages = new JScrollPane(pnlImages);
        scrImages.getVerticalScrollBar().setUnitIncrement(32);
        this.add(scrImages, BorderLayout.WEST);

        for (Post post : Globals.currentPosts) {
            ImageItem imageItem;

            if (FileUtility.isPostImage(post.getMedia())) {
                imageItem = new ImageItem(
                        post,
                        "assets\\posts\\" + post.getMedia(),
                        GuiSetting.selectedTheme.getSecondaryColor(),
                        GuiSetting.selectedTheme.getPrimaryColor(),
                        new Dimension(128, 128)
                );


            } else {
                imageItem = new ImageItem(
                        post,
                        "assets\\profiles\\general2x.png",
                        GuiSetting.selectedTheme.getSecondaryColor(),
                        GuiSetting.selectedTheme.getPrimaryColor(),
                        new Dimension(128, 128)
                );
            }

            imageItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlImages.add(imageItem);
            pnlImages.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        int h = Globals.currentPosts.size() * 150;
        pnlImages.setPreferredSize(new Dimension(150, h));


        pnlPost = new JPanel(new BorderLayout());
        pnlPost.setLayout(new BorderLayout());
        this.add(pnlPost, BorderLayout.CENTER);

        pnlTop = new JPanel();
        pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.Y_AXIS));


        pnlPost.add(pnlTop, BorderLayout.NORTH);

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (rendered == false) {
                        ImagePanel.this.pnlTop.removeAll();
                        pnlTop.revalidate();
                        if (selectedPost != null) {
                            System.out.println(selectedPost.getId());

                            ImageItem imageItem;
                            if (FileUtility.isPostImage(selectedPost.getMedia())) {
                                imageItem = new ImageItem(selectedPost,
                                        "assets\\posts\\" + selectedPost.getMedia(),
                                        GuiSetting.selectedTheme.getSecondaryColor(),
                                        GuiSetting.selectedTheme.getPrimaryColor(),
                                        new Dimension(0, 256));
                            } else {

                                imageItem = new ImageItem(
                                        selectedPost,
                                        "assets\\unnamed.png",
                                        GuiSetting.selectedTheme.getSecondaryColor(),
                                        GuiSetting.selectedTheme.getPrimaryColor(),
                                        new Dimension(256, 256));
                            }
                            pnlTop.add(imageItem);

                            pnlPostDetails = new JPanel(new FlowLayout(FlowLayout.CENTER));
                            JLabel lbl1 = new JLabel("REACTS : " + selectedPost.getReactions().size());
                            lbl1.setFont(new Font("Arial", Font.BOLD, 36));

                            pnlPostDetails.add(lbl1);
                            JLabel lbl2 = new JLabel("COMMENTS : " + selectedPost.getComments().size());
                            lbl2.setFont(new Font("Arial", Font.BOLD, 36));
                            pnlPostDetails.add(lbl2);

                            pnlComments = new JPanel();
                            pnlComments.setLayout(new BoxLayout(pnlComments, BoxLayout.Y_AXIS));
                            for (Comment comment : selectedPost.getComments()) {

                                CommentItem item = new CommentItem(comment);
                                pnlComments.add(item);
                            }

                            JScrollPane scrComments = new JScrollPane(pnlComments);
                            scrComments.getVerticalScrollBar().setUnitIncrement(32);
                            int h = selectedPost.getComments().size() * 64;
                            pnlComments.setPreferredSize(new Dimension(600, h));
                            scrComments.setPreferredSize(new Dimension(600 , 500));
                            scrComments.setSize(new Dimension(600 , 500));
                            pnlTop.add(pnlPostDetails);
                            pnlTop.add(scrComments);
                            rendered = true;
                            pnlTop.revalidate();
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
