package com.company.gui.appearence;

import java.awt.*;

/**
 * Created by kami on 7/29/2022.
 */
public class Theme {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name ;
    private Color primaryColor;
    private Color primaryVariantColor;

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    private Color secondaryColor;
    private Color secondaryVariantColor;
    private Color textColor;

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getPrimaryVariantColor() {
        return primaryVariantColor;
    }

    public void setPrimaryVariantColor(Color primaryVariantColor) {
        this.primaryVariantColor = primaryVariantColor;
    }

    public Color getSecondaryVariantColor() {
        return secondaryVariantColor;
    }

    public void setSecondaryVariantColor(Color secondaryVariantColor) {
        this.secondaryVariantColor = secondaryVariantColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
