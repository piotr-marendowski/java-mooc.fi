import java.util.HashMap;

class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof SimpleDate))
            return false;

        SimpleDate comparedDate = (SimpleDate) object;

        if (this.day == comparedDate.day &&
            this.month == comparedDate.month &&
            this.year == comparedDate.year)
            return true;

        return false;
    }

    /* basically you just return which things in this object make
     * it unique => for 1900-2100 is the whole date, but for other is
     * only year so e.g. 1.1.1500 will be equal to 20.11.1500 */
    @Override
    public int hashCode() {
        if (this.year > 1900 && this.year < 2100)
            return this.day + this.month + this.year;

        return this.year;
    }
}

public class HashForDate {
    public static void main(String[] args) {
        SimpleDate d = new SimpleDate(1, 2, 2000);
        System.out.println(d.equals("heh"));
        System.out.println(d.equals(new SimpleDate(5, 2, 2012)));
        System.out.println(d.equals(new SimpleDate(1, 2, 2000)));
    }
}
