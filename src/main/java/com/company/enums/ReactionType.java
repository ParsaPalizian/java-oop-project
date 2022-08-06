package com.company.enums;

public enum ReactionType {

    LAUGH(1,"\uD83D\uDE02" ),
    HEART(2,"\u2764"),
    LIKE(3,"\uD83D\uDC4D"),
    DISLIKE(4,"\uD83D\uDC4E"),
    POKER_FACE(5,"\uD83D\uDE10"),
    RAGE(6,"\uD83E\uDD2C"),
    CRY(7,"\uD83D\uDE2D"),
    DISGUSTING(8,"\uD83E\uDD2E"),
    FIRE(9,"\uD83D\uDD25");

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    final String value;
    final int id;
    @Override
    public String toString() {
        return value;
    }

    ReactionType( int id,String value) {
        this.value = value;
        this.id = id;
    }

}
