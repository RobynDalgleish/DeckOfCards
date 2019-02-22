package com.robyn.project.cards.v2.standard.war;

import com.robyn.project.cards.v2.Hand;
import com.robyn.project.cards.v2.standard.StandardPlayingCard;

import java.util.ArrayList;
import java.util.List;

public class WarHand extends Hand<StandardPlayingCard, ArrayList<StandardPlayingCard>> {

    private List<StandardPlayingCard> cards = new ArrayList<>();

    public List<StandardPlayingCard> getCards() {
        return cards;
    }

    public void addCard(StandardPlayingCard card) {
        cards.add(card);
    }
}
