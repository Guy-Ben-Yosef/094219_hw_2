/* This class represents a date in the Gregorian calendar */
public class Date {
    int day;
    int month;
    int year;

    /**
     * @param d day
     * @param m month
     * @param y year
     */
    public Date(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    /**
     * @param o object to compare
     * @return true if the object is a Date and has the same day, month and year
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;  // cast the object to a Date
            return this.day == d.day && this.month == d.month && this.year == d.year;
        }
        return false;
    }

    /**
     * @return hashcode of the date
     */
    @Override
    public int hashCode() {
        return this.day + this.month + this.year;
    }
}
