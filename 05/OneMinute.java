public class OneMinute {
    static class Timer {
        private ClockHand seconds; 
        private ClockHand hundred; 

        public Timer() {
            this.seconds = new ClockHand(60);
            this.hundred = new ClockHand(100);
        }

        public void advance() {
            this.hundred.advance();

            if (this.hundred.value() == 0)
                this.seconds.advance();
        }

        public String toString() {
            return seconds + ":" + hundred;
        }
    }

    static class ClockHand {
        private int value;
        private int limit;

        public ClockHand(int limit) {
            this.limit = limit;
            this.value = 0;
        }

        public void advance() {
            this.value = this.value + 1;

            if (this.value >= this.limit) {
                this.value = 0;
            }
        }

        public int value() {
            return this.value;
        }

        public String toString() {
            if (this.value < 10) {
                return "0" + this.value;
            }

            return "" + this.value;
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        while (true) {
            System.out.println(timer);
            timer.advance();

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
}
