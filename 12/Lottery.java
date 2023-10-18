import java.util.ArrayList;
import java.util.Random;

public class Lottery {
    private ArrayList<Integer> numbers;
    private Random random;

    public Lottery() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        for (int num: this.numbers) {
            if (num == number)
                return true;
        }

        return false;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        this.random = new Random();

        for (int i = 0; i < 7; i++)
            this.numbers.add(i, random.nextInt(40) + 1);
    }

    public boolean equals(Object other) {
        return false;
    }

    public static void main(String[] args) {
        Lottery row = new Lottery();
        ArrayList<Integer> lotteryNumbers = row.numbers();

        System.out.println("Lottery numbers:");
        for (int number: lotteryNumbers) {
            System.out.print(number + " ");
        }

        System.out.println("");
    }
}
