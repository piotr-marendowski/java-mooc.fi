public class OverloadedCounter {
    static class Counter {
        private int value;
     
        public Counter(int startValue) {
            this.value = startValue;
        }

        public Counter() {
            this(0);
        }

        public int value() {
            return value;
        }

        public void increase() {
            this.value++;
        }

        public void increase(int increaseBy) {
            if (increaseBy > 0)
                this.value += increaseBy;
        }

        public void decrease() {
            this.value--;
        }

        public void decrease(int decreaseBy) {
            if (decreaseBy > 0)
                this.value -= decreaseBy;
        }
    }
    
    public static void main(String[] args) {
        Counter counter = new Counter(1);

        counter.increase();
        System.out.println(counter.value());

        counter.increase(2);
        System.out.println(counter.value());

        counter.decrease(3);
        System.out.println(counter.value());

        counter.decrease();
        System.out.println(counter.value());
    }
}
