import java.util.Scanner;

public class Statistics {
    private int count, sum;

    public Statistics() {
        this.count = 0;
    }

    public void addNumber(int number) {
        count++;
        sum += number;
    }

    public int getCount() {
        return count;
    }

    public int sum() {
        return  sum;
    }

    public double average() {
        return (double) sum / count;
    }

    public static void main(String[] args) {
        // part 2
        Statistics statistics = new Statistics();
        statistics.addNumber(3);
        statistics.addNumber(5);
        statistics.addNumber(1);
        statistics.addNumber(2);
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.sum());
        System.out.println("Average: " + statistics.average());

        // part 3 && part 4
        Scanner scanner = new Scanner(System.in);
        Statistics allNums = new Statistics();
        Statistics oddNums = new Statistics();
        Statistics evenNums = new Statistics();
        int all, odd, even, num;

        while (true) {
            num = Integer.valueOf(scanner.nextLine());

            if (num == -1) break;

            if ((num % 2) == 0) {
                evenNums.addNumber(num);
                allNums.addNumber(num);
            } else {
                oddNums.addNumber(num);
                allNums.addNumber(num);
            }
        }
        System.out.println("Sum: " + allNums.sum());
        System.out.println("Sum of even numbers: " + evenNums.sum());
        System.out.println("Sum of odd numbers: " + oddNums.sum());
    }
}
