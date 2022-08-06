package com.company.gui.enums;

public enum TopMenuSituation {

    NONE(0), GROUPS(1), CREATE_GROUP(2), SELECT_GROUP(3), HOME(4) ;
    int value;
    TopMenuSituation(int value) {
        this.value = value;
    }


}
