public class CardPayments {
    /* part 1 */
    static class PaymentCard {
        private double balance;

        public PaymentCard(double balance) {
            this.balance = balance;
        }

        public double balance() {
            return this.balance;
        }

        public void addMoney(double increase) {
            this.balance = this.balance + increase;
        }

        public boolean takeMoney(double amount) {
            // implement the method so that it only takes money from the card if
            // the balance is at least the amount parameter.
            // returns true if successful and false otherwise
            if (this.balance >= amount) {
                this.balance -= amount;
                return true;
            } else return false;
        }
    }

    /* part 2 */
    static class PaymentTerminal {
        private double money;           // amount of cash
        private int affordableMeals;    // number of sold affordable meals
        private int heartyMeals;        // number of sold hearty meals

        public PaymentTerminal() {
            this.money = 1000.0;
            this.affordableMeals = 0;
            this.heartyMeals = 0;
        }

        public double eatAffordably(double payment) {
            if (payment >= 2.50) {
                this.money += 2.50;
                this.affordableMeals++;
                return (payment - 2.50);
            } else return payment;
        }

        public double eatHeartily(double payment) {
            if (payment >= 4.30) {
                this.money += 4.30;
                this.heartyMeals++;
                return (payment - 4.30);
            } else return payment;
        }

        /* part 3 */
        public boolean eatAffordably(PaymentCard card) {
            // an affordable meal costs 2.50 euros
            // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
            // otherwise false is returned
            if (card.balance() >= 2.50) {
                card.takeMoney(2.50);
                this.affordableMeals++;
                return true;
            } else return false;
        }

        public boolean eatHeartily(PaymentCard card) {
            // a hearty meal costs 4.30 euros
            // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
            // otherwise false is returned
            if (card.balance() >= 4.30) {
                card.takeMoney(4.30);
                this.heartyMeals++;
                return true;
            } else return false;
        }

        /* part 4 */
        public void addMoneyToCard(PaymentCard card, double sum) {
            card.addMoney(sum);
            this.money += sum;
        }

        public String toString() {
            return "money: " + money + ", number of sold afforable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
        }
    }

    public static void main(String[] args) {
        PaymentTerminal unicafeExactum = new PaymentTerminal();
        System.out.println(unicafeExactum);

        PaymentCard annesCard = new PaymentCard(2);

        System.out.println("amount of money on the card is " + annesCard.balance() + " euros");

        boolean wasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money: " + wasSuccessful);

        unicafeExactum.addMoneyToCard(annesCard, 100);

        wasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money: " + wasSuccessful);

        System.out.println("amount of money on the card is " + annesCard.balance() + " euros");

        System.out.println(unicafeExactum);
    }
}
