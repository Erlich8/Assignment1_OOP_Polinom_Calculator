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
        String coff = coefficient.toString();
        String expo = "X^" + exponent;


        if(this.coefficient.toString().equals("-1")) {
            coff = "-";
            expo = "X^" + this.exponent;
        }
        if (this.coefficient.toString().equals("1")) {
            coff = "";
            expo = "X^" + this.exponent;
        }
        if(this.exponent == 1){
            expo = "X";
        }
        if(this.exponent == 0){
            coff = this.coefficient + "";
            expo = "";
        }
        if (this.coefficient.toString().equals("0")) {
            coff = "0";
            expo = "";
        }
        return coff + expo;
    }
}
