import java.util.ArrayList;
import java.util.Scanner;

public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    /* part 1 */
    public Money plus(Money addition) {
        int newEuros = euros + addition.euros();
        int newCents = cents + addition.cents();
        if (newCents > 99) {
            newCents -= 100;
            newEuros++;
        }

        return new Money(newEuros, newCents);
    }

    /* part 2 */
    public boolean lessThan(Money compared) {
        if (this.euros > compared.euros)
            return false;
        else if (this.euros == compared.euros) {
            if (this.cents > compared.cents)
                return false;
        }

        return true;
    }

    /* part 3 */
    public Money minus(Money decreaser) {
        int NewEuros = this.euros - decreaser.euros();
        int newCents = this.cents - decreaser.cents();

        if (newCents < 0) {
            newCents += 100;
            NewEuros--;
        }
        if (NewEuros < 0) {
            NewEuros = 0;
            newCents = 0;
        }

        return new Money(NewEuros, newCents);
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

    public static void main(String[] args) {
        Money a = new Money(10, 0);
        Money b = new Money(3, 50);

        Money c = a.minus(b);

        System.out.println(a); // 10.00e
        System.out.println(b); // 3.50e
        System.out.println(c); // 6.50e

        c = c.minus(a); // NB: a new Money object is created, and is placed "at the end of the strand
                        // connected to c"
        // the old 6.5 euros at the end of the strand disappears and the Java garbage
        // collector takes care of it

        System.out.println(a); // 10.00e
        System.out.println(b); // 3.50e
        System.out.println(c); // 0.00e
    }
}
