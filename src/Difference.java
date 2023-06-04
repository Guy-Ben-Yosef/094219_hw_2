/* This class represents a function which is the difference between two functions */
public class Difference extends Function {
    Function f1;
    Function f2;

    /**
     * Constructor for Difference
     * @param f1 a Function input
     * @param f2 a Function input
     */
    public Difference(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    /**
     * @param x The coordinate at which to evaluate the function
     * @return the value of the difference of the two functions at x
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) - f2.valueAt(x);
    }

    /**
     * @return A string representation of the difference of the two functions
     */
    @Override
    public String toString() {
        return "(" + f1.toString() + " - " + f2.toString() + ")";
    }

    /**
     * @return the derivative of the difference of the two functions
     */
    @Override
    public Difference derivative() {
        return new Difference(f1.derivative(), f2.derivative());
    }
}
