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

    /**
     * @return a date string in the format DD/MM/YYYY
     */
    public String toString() {
        String dayString, monthString, yearString;

        // add a leading zero if the day or month is less than 10
        if (this.day < 10) {
            dayString = "0" + this.day;
        } else {
            dayString = "" + this.day;
        }

        // add a leading zero if the month is less than 10
        if (this.month < 10) {
            monthString = "0" + this.month;
        } else {
            monthString = "" + this.month;
        }

        // add leading zeros if the year is less than 1000
        // TODO: What about negative years?
        if (this.year < 10) {
            yearString = "000" + this.year;
        } else if (this.year < 100) {
            yearString = "00" + this.year;
        } else if (this.year < 1000) {
            yearString = "0" + this.year;
        } else {
            yearString = "" + this.year;
        }
        return dayString + "/" + monthString + "/" + yearString;
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
        if (this.year < 0) {
            return -1 * (this.day + this.month - this.year);
        } else {
            return this.day + this.month + this.year;
        }
    }
}
