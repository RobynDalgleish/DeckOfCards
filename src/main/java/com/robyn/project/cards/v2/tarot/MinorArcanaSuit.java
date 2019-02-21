package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.Suit;

public enum MinorArcanaSuit implements Suit {
    PENTACLES("something to do with fortune"),
    WANDS("something to do with imagination"),
    CUPS("something to do with emotion"),
    SWORDS("something to do with challenge");

    private String meaning;

    MinorArcanaSuit(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }
}