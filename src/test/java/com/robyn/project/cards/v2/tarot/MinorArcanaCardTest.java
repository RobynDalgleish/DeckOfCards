package com.robyn.project.cards.v2.tarot;

import com.robyn.project.cards.v2.PlayingCard;
import com.robyn.project.cards.v2.Suit;
import org.junit.Test;

import java.util.Stack;

import static com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaRank.*;
import static com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaSuit.*;
import static com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaSuit;
import static com.robyn.project.cards.v2.tarot.MinorArcanaCard.MinorArcanaRank;
import static org.junit.jupiter.api.Assertions.*;

public class MinorArcanaCardTest {

    @Test
    public void testMinorArcanaCardHasSpecifiedSuitAndRank() {
        MinorArcanaCard card = new MinorArcanaCard(ACE, SWORDS);
        assertEquals(ACE, card.getRank());
        assertEquals(SWORDS, card.getSuit());

        card = new MinorArcanaCard(TWO, PENTACLES);
        assertEquals(TWO, card.getRank());
        assertEquals(PENTACLES, card.getSuit());
    }

    @Test
    public void testEveryMinorArcanaCardCanBeRepresented() {
        Stack<PlayingCard> cardStack = new Stack<>();
        for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
            for (MinorArcanaRank r : MinorArcanaRank.values()) {
                cardStack.push(new MinorArcanaCard(r, s));
            }
        }
        assertAllMinorArcanaCardsArePresent(cardStack);
    }

    static void assertAllMinorArcanaCardsArePresent(Stack<PlayingCard> cardStack) {
        assertAllRanksOfGivenSuitArePresent(cardStack, SWORDS);
        assertAllRanksOfGivenSuitArePresent(cardStack, PENTACLES);
        assertAllRanksOfGivenSuitArePresent(cardStack, WANDS);
        assertAllRanksOfGivenSuitArePresent(cardStack, CUPS);
    }

    private static void assertAllRanksOfGivenSuitArePresent(Stack<PlayingCard> cardStack, Suit suit) {
        assertTrue(cardStack.search(new MinorArcanaCard(ACE, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(TWO, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(THREE, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(FOUR, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(FIVE, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(SIX, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(SEVEN, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(EIGHT, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(NINE, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(TEN, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(PAIGE, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(KNIGHT, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(QUEEN, suit)) > -1);
        assertTrue(cardStack.search(new MinorArcanaCard(KING, suit)) > -1);
    }

    @Test
    public void testMinorArcanaCardPropertiesDetermineEquality() {
        assertEquals(new MinorArcanaCard(TWO, SWORDS), new MinorArcanaCard(TWO, SWORDS));
        assertNotEquals(new MinorArcanaCard(TWO, CUPS), new MinorArcanaCard(TWO, SWORDS));
    }

    @Test
    public void testMinorArcanaCardIsHumanReadable() {
        assertEquals("ACE of SWORDS", new MinorArcanaCard(ACE, SWORDS).toString());
    }
}