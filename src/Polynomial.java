/* This class represents a Polynomial function */
public class Polynomial{
    private final double[] coefficients;

    /**
     * Constructor for Polynomial
     * @param coefficients
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * showing the whole expression
     */
    @Override
    public String toString(){
        StringBuilder resultString = new StringBuilder();
        // TODO: implement x^0
        for (int i = 1; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            if (coefficient == 0) {
                continue;
            }
            if (coefficient > 0) {
                resultString.append("+");
            } else {
                resultString.append("-");
            }
            if (coefficient != 1 && coefficient != -1) {
                if (coefficient % 1 == 0) {
                    resultString.append((int) Helper.abs(coefficient));
                } else {
                    resultString.append(Helper.abs(coefficient));
                }
            }
            resultString.append("x^" + Integer.toString(i));
        }
        return resultString.toString();
    }
}