import java.util.Scanner;

class RegularExpressions {
    /* part 1 */
    public static boolean isDayOfWeek(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    /* part 2 */
    public static boolean allVowels(String string) {
        return string.matches("(a|e|i|o|u)*");
    }

    /* part 3 -> https://github.com/d-holguin/mooc-java-programming-ii/blob/master/part10-Part10_15.RegularExpressions/src/main/java/Checker.java */
    public static boolean timeOfDay(String string) {
        //had to read this info else where as I didn't find the reading matierlaon  mooc.fi enought. I used java core vol 2
        if (string.matches("(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)")) {    //:? to not cap ':' only in parthese group
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (timeOfDay(string) == true)
            System.out.println("The form is correct.");
        else
            System.out.println("The form is incorrect.");

        scanner.close();
    }
}
