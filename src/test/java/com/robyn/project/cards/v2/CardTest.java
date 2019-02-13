package com.robyn.project.cards.v2;

import java.util.Stack;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.robyn.project.cards.v2.Card.Rank.*;
import static com.robyn.project.cards.v2.Card.Suit.*;
import static com.robyn.project.cards.v2.Card.Rank;
import static com.robyn.project.cards.v2.Card.Suit;

public class CardTest {

    @Test
    public void testCreateCard() {
        assertNotNull(new Card());
    }

    @Test
    public void testCardHasSuitAndRank() {
        Card card = new Card();
        assertEquals(ACE, card.getRank());
        assertEquals(SPADES, card.getSuit());
    }

    @Test
    public void testCardHasSpecifiedSuitAndRank() {
        Card card = new Card(ACE, SPADES);
        assertEquals(ACE, card.getRank());
        assertEquals(SPADES, card.getSuit());

        card = new Card(TWO, DIAMONDS);
        assertEquals(TWO, card.getRank());
        assertEquals(DIAMONDS, card.getSuit());
    }

    @Test
    public void testEveryStandardCardCanBeRepresented() {
        Stack<Card> stackOfCards = new Stack<>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                stackOfCards.push(new Card(r, s));
            }
        }

        assertEquals(52, stackOfCards.size());

        assertAllRanksOfGivenSuitArePresent(stackOfCards, SPADES);
        assertAllRanksOfGivenSuitArePresent(stackOfCards, DIAMONDS);
        assertAllRanksOfGivenSuitArePresent(stackOfCards, CLUBS);
        assertAllRanksOfGivenSuitArePresent(stackOfCards, HEARTS);
    }

    static void assertAllRanksOfGivenSuitArePresent(Stack<Card> stackOfCards, Suit suit) {
        assertTrue(stackOfCards.search(new Card(ACE, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(TWO, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(THREE, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(FOUR, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(FIVE, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(SIX, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(SEVEN, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(EIGHT, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(NINE, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(TEN, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(JACK, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(QUEEN, suit)) > -1);
        assertTrue(stackOfCards.search(new Card(KING, suit)) > -1);
    }

    @Test
    public void testCardPropertiesDetermineEquality() {
        assertEquals(new Card(), new Card());
        assertEquals(new Card(TWO, SPADES), new Card(TWO, SPADES));
        assertNotEquals(new Card(TWO, HEARTS), new Card(TWO, SPADES));
    }

    @Test
    public void testCardIsHumanReadable() {
        assertEquals("ACE of SPADES", new Card().toString());
    }
}