/* This class represents a chain of `Product` objects */
public class MultiProduct extends Function {
    private final Function[] functions;

    /**
     * Constructor for MultiProduct
     * @param functions an array of Function inputs
     */
    public MultiProduct(Function function1, Function function2, Function... functions){
        this.functions = new Function[2 + functions.length]; // total length

        this.functions[0] = function1;
        this.functions[1] = function2;

        for(int i = 0; i < functions.length; i++){ // loop all over the varargs
            this.functions[2 + i] = functions[i];
        }
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
        for (int i = 0; i < functions.length; i++) {  // Iterate over the functions in the chain
            resultString.append(functions[i].toString());  // Append the string representation of the i-th function

            if (i == functions.length - 1){break;} // Skipping the last multiplication sign and spaces: " * "
            resultString.append(" * ");  // Append multiplication sign
        }

        return "(" + resultString + ")";
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
            Function[] iMultipliedFunctions = new Function[functions.length];
            iMultipliedFunctions[0] = functions[i].derivative();  // Compute the derivative of the i-th function
            int counter = 1;
            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    iMultipliedFunctions[counter] = functions[j];  // Assign the j-th function as it is
                    counter++;
                }
            }
            // Create a MultiProduct object with the multiplied functions:
            derivatives[i] = new MultiProduct(iMultipliedFunctions[0], iMultipliedFunctions[1], Helper.removeFirstTwo(iMultipliedFunctions));
        }
        return new MultiSum(derivatives[0],derivatives[1], Helper.removeFirstTwo(derivatives));  // Create a new MultiSum object with the derivative functions and return it
    }
}
