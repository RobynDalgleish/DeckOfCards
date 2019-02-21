package com.robyn.project.cards.v2.standard.blackjack;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.standard.StandardPlayingCard;

public class Player {

    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }
}

