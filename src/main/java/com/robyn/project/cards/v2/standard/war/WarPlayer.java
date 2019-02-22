package com.robyn.project.cards.v2.standard.war;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.Player;
import com.robyn.project.cards.v2.standard.StandardPlayingCard;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

    public WarPlayer() {
        super(new WarHand());
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }
}
