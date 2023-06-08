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
    public Date(int y, int m, int d) {
        this.day = d;
        this.month = m;
        this.year = y;

        // Input validation
        if (this.day < 1 || this.day > 31) {
            this.day = 1;
        } else if (this.month < 1 || this.month > 12) {
            this.month = 1;
        } else if (this.year < -3999 || this.year > 3999) {
            this.year = 0;
        }
    }

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 0;
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
        if (Math.abs(this.year) < 10) {
            yearString = "000" + Math.abs(this.year);
        } else if (Math.abs(this.year) < 100) {
            yearString = "00" + Math.abs(this.year);
        } else if (Math.abs(this.year) < 1000) {
            yearString = "0" + Math.abs(this.year);
        } else {
            yearString = "" + Math.abs(this.year);
        }
        if (this.year < 0){
            return dayString + "/" + monthString + "/" + "-" + yearString;
        }

        return dayString + "/" + monthString + "/" + yearString;


    }

    /**
     * @param o object to compare
     * @return true if the object is a Date and has the same day, month and year
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o instanceof Date) {
            Date d = (Date) o;
            if (d.hashCode() != o.hashCode()) { return false;}
        } else { return false; }

        return (this.hashCode() == o.hashCode());
    }

    /**
     * @return hashcode of the date
     */
    @Override
    public int hashCode() {
        int daysInMonth = 31;
        int monthsInYear = 12;

        // The hashcode of a Date is the day plus the month plus the year in days
        int code = this.day + (this.month - 1) * daysInMonth + Math.abs(this.year) * daysInMonth * monthsInYear;
        if (year < 0) {  // if the year is negative, make the hashcode negative
            return -code;
        } else {
            return code;
        }
    }
}
