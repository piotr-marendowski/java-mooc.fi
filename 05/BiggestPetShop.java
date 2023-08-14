import java.util.Scanner;

public class BiggestPetShop {
    static class Person {
        private String name;
        private Pet pet;

        public Person(String name, Pet pet) {
            this.name = name;
            this.pet = pet;
        }

        public Person(String name) {
            this(name, new Pet("Toothless", "dragon"));
        }

        public Person() {
            this("Lilo", new Pet("Stitch", "blue alien"));
        }

        @Override
        public String toString() {
            return this.name + "," + " has a friend called " + pet.getName() + " (" + pet.getBreed() + ")";
        }
    }

    static class Pet {
        private String name;
        private String breed;

        public Pet(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public String getBreed() {
            return breed;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pet hulda = new Pet("Lucy", "Golden retriever");
        Person leo = new Person("Leo", hulda);

        System.out.println(leo);
    }
}
