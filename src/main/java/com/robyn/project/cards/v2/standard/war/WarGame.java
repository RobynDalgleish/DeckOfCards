package com.robyn.project.cards.v2.standard.war;

import com.robyn.project.cards.v2.CardGame;
import com.robyn.project.cards.v2.standard.StandardDeck;

public class WarGame extends CardGame<StandardDeck, WarPlayer> {

    public static final int DEFAULT_NUMBER_OF_PLAYERS = 2;

    public WarGame() {
       this(DEFAULT_NUMBER_OF_PLAYERS);
    }

    public WarGame(int numberOfPlayers) {
        super(new StandardDeck(), new WarPlayer());
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new WarPlayer());
        }
        deal();
    }

    protected void deal() {
        while (deck.size() > 1) {
//            todo: add player with dealer
            dealer.draw(deck);
        }
    }
}
