package com.robyn.project.cards.v2.standard;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardRank;
import com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardSuit;

import java.util.Stack;

public class StandardDeck extends Deck {

    protected void init() {
        Stack<PlayingCard> playingCards = super.getPlayingCards();
        for (StandardSuit s : StandardSuit.values()) {
            for (StandardRank r : StandardRank.values()) {
                playingCards.push(new StandardPlayingCard(r, s));
            }
        }
    }
}