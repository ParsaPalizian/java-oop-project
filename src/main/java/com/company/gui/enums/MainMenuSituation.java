package com.company.gui.enums;

/**
 * Created by kami on 7/29/2022.
 */
public enum MainMenuSituation {
    NONE(0), HOME(1), TIMELINE(2), EXPLORER(3), SEARCH(4), SETTINGS(5);
    int value;
    MainMenuSituation(int value) {
        this.value = value;
    }
}
