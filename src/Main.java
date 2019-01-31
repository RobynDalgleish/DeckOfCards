import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final Deck deck = new Deck();
        final int numOfCardsToDeal = 1;
        IntStream.range(0, numOfCardsToDeal).forEach(value -> {
            System.out.println(deck.deal());
        });
    }

}
