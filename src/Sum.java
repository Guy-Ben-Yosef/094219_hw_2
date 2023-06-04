/* This class represents a summation of two functions */
public class Sum extends Function {
    Function f1;
    Function f2;

    /**
     * Constructor for Sum
     * @param f1 a Function input
     * @param f2 a Function input
     */
    public Sum(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    /**
     * @param x The coordinate at which to evaluate the function
     * @return the value of the sum of the two functions at x
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) + f2.valueAt(x);
    }

    /**
     * @return a string representation of the sum of the two functions
     */
    @Override
    public String toString() {
        return "(" + f1.toString() + "+" + f2.toString() + ")";
    }

    /**
     * @return the derivative of the sum of the two functions
     */
    @Override
    public Sum derivative() {
        return new Sum(f1.derivative(), f2.derivative());
    }
}
