public class IdenticalTwins {
    static class SimpleDate {
        private int day;
        private int month;
        private int year;

        public SimpleDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int getDay() {
            return this.day;
        }

        public int getMonth() {
            return this.month;
        }

        public int getYear() {
            return this.year;
        }

        public boolean equals(Object compared) {
            if (this == compared) return true;

            if (!(compared instanceof SimpleDate)) return false;

            SimpleDate otherDate = (SimpleDate) compared;

            if (this.day == otherDate.day &&
                this.month == otherDate.month &&
                this.year == otherDate.year)
                return true;

            return false;
        }

        @Override
        public String toString() {
            return this.day + "." + this.month + "." + this.year;
        }
    }

    static class Person {
        private String name;
        private SimpleDate birthday;
        private int height;
        private int weight;

        public Person(String name, SimpleDate birthday, int height, int weight) {
            this.name = name;
            this.birthday = birthday;
            this.height = height;
            this.weight = weight;
        }

        public boolean equals(Object compared) {
            if (this == compared) return true;

            if (!(compared instanceof Person)) return false;

            Person otherPerson = (Person) compared;

            if (this.name.equals(otherPerson.name) &&
                this.birthday.equals(otherPerson.birthday) &&
                this.height == otherPerson.height &&
                this.weight == otherPerson.weight)
                return true;

            return false;
        }
    }

    public static void main(String[] args) {
        SimpleDate date = new SimpleDate(24, 3, 2017);
        SimpleDate date2 = new SimpleDate(23, 7, 2017);

        Person leo = new Person("Leo", date, 62, 9);
        Person lily = new Person("Lily", date2, 65, 8);

        if (leo.equals(lily)) {
            System.out.println("Is this quite correct?");
        }

        Person leoWithDifferentWeight = new Person("Leo", date, 62, 10);

        if (leo.equals(leoWithDifferentWeight)) {
            System.out.println("Is this quite correct?");
        }
    }
}
