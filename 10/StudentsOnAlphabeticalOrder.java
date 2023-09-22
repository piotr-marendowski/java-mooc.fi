class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student comparedStudent) {
        return this.name.compareTo(comparedStudent.getName());
    }
}

public class StudentsOnAlphabeticalOrder {
    public static void main(String[] args) {
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        /* -1 because comes before */
        System.out.println(first.compareTo(second));
    }
}
