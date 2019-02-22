package com.robyn.project.cards.v2.standard.blackjack;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.Player;
import com.robyn.project.cards.v2.standard.StandardPlayingCard;

public class BlackJackPlayer extends Player<StandardPlayingCard, BlackJackHand> {

    public BlackJackPlayer() {
        super(new BlackJackHand());
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }
}

