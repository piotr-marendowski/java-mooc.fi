public class ComparingApartments {
    static class Apartment {
        private int rooms;
        private int squares;
        private int pricePerSquare;

        public Apartment(int rooms, int squares, int pricePerSquare) {
            this.rooms = rooms;
            this.squares = squares;
            this.pricePerSquare = pricePerSquare;
        }

        /* part 1 */
        public boolean largerThan(Apartment compared) {
            return (this.squares > compared.squares);
        }

        /* part 2 */
        public int priceDifference(Apartment compared) {
            return Math.abs((this.pricePerSquare * this.squares) - (compared.pricePerSquare * compared.squares));
        }

        /* part 3 */
        public boolean moreExpensiveThan(Apartment compared) {
            return (this.pricePerSquare * this.squares) > (compared.pricePerSquare * compared.squares);
        }
    }

    public static void main(String[] args) {
        Apartment manhattanStudioApt = new Apartment(1, 16, 5500);
        Apartment atlantaTwoBedroomApt = new Apartment(2, 38, 4200);
        Apartment bangorThreeBedroomApt = new Apartment(3, 78, 2500);

        System.out.println(manhattanStudioApt.largerThan(atlantaTwoBedroomApt));                // false
        System.out.println(bangorThreeBedroomApt.largerThan(atlantaTwoBedroomApt));             // true

        System.out.println(manhattanStudioApt.priceDifference(atlantaTwoBedroomApt));           // 71600
        System.out.println(bangorThreeBedroomApt.priceDifference(atlantaTwoBedroomApt));        // 35400 
        
        System.out.println(manhattanStudioApt.moreExpensiveThan(atlantaTwoBedroomApt));         // false
        System.out.println(bangorThreeBedroomApt.moreExpensiveThan(atlantaTwoBedroomApt));      // true
    }
}
