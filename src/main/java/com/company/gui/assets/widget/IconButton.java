package com.company.gui.assets.widget;

import org.kordamp.ikonli.Ikon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kami on 7/29/2022.
 */
public class IconButton extends JButton {
    private int size;
    Ikon ikon;
    public IconButton(Ikon ikon, int size, Color base, Color hover) {
        super(FontIcon.of(ikon, size, base));
        this.size = size;
        this.ikon = ikon;
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setRolloverEnabled(true);
        this.setRolloverIcon(FontIcon.of(ikon, size, hover));
    }

    public void changeColor( Color base, Color hover){
        this.setIcon(FontIcon.of(ikon, size, base));
        this.setRolloverIcon(FontIcon.of(ikon, size, hover));
    }




}
