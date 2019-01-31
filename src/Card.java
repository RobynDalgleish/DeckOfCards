import java.util.*;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    private final static Map<String, Card> CARD_CACHE = initCache();

    private static Map<String, Card> initCache() {
        final Map<String, Card> cache = new HashMap<>();
        for(final Suit suit : Suit.values()) {
            for(final Rank rank : Rank.values()) {
                cache.put(cardKey(rank, suit), new Card(rank, suit));
            }
        }
        return Collections.unmodifiableMap(cache);
    }

    public static Card getCard(final Rank rank,
                        final Suit suit) {

        final Card card = Objects.requireNonNull(CARD_CACHE.get(cardKey(rank, suit)), "Invalid card:" + rank + suit);

        return card;
    }

    private static String cardKey(final Rank rank,
                                  final Suit suit) {
        return rank + " of " + suit;
    }

    private Card(final Rank rank,
                 final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank, this.suit);
    }

    @Override
    public int compareTo(Card o) {
        final int rankComparison = Integer.compare(this.rank.getRankValue(), o.rank.getRankValue());

        if(rankComparison != 0) {
            return rankComparison;
        }

        return Integer.compare(this.suit.getSuitValue(), o.suit.getSuitValue());
    }

    enum Suit {
        DIAMONDS(1),
        HEARTS(2),
        SPADES(3),
        CLUBS(4);

        private final int suitValue;

        Suit(final int suitValue) {
            this.suitValue = suitValue;
        }

        public int getSuitValue() {
            return this.suitValue;
        }
    };

    enum Rank {
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
        KING(13),
        ACE(14);

        private final int rankValue;

        Rank(final int rankValue) {
            this.rankValue = rankValue;
        }

        public int getRankValue() {
            return this.rankValue;
        }
    };
}
