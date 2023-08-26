import java.util.ArrayList;
import java.util.Scanner;

class UserInterface {
    private Scanner scanner;
    private Points points;
    
    public UserInterface(Points points, Scanner scanner) {
        this.scanner = scanner;
        this.points = points;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");

        while(true) {
            int num = Integer.valueOf(scanner.nextLine());

            if (num == -1)
                break;
            else if (num > 100 || num < 0)
                continue;

            points.add(num);
        }

        System.out.println("Point average (all): " + points.getAverage());
        System.out.println("Point average (passing): " + ((points.getAverageOfPassing() == 0) ?
                    "-" : points.getAverageOfPassing()));
        System.out.println("Pass percentage: " + points.getPassPercentage());
        points.printGradeDistribution();
    }
}

class Points {
    private ArrayList<Integer> numbers;

    public Points() {
        this.numbers = new ArrayList<>();
    }

    public void add(int num) {
        numbers.add(num);
    }

    public double getAverage() {
        int sum = 0;
        int i = 0;

        for (; i < numbers.size(); i++)
            sum += numbers.get(i);

        return ((double) sum / i);
    }

    /* part 2 */
    public double getAverageOfPassing() {
        int sum = 0;
        int i = 0, j = 0;

        for (; i < numbers.size(); i++) {
            if (numbers.get(i) >= 50) {
                sum += numbers.get(i);
                j++;
            }
        }

        if (j == 0)
            return 0.0;

        return ((double) sum / j);

    }

    /* part 3 */
    public double getPassPercentage() {
        int i = 0, passed = 0;

        for (; i < numbers.size(); i++) {
            if (numbers.get(i) >= 50)
                passed++;
        }

        if (passed == 0)
            return 0.0;

        return (100 * passed / i);
        
    }

    /* part 4 */
    public void printGradeDistribution() {
        int[] grades = {0, 0, 0, 0, 0, 0};
        int num = 0;

        for (int i = 0; i < numbers.size(); i++) {
            num = numbers.get(i);
            if (num > 100 || num < 0)
                continue;

            if (num < 50) {
                grades[0]++;
                continue;
            } else if (num < 60) {
                grades[1]++;
                continue;
            } else if (num < 70) {
                grades[2]++;
                continue;
            } else if (num < 80) {
                grades[3]++;
                continue;
            } else if (num < 90) {
                grades[4]++;
                continue;
            } else if (num >= 90) {
                grades[5]++;
                continue;
            }
        }

        for (int j = (grades.length - 1); j >= 0; j--) {
            System.out.print(j + ": ");

            for (int k = 0; k < grades[j]; k++)
                System.out.print("*");
            
            System.out.println("");
        }
    }
}

public class GradeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Points points = new Points();

        UserInterface ui = new UserInterface(points, scanner);
        ui.start();
    }
}
