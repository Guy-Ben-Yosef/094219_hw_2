/* This class represents a Constant number function */
public class Constant extends Function{
    protected double f;  // TODO: protected or final?

    /**
     * Constructor for Constant
     * @param number an int input
     */
    public Constant(double number){
        this.f = number;
    }

    /**
     * @param point the coordinate at which to evaluate the function
     * @return since it is constant function, this function always returns the constant
     */
    @Override
    public double valueAt(double point) { return f; }

    /**
     * @return a string representation of the constant
     */
    @Override
    public String toString() {
        String constantAsString;
        if (f%1 == 0) {
            constantAsString = Integer.toString((int) f);
        } else {
            constantAsString = Double.toString(f);
        }
        return "(" + constantAsString + ")";
    }

    /**
     * @return the derivative of the constant which is always zero
     */
    @Override
    public Constant derivative() {
        return new Constant(0);
    }
}