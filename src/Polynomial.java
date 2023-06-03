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
        // TODO: add comments and docstring
        // TODO: test
        StringBuilder resultString = new StringBuilder();
        double freeCoefficient = coefficients[0];
        if (freeCoefficient % 1 == 0) {
            resultString.append((int) Helper.abs(freeCoefficient));
        } else {
            resultString.append(Helper.abs(freeCoefficient));
        }
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
            String xToThePowerOf = "x^" + Integer.toString(i);
            resultString.append(xToThePowerOf);
        }
        return resultString.toString();
    }
}