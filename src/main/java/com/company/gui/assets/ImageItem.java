package com.company.gui.assets;

import com.company.gui.global.GuiGlobals;
import com.company.gui.part.panel.ImagePanel;
import com.company.model.Post;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageItem extends JPanel {


    JButton btn;
    Post post;


    public ImageItem(Post post, String profile, Color back, Color textColor, Dimension size) throws IOException {
        super();
        this.post = post;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(back);

        ImageIcon ic = new ImageIcon(profile);
        Image image = ic.getImage();


        if (size.width != 0) {
            image = image.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
            ic = new ImageIcon(image);
        } else {

            BufferedImage bimg = ImageIO.read(new File(profile));
            int width = bimg.getWidth();
            int height = bimg.getHeight();
            int newWidth = width * size.height / height;
            image = image.getScaledInstance(newWidth, size.height, java.awt.Image.SCALE_SMOOTH);
            ic = new ImageIcon(image);

        }
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

                    ((ImagePanel) GuiGlobals.mainFrame.activeCenterPanel).rendered = false;
                    ((ImagePanel) GuiGlobals.mainFrame.activeCenterPanel).selectedPost = post;
                }

            }
        });


        this.add(btn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));


    }
}
