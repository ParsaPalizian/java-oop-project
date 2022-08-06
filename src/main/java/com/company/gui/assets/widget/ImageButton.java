package com.company.gui.assets.widget;

import com.company.utility.ImageUtility;
import org.kordamp.ikonli.Ikon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by kami on 7/29/2022.
 */
public class ImageButton extends JButton {
    Dimension size;

    public ImageButton(String path, Dimension size) {
        super();
        this.size = size;
        this.setIcon(new ImageIcon(ImageUtility.resize(new ImageIcon(path).getImage(), size)));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setRolloverEnabled(true);

    }

    public void changeImage(String path) {
        this.setIcon(new ImageIcon(ImageUtility.resize(new ImageIcon(path).getImage(), size)));
    }


}
