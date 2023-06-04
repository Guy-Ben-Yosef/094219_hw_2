/* This class represents a function which is a multiplication of two functions */
public class Product extends Function {
    Function f1;
    Function f2;

    /**
     * Constructor for Product
     * @param f1 a Function input
     * @param f2 a Function input
     */
    public Product(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    /**
     * @param x The coordinate at which to evaluate the function
     * @return the value of the product of the two functions at x
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) * f2.valueAt(x);
    }

    /**
     * @return A string representation of the product of the two functions
     */
    @Override
    public String toString() {
        return "(" + f1.toString() + " * " + f2.toString() + ")";
    }

    /**
     * @return the derivative of the product of the two functions
     */
    @Override
    public Sum derivative() {
        Function g1 = new Product(f1.derivative(), f2);
        Function g2 = new Product(f1, f2.derivative());

        return new Sum(g1, g2);
    }
}
