package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.Player;

public class TarotPlayer extends Player<TarotCard, TarotSpread>{

    public TarotPlayer() {
        this(new TarotSpread());
    }

    public TarotPlayer(TarotSpread hand) {
        super(hand);
    }

    public void draw(Deck<TarotCard> deck) {
        hand.addCard(deck.draw());
    }
}
