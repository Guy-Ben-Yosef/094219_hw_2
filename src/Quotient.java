/* This class represents rational function */
public class Quotient extends Function {
    Function numerator;
    Function denominator;

    /**
     * Constructor for Quotient
     * @param numerator The numerator of the rational function
     * @param denominator The denominator of the rational function
     */
    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @param x The coordinate at which to evaluate the function
     * @return the value of the rational function at x
     */
    @Override
    public double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    /**
     * @return The string representation of the rational function
     */
    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }

    /**
     * @return The derivative of the rational function
     */
    @Override
    public Quotient derivative() {
        Function fPrimeTimesG = new Product(numerator.derivative(), denominator);  // f' * g
        Function gPrimeTimesF = new Product(numerator, denominator.derivative());  // g' * f
        Function newNumerator = new Difference(fPrimeTimesG, gPrimeTimesF);  // f' * g - g' * f
        Function newDenominator = new Power(denominator, 2);  // g^2
        return new Quotient(newNumerator, newDenominator);  // (f' * g - g' * f) / g^2
    }
}
