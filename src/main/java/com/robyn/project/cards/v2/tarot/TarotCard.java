package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.Rank;
import com.robyn.project.cards.v2.Suit;


public abstract class TarotCard extends PlayingCard {

    public TarotCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    public abstract String getMeaning();
}
