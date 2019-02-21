package com.robyn.project.cards.v2.tarot;

import org.junit.Test;

import java.util.Stack;

import static com.robyn.project.cards.v2.tarot.MajorArcanaCardTest.assertAllMajorArcanaCardsArePresent;
import static com.robyn.project.cards.v2.tarot.MinorArcanaCardTest.assertAllMinorArcanaCardsArePresent;

public class TarotCardTest {

    @Test
    public void testEveryTarotCardCanBeRepresented() {
        Stack<TarotCard> cardStack = new Stack<>();

        for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
            for (MinorArcanaRank r : MinorArcanaRank.values()) {
                cardStack.push(new MinorArcanaCard(r, s));
            }
        }

        for (MajorArcana a : MajorArcana.values()) {
            cardStack.push(new MajorArcanaCard(a));
        }

        assertAllMinorArcanaCardsArePresent(cardStack);
        assertAllMajorArcanaCardsArePresent(cardStack);
    }
}