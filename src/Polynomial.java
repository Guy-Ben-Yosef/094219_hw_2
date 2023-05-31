/* This class represents a Polynomial function */
public class Polynomial{
    private double[] coefficients;
    String expression;

    /**
     * Constructor for Polynomial
     * @param varargs of coefficients
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * showing the whole expression
     */
    @Override
    public String toString(){
        
        for(int i = 0; i < this.coefficients.length; i++){
            
            if (this.coefficients[i] == 0){
                continue;
            }

            //TODO: need to figure the -1,1

            this.expression.append(this.coefficients[i]);
            this.expression.append('x');

            if (i == 1){
                continue;
            }
            
            this.expression.append('^' + i);

        }

        return this.expression;
    }




}