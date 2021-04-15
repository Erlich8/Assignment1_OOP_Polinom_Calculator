package Scalars;

public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0){
            this.denominator = denominator;
        }
    }

    @Override
    public String toString() {
        Rational temp = this.reduce();
        if (temp.getDenominator() == 1){
            return String.format("%d", temp.getNumerator());
        }
        else{
            return String.format("%d/%d", temp.getNumerator(), temp.getDenominator());
        }
    }

    public Rational reduce () {
        int num1 = Math.abs(numerator);
        int num2 = Math.abs(denominator);
        while (num1 != num2){
            if (num1 > num2){
                num1 -= num2;
            }
            else{
                num2 -= num1;
            }
        }
        return new Rational(numerator / num2, denominator / num2);
    }

    @Override
    public Scalar addition(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar multiplication(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        int new_numerator = s.getNumerator() * denominator + numerator * s.getDenominator();
        int new_denuminator = denominator * s.getDenominator();
        return new Rational(new_numerator, new_denuminator);
    }

    @Override
    public Scalar addInteger(Integer s) {
        int num_add = s.getNumber() * denominator;
        return new Rational(numerator + num_add, denominator).reduce();
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(numerator * s.getNumerator(), denominator * s.getDenominator()).reduce();
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(s.getNumber() * numerator, denominator).reduce();
    }

    @Override
    public Scalar power(int exponent) {
        return new Rational(numerator ^ exponent, denominator ^ exponent).reduce();
    }

    @Override
    public int sign() {
        if (numerator == 0){
            return 0;
        }
        else if ((numerator / denominator) > 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    @Override
    public boolean isZero(){
       return this.getNumerator()==0;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
