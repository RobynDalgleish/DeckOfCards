package com.robyn.project.cards.v2.standard;

import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.Rank;
import com.robyn.project.cards.v2.Suit;

public class StandardPlayingCard extends PlayingCard<StandardPlayingCard.StandardRank, StandardPlayingCard.StandardSuit> {

    public StandardPlayingCard(StandardRank rank, StandardSuit suit) {
        super(rank, suit);
    }

    public enum StandardSuit implements Suit {
        DIAMONDS,
        CLUBS,
        HEARTS,
        SPADES
    }

    public enum StandardRank implements Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private int value;

        StandardRank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}