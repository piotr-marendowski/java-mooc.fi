import java.util.Scanner;

public class LiquidContainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int container1 = 0;
        int container2 = 0;
        
        while (true) {
            System.out.println("First: " + container1 + "/100");
            System.out.println("Second: " + container2 + "/100");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("quit")) {
                break;
            } else if (command.equals("add")) {
                if ((container1 + amount) >= 100)
                    container1 = 100;
                else
                    container1 += amount;
            } else if (command.equals("move")) {
                if ((amount + container2) > 100) {
                    container2 = 100;
                    container1 -= amount;
                    continue;
                } 

                if (amount > container1) {
                    container2 += container1;
                    container1 = 0;
                } else {
                    container2 += amount;
                    container1 -= amount;
                }
            } else if (command.equals("remove")) {
                if (amount > container2) {
                    container2 = 0;
                } else
                    container2 -= amount;
            }
        }
    }
}
