/* part 1 */
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    } 

    public void eat() {
        System.out.println(this.name + " eats");
    }

    public void sleep() {
        System.out.println(this.name + " sleeps");
    }

    public String getName() {
        return this.name;
    }
}
/* part 4 */
interface NoiseCapable {
    public void makeNoise();
}
/* part 2 */
class Dog extends Animal implements NoiseCapable {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super("Dog");
    } 

    public void bark() {
        System.out.println(super.getName() + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    }
}
/* part 3 */
class Cat extends Animal implements NoiseCapable {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super("Cat");
    } 

    public void purr() {
        System.out.println(super.getName() + " purrs");
    }

    @Override
    public void makeNoise() {
        this.purr();
    }
}

public class Animals {
    public static void main(String[] args) {
        NoiseCapable dog = new Dog();
        dog.makeNoise();

        NoiseCapable cat = new Cat("Garfield");
        cat.makeNoise();
        Cat c = (Cat) cat;
        c.purr();
    }
}
