class Calculator {
    // part 2
    public int factorial(int num) {
        if (num < 0)
            throw new IllegalArgumentException("Number is negative");

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (setSize < 0 && subsetSize > setSize)
            throw new IllegalArgumentException("Wrong setSize or subsetSize");

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}

class Person {
    private String name;
    private int age;

    // part 1
    public Person(String name, int age) {
        if (name == null)
            throw new IllegalArgumentException("Name is null");

        if (name.isEmpty())
            throw new IllegalArgumentException("Name is empty");

        if(name.length() > 40)
            throw new IllegalArgumentException("Name is too long");

        if(age < 0 || age > 120)
            throw new IllegalArgumentException("Age is invalid");

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ValidatingParameters {
    public static void main(String[] args) {
        // Person mike = new Person("", 130);
        Calculator calc = new Calculator();

        System.out.println(calc.factorial(-1));
        System.out.println(calc.binomialCoefficent(4, 2));
    }
}
