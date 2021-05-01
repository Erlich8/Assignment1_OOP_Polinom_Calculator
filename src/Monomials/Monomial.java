package Monomials;
import Scalars.*;
import Scalars.Integer;


public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        if(exponent < 0)
            this.exponent = 0;
        else
            this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
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
        return this.coefficient.multiplication(s.power(this.exponent));
    }

    public Monomial derivative() {
        return new Monomial(this.exponent - 1, this.coefficient.multiplication(new Integer(this.exponent)));
    }

    public int sign() {
        return this.coefficient.sign();
    }

    @Override
    public String toString() {
        if (this.exponent == 0) {
            return coefficient.toString();
        }
         else if (this.exponent == 1){
        return coefficient.toString() + "X";
    }
                else if (this.coefficient.toString().equals("-1"))
                    return "-X^" + this.exponent;
                else if (this.coefficient.toString().equals("0"))
                    return "0";
                else if (this.coefficient.toString().equals("1"))
                    return  "X^" + this.exponent;
                else {
                    return this.coefficient.toString() + "X^" + this.exponent;
                }
            }
        }