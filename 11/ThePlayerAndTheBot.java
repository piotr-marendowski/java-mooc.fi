public class ThePlayerAndTheBot {
    class Player {
        private String name;

        public void play() {
            System.out.println("Play");
        }

        public void printName() {
            System.out.println(this.name);
        }
    }

    class Bot extends Player {
        public void play() {
            System.out.println("Play");
        }

        public void addMove(String move) {
            System.out.println(move);
        }
    }
}
