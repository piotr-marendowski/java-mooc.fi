import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

enum Suit {
    CLUB, DIAMOND, HEART, SPADE;
}

class Card implements Comparable<Card> {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String cardValue = "" + value;
        if (value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else if (value == 14) {
            cardValue = "A";
        }

        return suit + " " + cardValue;
    }

    /* part 1 */
    @Override
    public int compareTo(Card compared) {
        if (this.getValue() == compared.getValue()) {
            if (this.getSuit() == compared.getSuit())
                return 0;
        }

        if (this.getValue() < compared.getValue())
            return -1;
        else
            return 1;
    }
}

/* part 2 */
class Hand implements Comparable<Hand> {
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        for (Card i: this.hand)
            System.out.println(i);
    }

    /* part 3 */
    public void sort() {
        Collections.sort(this.hand);
    }

    /* part 4 */
    @Override
    public int compareTo(Hand otherHand) {
        int thisValue = this.hand.stream()
                .map( card -> card.getValue())
                .reduce(0, (a, b) -> a + b);
        int otherValue = otherHand.hand.stream()
                .map( card -> card.getValue())
                .reduce(0, (a, b) -> a + b);
        
        return thisValue - otherValue;
    }

    /* part 6 */
    public void sortBySuit() {
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
}

class SortBySuit implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        return c1.getSuit().ordinal() - c2.getSuit().ordinal();
    }
}

/* part 5 */
class BySuitInValueOrder implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        int suitValueOrder = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        
        if (suitValueOrder == 0) {
            return c1.compareTo(c2);
        }
        
        return suitValueOrder;
    }
}

public class SortThemCards {   
    public static void main(String[] args) {
        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        hand.sortBySuit();

        hand.print();
    }
}
