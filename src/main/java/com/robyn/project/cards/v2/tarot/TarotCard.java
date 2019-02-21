package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.Rank;
import com.robyn.project.cards.v2.Suit;


public abstract class TarotCard<R extends Rank, S extends Suit> extends PlayingCard<R, S> {

    public TarotCard(R rank, S suit) {
        super(rank, suit);
    }

    public abstract String getMeaning();
}
