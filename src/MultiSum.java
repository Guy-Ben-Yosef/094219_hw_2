/* This class represents a chain of `Sum` objects */
// TODO: Maybe this class should be an extension of `Sum`?
// TODO: Note that I didn't use `Sum` class at all in this class, is it making sense?
public class MultiSum extends Function{
    private final Function[] functions;

    /**
     * Constructor for MultiSum
     * @param functions an array of Function inputs
     */
    public MultiSum(Function... functions){
        this.functions = functions;
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
        for (Function function : functions) {  // Iterate over the functions in the chain
            resultString.append(function.toString());  // Append the string representation of the i-th function
            resultString.append(" + ");  // Append plus sign
        }
        resultString.deleteCharAt(resultString.length() - 1);  // Remove the last plus sign TODO: in rules??
        return "(" + resultString.toString() + ")";
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
        return new MultiSum(derivatives);  // Return the derivative of the sum of the functions in the chain
    }
}
