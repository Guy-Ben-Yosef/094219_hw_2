/* This class represents a negative of a function */
public class Negation extends Function{
    Function f;  // TODO: private final?

    public Negation(Function f) { this.f = f; }

    /**
     * @param point The coordinate at which to evaluate the function
     * @return the value of the negative of the function
     */
    @Override
    public double valueAt(double point) { return -f.valueAt(point); }

    /**
     * @return A string representation of the negate function
     */
    @Override
    public String toString() { return "(-" + f.toString() +")"; }

    /**
     * @return the negative of the derivative of the function
     */
    @Override
    public Negation derivative() { return new Negation(f.derivative()); }
}
