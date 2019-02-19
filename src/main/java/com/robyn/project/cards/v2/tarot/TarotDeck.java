package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.Deck;
import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.tarot.MajorArcanaCard.MajorArcana;
import com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaRank;
import com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaSuit;

import java.util.Stack;

public class TarotDeck extends Deck {

    protected void init() {
        Stack<PlayingCard> playingCards = super.getPlayingCards();
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
