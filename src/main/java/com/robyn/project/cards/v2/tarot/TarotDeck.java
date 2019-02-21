package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.Deck;

import java.util.Stack;

public class TarotDeck extends Deck<TarotCard> {

    protected void init() {
        Stack<TarotCard> playingCards = super.getPlayingCards();
        for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
            for (MinorArcanaRank r : MinorArcanaRank.values()) {
                playingCards.push(new MinorArcanaCard(r, s));
            }
        }
        for (MajorArcana a : MajorArcana.values()) {
            playingCards.push(new MajorArcanaCard(a));
        }
    }
}
