/* This class represents a Constant number function */
public class Constant extends Function{
    protected double f;

    /**
     * Constructor for Constant
     * @param number an int input
     */
    public Constant(double number){
        this.f = number;
    }

    @Override
    public double valueAt(double point) {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(f);
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return 0;
    }

    @Override
    public String taylorPolynomial(int n) {
        return null;
    }
}