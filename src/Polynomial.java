/* This class represents a Polynomial function */
public class Polynomial{
    private double[] coefficients;
    private String[] expression;

    /**
     * Constructor for Polynomial
     * @param coefficients
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
        this.expression = new String[coefficients.length];
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

            // adding the number if not 1/-1
            if(this.coefficients[i] != 1 || this.coefficients[i] != -1){
                this.expression[i] += (this.coefficients[i]);
            }

            this.expression[i] +=  ('x');
            this.expression[i] += ('^' + i);

            this.expression[i] +=  ('x');

            if (i != 1){
                this.expression[i] += ('^' + i);
            }

        }

        return String.join(" ", this.expression);
    }




}