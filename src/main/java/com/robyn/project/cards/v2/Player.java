package com.robyn.project.cards.v2;

public abstract class Player<C extends PlayingCard, H extends Hand> {

    protected H hand;

    public Player(H hand) {

        this.hand = hand;
    }

    public H getHand() {
        return hand;
    }

    public void draw(Deck<C> deck) {
        hand.addCard(deck.draw());
    }
}