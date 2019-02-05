package cardsv1;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deckOfCards;

    public Deck() {
        this.deckOfCards = initDeck();
    }

    private Stack<Card> initDeck() {
        final Stack<Card> deckOfCards = new Stack<>();
        for(final Card.Suit suit : Card.Suit.values()) {
            for (final Card.Rank rank : Card.Rank.values()) {
                deckOfCards.push(Card.getCard(rank, suit));
            }
        }
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    public Optional<Card> deal() {
        return this.deckOfCards.empty() ? Optional.empty() :
                Optional.of(this.deckOfCards.pop());
    }


}
