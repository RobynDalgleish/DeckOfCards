package com.robyn.project.cards.v2.standard.blackjack;

import com.robyn.project.cards.v2.standard.StandardPlayingCard;
import com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardRank;

import java.util.ArrayList;
import java.util.List;

import static com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardRank.ACE;
import static java.lang.Math.min;

public class Hand {

    private static final int ACE_LOW_VALUE = 1;
    private static final int ACE_HIGH_VALUE = 11;
    private static final int FACE_CARD_VALUE = 10;

    private int lowValue;
    private int highValue;
    private List<StandardPlayingCard> cards = new ArrayList<>();

    public int getLowValue() {
        return lowValue;
    }

    public int getHighValue() {
        return highValue;
    }

    public List<StandardPlayingCard> getCards() {
        return cards;
    }

    public void addCard(StandardPlayingCard card) {
        cards.add(card);
        updateHandValuation(card.getRank());
    }

    private void updateHandValuation(StandardRank rank) {
        if (rank == ACE) {
            lowValue += ACE_LOW_VALUE;
            highValue += ACE_HIGH_VALUE;
        } else {
            int value = min(FACE_CARD_VALUE, rank.getValue());
            lowValue += value;
            highValue += value;
        }
    }

    public int size() {
        return cards.size();
    }
}

