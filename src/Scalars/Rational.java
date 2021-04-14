package Scalars;

public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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
        return new Rational(s.getNumerator() + numerator, denominator);
    }

    @Override
    public Scalar addInteger(Integer s) {
        int num_add = s.getNumber() * denominator;
        return new Rational(numerator + num_add, denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return null;
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
