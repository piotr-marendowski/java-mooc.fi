public class DatingApp {
    static class SimpleDate {
        private int day;
        private int month;
        private int year;

        public SimpleDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public String toString() {
            /* if day is less than 10, then print e.g. 04 not 4 */
            return (this.day < 10 ? "0" + this.day : this.day) + "." + this.month + "." + this.year;
        }

        public boolean before(SimpleDate compared) {
            // first compare years
            if (this.year < compared.year) {
                return true;
            }

            // if the years are the same, compare months
            if (this.year == compared.year && this.month < compared.month) {
                return true;
            }

            // the years and the months are the same, compare days
            if (this.year == compared.year && this.month == compared.month &&
                    this.day < compared.day) {
                return true;
            }

            return false;
        }

        /* part 1 */
        public void advance() {
            this.day++;
            if (this.day == 30) {
                this.month++;
                this.day = 1;
                if (this.month == 12) {
                    this.year++;
                    this.month = 1;
                }
            }
        }

        /* part 2 */
        public void advance(int howManyDays) {
            for (int i = 0; i < howManyDays; i++)
                advance();
        }

        /* part 3 */
        public SimpleDate afterNumberOfDays(int days) {
            SimpleDate newDate = new SimpleDate(this.day, this.month, this.year);

            for (int i = 0; i < days; i++)
                newDate.advance();

            return newDate;
        }
    }

    public static void main(String[] args) {
        SimpleDate date = new SimpleDate(13, 2, 2015);
        System.out.println("Friday of the examined week is " + date);

        SimpleDate newDate = date.afterNumberOfDays(7);
        int week = 1;
        while (week <= 7) {
            System.out.println("Friday after " + week + " weeks is " + newDate);
            newDate = newDate.afterNumberOfDays(7);

            week = week + 1;
        }

        System.out.println("The date after 790 days from the examined Friday is ... try it out yourself!");
        System.out.println("Try " + date.afterNumberOfDays(790));
    }
}
