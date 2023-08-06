import java.util.Scanner;

public class Agent {
    String firstname, lastname;

    public Agent(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String toString() {
        return "My name is " + this.lastname + ", " + this.firstname + " " + this.lastname;
    }

    public static void main(String[] args) {
        Agent bond = new Agent("James", "Bond");

        bond.toString(); // prints nothing
        System.out.println(bond);

        Agent ionic = new Agent("Ionic", "Bond");
        System.out.println(ionic);
    }
}
