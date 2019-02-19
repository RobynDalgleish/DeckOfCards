package com.robyn.project.cards.v2;

public abstract class CardGame {

    private Deck deck;

    public CardGame(Deck deck) {
        this.deck = deck;
        init();
        deck.shuffle();
        deal();
    }

    public Deck getDeck() {
        return deck;
    }

    protected abstract void init();

    protected abstract void deal();
}