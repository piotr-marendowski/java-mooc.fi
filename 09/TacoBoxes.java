interface TacoBox {
    int tacosRemaining();
    void eat();
}

class TripleTacoBox implements TacoBox {
    private int tacos;

    public TripleTacoBox() {
        this.tacos = 3;
    }

    public int tacosRemaining() {
        return this.tacos;
    }

    public void eat() {
        this.tacos--;
    }
}

class CustomTacoBox {
    private int tacos;

    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }

    public int tacosRemaining() {
        return this.tacos;
    }

    public void eat() {
        this.tacos--;
    }
}

public class TacoBoxes {
    public static void main(String[] args) {
        TripleTacoBox triple = new TripleTacoBox();
        CustomTacoBox custom = new CustomTacoBox(10);

        System.out.println("Tacos remaining: " + triple.tacosRemaining());
        triple.eat();
        triple.eat();
        System.out.println("Tacos remaining: " + triple.tacosRemaining());
        
        System.out.println("\nTacos remaining: " + custom.tacosRemaining());
        custom.eat();
        custom.eat();
        custom.eat();
        custom.eat();
        System.out.println("Tacos remaining: " + custom.tacosRemaining());
    }
}
