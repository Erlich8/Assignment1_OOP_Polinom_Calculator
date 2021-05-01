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
        int sign = this.coefficient.sign();
        if(sign  == 0) return -1;
        return sign;
    }

    @Override
    public String toString() {
        switch(this.exponent) {
            case(0): return this.coefficient.toString();
            case(1): return "X";
            default: {
                int temp = this.coefficient.getNumber();
                String str_num = "";
                if(temp == -1)
                    str_num += "-";
                else if(temp == 0)
                    return "0";
                else if(temp != 1)
                    str_num += this.coefficient.toString();
                return str_num + "X^" + this.exponent;
            }
        }
    }
}
