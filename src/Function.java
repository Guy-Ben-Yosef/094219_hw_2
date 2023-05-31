/* This class represents a mathematical function */
public abstract class Function{

    public abstract double valueAt(double point);
    public abstract String toString();
    public abstract Function derivative();
    public abstract double bisectionMethod(int a, int b, double epsilon);
    public abstract double bisectionMethod(int a, int b);
    public abstract double newtonRaphsonMethod(int a, double epsilon);
    public abstract double newtonRaphsonMethod(int a);
    public abstract String taylorPolynomial(int n);

}
