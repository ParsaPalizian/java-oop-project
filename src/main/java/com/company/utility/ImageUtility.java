package com.company.utility;

import java.awt.*;

public class ImageUtility {

    public static Image resize(Image image, Dimension size) {
        image = image.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
        return image;
    }

}
