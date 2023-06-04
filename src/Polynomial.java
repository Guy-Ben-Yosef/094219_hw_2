/* This class represents a Polynomial function */
public class Polynomial extends Function{
    private final double[] coefficients;

    /**
     * Constructor for Polynomial
     * @param coefficients
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Computes the value of the polynomial function at a given x-coordinate.
     * @param x The x-coordinate at which to evaluate the polynomial function.
     * @return The value of the polynomial function at the given x-coordinate.
     */
    @Override
    public double valueAt(double x){
        double value = 0;  // Variable to store the computed value of the polynomial
        for (int i = 0; i < coefficients.length; i++) {
            double a = coefficients[i];  // Coefficient of the i-th term
            double xPower = Math.pow(x, i);  // Compute the power of x
            value += a * xPower;  // Add the contribution of the i-th term to the value
        }
        return value;
    }


    /**
     * @return A string representation of the polynomial function.
     */
    @Override
    public String toString(){
        if (coefficients.length == 0) {  // For empty polynomials, return a polynomial of degree 0
            return new Constant(0).toString();
        }
        StringBuilder resultString = new StringBuilder();  // StringBuilder to construct the result string
        double freeCoefficient = coefficients[0];  // Coefficient of the free term
        boolean firstTermAppended = false;  // Boolean to determine if the first coefficient has been appended

        // Append the coefficient of the free term to the result string
        if ((freeCoefficient % 1 == 0) && (freeCoefficient != 0)) {
            resultString.append((int) freeCoefficient);
            firstTermAppended = true;
        } else if (freeCoefficient != 0){
            resultString.append(freeCoefficient);
            firstTermAppended = true;
        }

        // Iterate over the coefficients of the other terms
        for (int i = 1; i < coefficients.length; i++) {
            double coefficient = coefficients[i];  // Coefficient of the i-th term
            if (coefficient == 0) {  // Skip if the coefficient is zero
                continue;
            }
            if ((coefficient > 0) && (firstTermAppended)) {
                resultString.append(" + ");  // Append plus sign for positive coefficients
            } else if (firstTermAppended){
                resultString.append(" - ");  // Append minus sign for negative coefficients
            }

            // Append the absolute value of the coefficient if it is not 1 or -1
            if (coefficient != 1 && coefficient != -1) {
                if (coefficient % 1 == 0) {
                    resultString.append((int) Math.abs(coefficient));
                } else {
                    resultString.append(Math.abs(coefficient));
                }
            }
            String xToThePowerOf;  // String to store the term with the variable and exponent
            if (i == 1) {
                xToThePowerOf = "x";
            } else {
                xToThePowerOf = "x^" + Integer.toString(i);  // Term with the variable and exponent
            }
            resultString.append(xToThePowerOf);  // Append the term to the result string
            firstTermAppended = true;
        }
        return "(" + resultString.toString() + ")";
    }

    /**
     * Computes the derivative of a polynomial function.
     * @return A new Function object representing the derivative of the polynomial.
     */
    @Override
    public Polynomial derivative() {
        // For empty polynomials, return a polynomial of degree 0
        if (coefficients.length == 0) {
            return new Polynomial(0);
        }
        // Array to store the coefficients of the derivative polynomial:
        double[] newCoefficients = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            // Compute the coefficient of each term in the derivative polynomial
            newCoefficients[i-1] = coefficients[i] * i;
        }
        // Create a new Polynomial object with the derivative coefficients and return it
        return new Polynomial(newCoefficients);
    }
}