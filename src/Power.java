/* This class represents the power function. It is assumed that the exponent is natural number */
public class Power extends Function{
    Function f;
    int n;

    /**
     * Constructor for Power
     * @param f a Function input
     * @param n an integer input
     */
    public Power(Function f, int n) {
        this.f = f;
        this.n = n;
    }

    /**
     * @param x The coordinate at which to evaluate the function
     * @return the value of the power of the function at x
     */
    public double valueAt(double x) {
        return Math.pow(f.valueAt(x), n);
    }

    /**
     * @return A string representation of the power of the function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + "^" + n + ")";
    }

    /**
     * @return the derivative of the power of the function
     */
    public Function derivative() {
        if (n >= 2) {
            Function g = new Power(f, n - 1);
            return new MultiProduct(new Constant(n), g, f.derivative());
        } else {
            return f.derivative();
        }

    }
}
