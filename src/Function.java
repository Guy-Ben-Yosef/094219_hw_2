/* This class represents a mathematical function */
public abstract class Function{

    public abstract double valueAt(double point);
    public abstract String toString();
    public abstract Function derivative();

    /**
     * Implements the bisection method to find the root of a function within a given interval. The bisection method is
     * an iterative algorithm that repeatedly bisects the interval and selects a sub-interval.
     * @param a The left endpoint of the interval
     * @param b The right endpoint of the interval
     * @param epsilon The desired precision for the root approximation
     * @return The root of the function within the given interval, with the specified precision
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;   // Left endpoint of the interval
        double right = b;  // Right endpoint of the interval
        double middle = (left + right) / 2;     // Midpoint of the interval
        while (right - left > epsilon)  {  // Repeat until desired precision is reached
            middle = (left + right) / 2;           // Calculate the midpoint
            double valAtLeft = valueAt(left);      // Evaluate the function at the left endpoint
            double valAtMiddle = valueAt(middle);  // ...

            if (valAtLeft * valAtMiddle > 0) {  // Check if the root is in the left sub-interval
                left = middle;  // Adjust the interval to the left sub-interval
            } else {  // Root is in the right sub-interval
                right = middle;  // Adjust the interval to the right sub-interval
            }
        }
        return (left + right) / 2;  // Return the approximate root
    }

    /**
     * Implementation of bisectionMethod with default epsilon value
     */
    public double bisectionMethod(double a, double b){
        return bisectionMethod(a, b, 1e-5);
    }

    /**
     * Implements the Newton-Raphson method to approximate the root of a function. The Newton-Raphson method is an
     * iterative algorithm that starts with an initial guess for the root and updates the guess by using the function's
     * value and derivative until the desired precision is reached.
     * @param a The initial guess for the root.
     * @param epsilon The desired precision for the root approximation.
     * @return The approximated root of the function.
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;  // Initial guess for the root
        double fPrime;
        Function prime = derivative();  // Derivative of the function

        while (Math.abs(valueAt(x)) >= epsilon) {  // Repeat until desired precision is reached
            fPrime = prime.valueAt(x);  // Evaluate the derivative of the function at x
            x -= valueAt(x) / fPrime;  // Update x with the new approximation
        }

        return x;
    }

    /**
     * Implementation of newtonRaphsonMethod with default epsilon value
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, 1e-5);
    }

    /**
     * Computes the Taylor polynomial of the given function up to the nth degree. The Taylor polynomial approximates the
     * function using a polynomial with coefficients computed from the derivatives of the function at zero.
     * @param n The degree of the Taylor polynomial.
     * @return A Polynomial object representing the Taylor polynomial of the given function.
     */
    public Polynomial taylorPolynomial(int n) {
        double[] coefficients = new double[n+1];  // Array to store the coefficients of the Taylor polynomial
        double kthDerivativeAtZero;
        coefficients[0] = this.valueAt(0);  // Coefficient of the constant term in the Taylor polynomial

        Function kthDerivative = this.derivative();  // Derivative of the function
        for (int k = 1; k <= n; k++) {
            kthDerivativeAtZero = kthDerivative.valueAt(0);  // Compute the value of the k-th derivative at zero
            coefficients[k] = kthDerivativeAtZero / Helper.factorial(k);  // Compute the coefficient of the k-th term

            kthDerivative = kthDerivative.derivative(); // Update the k-th derivative to the next derivative
        }

        // Create a new Polynomial object with the computed coefficients and return it:
        return new Polynomial(coefficients);
    }
}
