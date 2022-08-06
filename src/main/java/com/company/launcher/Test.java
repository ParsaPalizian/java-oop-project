package com.company.launcher;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame
{
    public Test()
    {
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Test t = new Test();
        t.setVisible(true);
    }
}