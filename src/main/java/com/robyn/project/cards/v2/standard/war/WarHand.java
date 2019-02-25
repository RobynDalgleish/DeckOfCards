package com.robyn.project.cards.v2.standard.war;

import com.robyn.project.cards.v2.Hand;
import com.robyn.project.cards.v2.standard.StandardPlayingCard;

import java.util.Stack;

public class WarHand extends Hand<StandardPlayingCard, Stack<StandardPlayingCard>> {

    private Stack<StandardPlayingCard> cards = new Stack<>();

    public Stack<StandardPlayingCard> getCards() {
        return cards;
    }

    public void addCard(StandardPlayingCard card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }
}
