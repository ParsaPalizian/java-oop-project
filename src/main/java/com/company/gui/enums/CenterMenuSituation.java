package com.company.gui.enums;

public enum CenterMenuSituation {

    NONE (0),
    BLOCKLIST(1),
    CHOOSE_GROUP_MEMBER(2),
    MESSAGES(3),
    CONTENT(4),
    CREATE_GROUP(5),
    EXPLORER(6),
    EXPLORER_POST(7),
    FOLLOWERS(8),
    FORWARD_TO_CONTACT_OR_GROUP(9),
    GROUP_LIST(10),
    GROUP_MEMBERS(11),
    GROUP(12),
    GROUPS(13),
    HOME(14),
    LOGIN(15),
    MAIN(16),
    POSTING(17),
    POST(18),
    PRIME_PAGE(19),
    SEARCH_ACCOUNTS(20),
    SEARCH_HISTORY(21),
    SEARCH(22),
    SIGNUP(23),
    TIMELINE(24),
    VIEW_COMMENT(25),
    VIEW_IMAGE(26),
    VIEW_PROFILE_PICTURES(27),
    IMAGE_PANEL(28),
    FOLLOWINGS(29),
    REQUESTS(30),
    RECOMMENDS(31),
    NEW_POST(32),
    FORGET_PASSWORD(33);


    int value;

    CenterMenuSituation(int value) {
        this.value = value;
    }
}
