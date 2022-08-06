package com.company.gui.part.panel;

import com.company.gui.assets.widget.BasePanel;
import com.company.gui.global.GuiGlobals;
import com.company.gui.part.main.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static TopPanel topPanel;
    public static LeftPanel leftPanel;
    public static RightPanel rightPanel;
    public static CenterPanel centerPanel;
    public static BottomPanel bottomPanel;

    public static JPanel activeCenterPanel = null;


    public MainFrame() {

//        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        this.setMaximizedBounds(env.getMaximumWindowBounds());
//        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width / 2, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        GuiGlobals.mainFrame = new MainFrame();

//        GuiGlobals.mainFrame.setPreferredSize(new Dimension(800,600));
//        GuiGlobals.mainFrame.add(new PostPanel());

        GuiGlobals.mainFrame.setLayout(new BorderLayout());

        leftPanel = new LeftPanel();
        GuiGlobals.mainFrame.add(leftPanel, BorderLayout.WEST);

//        JScrollPane scrollPane = new JScrollPane(leftPanel);
//        GuiGlobals.mainFrame.getContentPane().add(scrollPane, BorderLayout.WEST);


        topPanel = new TopPanel();
        GuiGlobals.mainFrame.add(topPanel, BorderLayout.NORTH);

        rightPanel = new RightPanel();
        GuiGlobals.mainFrame.add(rightPanel, BorderLayout.EAST);

        bottomPanel = new BottomPanel();
        GuiGlobals.mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        centerPanel = new CenterPanel();
        GuiGlobals.mainFrame.add(centerPanel, BorderLayout.CENTER);


        GuiGlobals.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GuiGlobals.mainFrame.setVisible(true);
    }
}
