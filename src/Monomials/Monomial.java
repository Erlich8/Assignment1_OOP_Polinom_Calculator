package Monomials;
import Scalars.*;
import Scalars.Integer;


public class Monomial {
    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }


    public Monomial add(Monomial m) {
        if(this.exponent != m.exponent)
            return null;
        return new Monomial(m.exponent, this.coefficient.addition(m.coefficient));
    }

    public Monomial mult(Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.multiplication(m.coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return this.coefficient.multiplication(s).power(this.exponent);
    }

    public Monomial derivative() {
        return new Monomial(this.exponent - 1, this.coefficient.multiplication(new Integer(this.exponent)));
    }

    public int sign() {
        int sign = this.coefficient.sign();
        if(sign  == 0) return -1;
        return sign;
    }

    //    if(this.exponent > 1) {
    //        if(this.coefficient.sign() == 1) {
    //            // remove 1
    //        } else if(this.coefficient.sign() == -1) {
    //            // remove 1 and stay '-'
    //        }
    //    } else if(this.exponent == 1) {
    //        // remove exp
    //    }
    @Override
    public String toString() {

        switch(this.exponent) {
            case(0): return this.coefficient.toString();
            case(1): return this.coefficient.toString()+"X";
            default: {
                int sign = this.coefficient.sign();
                if(sign < 0) {
                    return "" + this.coefficient.toString() + "X^" + this.exponent;
                }
                return this.coefficient.toString() + "X^" + this.exponent;
            }
        }
    }
}
