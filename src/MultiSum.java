/* This class represents a chain of `Sum` objects */
public class MultiSum extends Function {
    private final Function[] functions;

    /**
     * Constructor for MultiSum
     *
     * @param functions an array of Function inputs
     */
    public MultiSum(Function function1, Function function2, Function... functions) {
        this.functions = new Function[2 + functions.length]; // total length

        this.functions[0] = function1;
        this.functions[1] = function2;

        for (int i = 0; i < functions.length; i++) { // loop all over the varargs
            this.functions[2 + i] = functions[i];
        }
    }

    /**
     * @param point The coordinate at which to evaluate the function
     * @return The value of the sum of the functions in the chain at a given point
     */
    @Override
    public double valueAt(double point) {
        double value = 0;  // Variable to store the computed value of the sum
        for (Function function : functions) {  // Iterate over the functions in the chain
            value += function.valueAt(point);  // Add the contribution of the i-th term to the value
        }
        return value;
    }

    /**
     * @return A string representation of the sum of the functions in the chain
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();  // StringBuilder to construct the result string
        for (int i = 0; i < functions.length; i++) { // Iterate over the functions in the chain
            resultString.append(functions[i].toString());  // Append the string representation of the i-th function

            if (i == functions.length - 1){break;} // Skipping the last plus sign and spaces: " + "
            resultString.append(" + ");  // Append plus sign
        }

        return "(" + resultString + ")";
    }

    /**
     * @return The derivative of the sum of the functions in the chain
     */
    @Override
    public MultiSum derivative() {
        Function[] derivatives = new Function[functions.length];  // Array to store the derivatives of the functions in the chain
        for (int i = 0; i < functions.length; i++) {  // Iterate over the functions in the chain
            derivatives[i] = functions[i].derivative();  // Compute the derivative of the i-th function
        }
        return new MultiSum(derivatives[0], derivatives[1], Helper.removeFirstTwo(derivatives));  // Return the derivative of the sum of the functions in the chain    }
    }
}
