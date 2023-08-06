import java.util.ArrayList;
import java.util.Scanner;

public class TelevisionProgramsMain {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<TelevisionProgram> programs = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) break;

            System.out.print("Duration: ");
            int duration = Integer.valueOf(scanner.nextLine());

            programs.add(new TelevisionProgram(name, duration));
        }

        System.out.print("Program's maximum duration? ");
        int max = Integer.valueOf(scanner.nextLine());

        for (TelevisionProgram i: programs) {
            if (i.getDuration() <= max)
                System.out.println(i);
        }
    }
}
