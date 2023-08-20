import java.util.Scanner;
import java.util.ArrayList;

class GradeRegister {
    private ArrayList<Integer> grades;
    private ArrayList<Integer> pointsList;

    public GradeRegister() {
        this.grades = new ArrayList<>();
        this.pointsList = new ArrayList<>();
    }

    public void addGradeBasedOnPoints(int points) {
        this.grades.add(pointsToGrades(points));
        this.pointsList.add(points);
    }

    public int numberOfGrades(int grade) {
        int count = 0;
        for (int received : this.grades) {
            if (received == grade) {
                count++;
            }
        }

        return count;
    }

    public static int pointsToGrades(int points) {

        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
    }

    /* part 1 */
    public double averageOfGrades() {
        int sum = 0;

        if (this.grades.isEmpty())
            return -1;

        for (int grade : grades) {
            sum += grade;
        }

        return ((double) sum / this.grades.size());
    }

    /* part 2 */
    public double averageOfPoints() {
        int sum = 0;

        if (this.pointsList.isEmpty())
            return -1;

        for (int point : pointsList) {
            sum += point;
        }

        return ((double) sum / this.pointsList.size());

    }
}

class UserInterface {
    private GradeRegister register;
    private Scanner scanner;

    public UserInterface(GradeRegister register, Scanner scanner) {
        this.register = register;
        this.scanner = scanner;
    }

    public void start() {
        readPoints();
        System.out.println("");
        printGradeDistribution();
    }

    public void readPoints() {
        while (true) {
            System.out.print("Points: ");
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            int points = Integer.valueOf(input);

            if (points < 0 || points > 100) {
                System.out.println("Impossible number.");
                continue;
            }

            this.register.addGradeBasedOnPoints(points);
        }
    }

    public void printGradeDistribution() {
        int grade = 5;
        while (grade >= 0) {
            int stars = register.numberOfGrades(grade);
            System.out.print(grade + ": ");
            printStars(stars);
            System.out.println("");

            grade = grade - 1;
        }

        System.out.println("The average of points: " + this.register.averageOfPoints());
        System.out.println("The average of grades: " + this.register.averageOfGrades());
    }

    public static void printStars(int stars) {
        while (stars > 0) {
            System.out.print("*");
            stars--;
        }
    }
}

public class Averages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeRegister grades = new GradeRegister();

        UserInterface ui = new UserInterface(grades, scanner);
        ui.start();
    }
}
