/* This class represents a chain of `Product` objects */
// TODO: Maybe this class should be an extension of `Product`?
// TODO: Note that I didn't use `Product` class at all in this class, is it making sense?
public class MultiProduct extends Function {
    private final Function[] functions;

    /**
     * Constructor for MultiProduct
     * @param functions an array of Function inputs
     */
    public MultiProduct(Function... functions){
        this.functions = functions;
    }

    /**
     * @param point The coordinate at which to evaluate the function
     * @return The value of the product of the functions in the chain at a given point
     */
    @Override
    public double valueAt(double point) {
        double value = functions[0].valueAt(point);  // Variable to store the computed value of the product
        for (int i = 1; i < functions.length; i++) {  // Iterate over the functions in the chain
            value *= functions[i].valueAt(point);  // Multiply the contribution of the i-th term to the value
        }

        return value;
    }

    /**
     * @return A string representation of the product of the functions in the chain
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();  // StringBuilder to construct the result string
        for (Function function : functions) {  // Iterate over the functions in the chain
            resultString.append(function.toString());  // Append the string representation of the i-th function
            resultString.append(" * ");  // Append multiplication sign
        }
        resultString.deleteCharAt(resultString.length() - 1);  // Remove the last multiplication sign
        return "(" + resultString.toString() + ")";
    }

    /**
     * Computes the derivative of the MultiProduct function.
     * @return A MultiSum object representing the derivative of the MultiProduct function.
     */
    @Override
    public MultiSum derivative() {
        // Array to store the derivatives of the individual functions in the chain:
        Function[] derivatives = new Function[functions.length];  // Compute the derivative of the i-th function
        for (int i = 0; i < functions.length; i++) {  // Array to store the multiplied functions
            Function ithFunctionPrime = functions[i].derivative();
            Function[] iMultipliedFunctions = new Function[functions.length];
            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    iMultipliedFunctions[j] = functions[j];  // Assign the j-th function as it is
                } else {
                    iMultipliedFunctions[j] = ithFunctionPrime;  // Assign the derivative of the i-th function
                }
            }
            // Create a MultiProduct object with the multiplied functions:
            derivatives[i] = new MultiProduct(iMultipliedFunctions);
        }
        return new MultiSum(derivatives);  // Create a new MultiSum object with the derivative functions and return it
    }
}
