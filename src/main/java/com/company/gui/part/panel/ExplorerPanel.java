package com.company.gui.part.panel;

import javax.swing.*;
import java.awt.*;

public class ExplorerPanel extends JPanel {

    JPanel pnlExplorer;
    JPanel pnlRow1Posts;
    JButton btnPost1;
    JButton btnPost2;
    JButton btnPost3;


    public ExplorerPanel(){
        this.setLayout(null);

        pnlExplorer=new JPanel();
        pnlExplorer.setLayout(new BoxLayout(pnlExplorer,BoxLayout.Y_AXIS));

        pnlRow1Posts =new JPanel();
        pnlRow1Posts.setLayout(new GridLayout(1,3));


        btnPost1=new JButton("Post 1");
        btnPost2=new JButton("Post 2");
        btnPost3=new JButton("Post 3");


        pnlRow1Posts.add(btnPost1);
        pnlRow1Posts.add(btnPost2);
        pnlRow1Posts.add(btnPost3);


        pnlExplorer.add(pnlRow1Posts);


        this.add(pnlExplorer);

        this.setBounds(100,100,400 + this.getInsets().left + this.getInsets().right ,600 );
        this.setVisible(true);
    }
}
