package com.company.gui.assets;

import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.ImagePanel;
import com.company.model.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageItem extends JPanel {


    JButton btn;
    Post post;


    public ImageItem(Post post, String profile,  Color back, Color textColor) {
        super();
        this.post = post;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(back);

        ImageIcon ic = new ImageIcon(profile);
//        Image image = ic.getImage();
//        image = image.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
//        ic = new ImageIcon(image);
        btn = new JButton(ic);
        btn.setFont(new Font("Arial", 0, 24));
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setRolloverEnabled(true);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setAlignmentY(Component.CENTER_ALIGNMENT);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (GuiGlobals.mainFrame.activeCenterPanel instanceof ImagePanel) {
                    System.out.println(post.getId());

                    ((ImagePanel) GuiGlobals.mainFrame.activeCenterPanel).rendered = false;
                    ((ImagePanel) GuiGlobals.mainFrame.activeCenterPanel).selectedPost = post;
                }

            }
        });


        this.add(btn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));


    }
}
