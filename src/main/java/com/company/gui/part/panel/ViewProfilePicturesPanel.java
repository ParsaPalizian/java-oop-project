package com.company.gui.part.panel;

import com.company.global.Globals;
import com.company.gui.assets.ImageItem;
import com.company.gui.configuration.GuiSetting;
import com.company.model.ProfilePicture;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ViewProfilePicturesPanel extends JPanel {

    JPanel pnlImages;
    JScrollPane scrImages;

    JPanel pnlImageAndUtility;

    public ViewProfilePicturesPanel() throws IOException {

        this.setLayout(new BorderLayout());
        pnlImages = new JPanel();
        pnlImageAndUtility = new JPanel();
        pnlImages.setLayout(new BoxLayout(pnlImages, BoxLayout.Y_AXIS));
        scrImages = new JScrollPane(pnlImages);
        scrImages.getVerticalScrollBar().setUnitIncrement(32);

        this.add(scrImages, BorderLayout.WEST);
        this.add(pnlImageAndUtility, BorderLayout.CENTER);


        for (ProfilePicture profilePicture : Globals.currentAccount.getProfilePictures()) {
            //todo read caption
            ImageItem imageItem = new ImageItem(null, "assets\\profiles\\general2x.png", GuiSetting.selectedTheme.getSecondaryColor(), GuiSetting.selectedTheme.getPrimaryColor(), new Dimension(128,128));
            imageItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlImages.add(imageItem);
            pnlImages.add(Box.createRigidArea(new Dimension(10, 10)));

        }

        int h = Globals.currentAccount.getProfilePictures().size() * 150;
        pnlImages.setPreferredSize(new Dimension(150, h));

        this.setBounds(100, 100, 400 + this.getInsets().left + this.getInsets().right, 600);
        this.setVisible(true);
    }
}
