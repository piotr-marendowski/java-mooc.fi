public class Smallest {
    public static void main(String[] args) {
        int answer =  smallest(2, 7);
        System.out.println("Smallest: " + answer);
    }

    public static int smallest(int number1, int number2) {
        if (number1 < number2) {
            return number1;
        } else return number2;
    }
}
