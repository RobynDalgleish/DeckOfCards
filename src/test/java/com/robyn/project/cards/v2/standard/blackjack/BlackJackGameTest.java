package com.robyn.project.cards.v2.standard.blackjack;

import com.robyn.project.cards.v2.standard.StandardPlayingCard;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardRank.*;
import static com.robyn.project.cards.v2.standard.StandardPlayingCard.StandardSuit.*;
import static com.robyn.project.cards.v2.standard.blackjack.BlackJackGame.evaluateHand;
import static org.junit.Assert.*;

public class BlackJackGameTest {

    @Test
    public void testBlackJackGameHasDealer() {
        assertNotNull(new BlackJackGame().getDealer());
    }

    @Test
    public void testBlackJackGameHasAtLeastOnePlayer() {
        assertTrue(new BlackJackGame().getPlayers().size() > 0);
    }

    @Test
    public void testBlackJackGameHasDeck() {
        assertNotNull(new BlackJackGame().getDeck());
    }

    @Test
    public void testBlackJackDealerStartsWithExactlyTwoCards() {
        assertTrue(new BlackJackGame().getDealer().getHand().size() == 2);
    }

    @Test
    public void testBlackJackPlayersStartWithExactlyTwoCards() {
        BlackJackGame game = new BlackJackGame();
        for (Player p : game.getPlayers()) {
            assertTrue(p.getHand().size() == 2);
        }
    }

    @Test
    public void testBlackJackDealerAndPlayersStartWithUniqueCards() {
        BlackJackGame game = new BlackJackGame();
        Set<StandardPlayingCard> collectiveHands = new HashSet<>();
        int expectedUniqueCardCount = 0; // since we know each hand has 2 cards, add 2 every time we add to set

        collectiveHands.addAll(game.getDealer().getHand().getCards());
        expectedUniqueCardCount += 2; // equiv. to [ count = count + 2 ]

        for (Player p : game.getPlayers()) {
            collectiveHands.addAll(p.getHand().getCards());
            expectedUniqueCardCount += 2;
        }

        assertEquals(expectedUniqueCardCount, collectiveHands.size());
    }

    @Test
    public void testBlackJackHasAtLeastOnePlayer() {
        assertTrue(new BlackJackGame().getPlayers().size() > 0);
    }

    @Test
    public void testBlackJackHasSpecifiedNumberOfPlayers() {
        assertTrue(new BlackJackGame(3).getPlayers().size() == 3);
    }

    @Test
    public void testBlackJackPlayerCanHit() {
        BlackJackGame game = new BlackJackGame();
        List<Player> players = game.getPlayers();
        assertEquals(1, players.size());
        Player onlyPlayer = players.get(0);

        assertEquals(2, onlyPlayer.getHand().size());
        game.hit(onlyPlayer);
        assertEquals(3, onlyPlayer.getHand().size());
    }

    @Test
    public void testBlackJackHandCanBeEvaluated() {
        Hand hand = new Hand();
        hand.addCard(new StandardPlayingCard(FIVE, DIAMONDS));
        hand.addCard(new StandardPlayingCard(THREE, SPADES));
        assertEquals(8, evaluateHand(hand));
    }

    @Test
    public void testFaceCardsEvaluateAsTens() {
        Hand hand = new Hand();
        hand.addCard(new StandardPlayingCard(JACK, DIAMONDS));
        hand.addCard(new StandardPlayingCard(THREE, SPADES));
        assertEquals(13, evaluateHand(hand));

        hand = new Hand();
        hand.addCard(new StandardPlayingCard(QUEEN, DIAMONDS));
        hand.addCard(new StandardPlayingCard(THREE, SPADES));
        assertEquals(13, evaluateHand(hand));

        hand = new Hand();
        hand.addCard(new StandardPlayingCard(KING, DIAMONDS));
        hand.addCard(new StandardPlayingCard(THREE, SPADES));
        assertEquals(13, evaluateHand(hand));
    }

    @Test
    public void testAcesAreEvaluatedAsOneInLowValueAndAsElevenInHighValue() {
        Hand hand = new Hand();
        hand.addCard(new StandardPlayingCard(ACE, DIAMONDS));
        hand.addCard(new StandardPlayingCard(KING, SPADES));
        assertEquals(11, hand.getLowValue());

        hand = new Hand();
        hand.addCard(new StandardPlayingCard(ACE, DIAMONDS));
        hand.addCard(new StandardPlayingCard(KING, SPADES));
        assertEquals(21, hand.getHighValue());
    }

    @Test
    public void testFinalEvaluationFavoursHighestValidValue() {
        Hand hand = new Hand();
        hand.addCard(new StandardPlayingCard(ACE, DIAMONDS));
        hand.addCard(new StandardPlayingCard(KING, SPADES));
        assertEquals(21, evaluateHand(hand));

        hand.addCard(new StandardPlayingCard(KING, SPADES));
        assertEquals(21, evaluateHand(hand));
    }
}