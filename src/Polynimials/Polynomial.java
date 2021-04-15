package Polynimials;

import Monomials.Monomial;
import Scalars.Integer;
import Scalars.Rational;
import Scalars.Scalar;

import java.util.HashMap; // import the HashMap class

public class Polynomial {
    private HashMap<java.lang.Integer, Monomial> monomials = new HashMap<java.lang.Integer, Monomial>();

    public Polynomial() {
    }

    public Polynomial(Monomial m) {
        monomials.put(m.getExponent(), m);
    }

    /**
     * build a polynom from a text
     * @param input the wanted text
     * @return polynom
     */
    public static Polynomial build(String input) {
        int i = 0;
        Polynomial p = new Polynomial();
        for (String num : input.split(" ")) {
            if (num.contains("/")) {
                int numerator=stringToInt(num.split("/")[0]);
                int denominator=stringToInt(num.split("/")[1]);
                p.monomials.put(i, new Monomial(i, new Rational(numerator,denominator)));
            } else {
                int intNum = stringToInt(num);
                p.monomials.put(i, new Monomial(i, new Integer(intNum)));

            }
            i++;
        }
        return p;
    }

    /**
     * add a polynom to polynom
     * @param p
     * @return addition of both polynom
     */
    public Polynomial add(Polynomial p) {
        Polynomial addPoly = new Polynomial();
        for (int i : p.monomials.keySet())
            addPoly.monomials.put(i, p.monomials.get(i));
        for (int i : this.monomials.keySet()) {
            if (addPoly.monomials.get(i) != null) {
                addPoly.monomials.put(i, this.monomials.get(i).add(addPoly.monomials.get(i)));
            } else {
                addPoly.monomials.put(i, this.monomials.get(i));
            }
        }
        return addPoly;
    }

    /**
     * mult a two polynom
     * @param p
     * @return multiplication of two polynom
     */
    public Polynomial mul(Polynomial p) {
        Polynomial mulPoly = new Polynomial();
        for (int i : p.monomials.keySet())
            for (int j : this.monomials.keySet()) {
                mulPoly.add(new Polynomial(this.monomials.get(j).mult(p.monomials.get(i))));
            }
        return mulPoly;
    }

    /**
     * evalute a polynom
     * @param s
     * @return evalution of polynom
     */
    public Scalar evaluate(Scalar s) {
        Rational sum = new Rational(0, 1);
        for (int i : this.monomials.keySet()) {
            sum.addition(this.monomials.get(i).evaluate(s));
        }
        return sum;
    }

    /**
     * derivative the polynom
     * @return
     */
    public Polynomial derivative() {
        Polynomial derivativePoly = new Polynomial();
        for (int i : this.monomials.keySet()) {
            derivativePoly.add(new Polynomial(this.monomials.get(i).derivative()));
        }
        return derivativePoly;
    }

    /**
     * convet string to int
     * @param number
     * @return int of the string
     */
    private static int stringToInt(String number) {
        int intNum = 0;
        int i = 0;
        boolean neg=false;
        if( number.charAt(i)=='-'){
            i++;
            neg=true;
        }
        for (; i < number.length(); i++) {
            intNum = intNum * 10 + number.charAt(i) - '0';
        }
        if(neg)
            intNum*=-1;
        return intNum;
    }

    @Override
    public String toString() {
        String s = "";
        Monomial m;
        int counter=0;
        for (int i : this.monomials.keySet()) {
            m = this.monomials.get(i);
            if(!m.getCoefficient().zero())
            {
            if (counter!=0)
                s += "+";
            s += m.toString();
            counter++;
            }

        }
        return s;
    }


}
