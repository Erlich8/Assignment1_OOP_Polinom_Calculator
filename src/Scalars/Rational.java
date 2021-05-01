package Scalars;

public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0){
            this.denominator = 1;
            this.numerator = 0;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    @Override
    public String toString() {
        Rational temp = this.reduce();
        if (temp.getNumerator() % temp.getDenominator() == 0){
            return String.format("%d", temp.getNumerator() / temp.getDenominator());
        }
        else{
            return String.format("%d/%d", temp.sign() * Math.abs(temp.getNumerator()), Math.abs(temp.getDenominator()));
        }
    }

    public Rational reduce () {
        int gcd = GCD(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    private int GCD (int num1, int num2){
        if (num2 == 0){
            return num1;
        }
        return GCD(num2, num1 % num2);
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
        return new Rational((int) Math.pow(numerator, exponent), (int) Math.pow(denominator, exponent)).reduce();
    }

    @Override
    public Scalar neg() {
        return new Rational(numerator * (-1), denominator);
    }

    @Override
    public int sign() {
        if (numerator == 0 || denominator == 0){
            return 0;
        }
        else if ((numerator < 0 ^ denominator < 0)){
            return -1;
        }
        else{
            return 1;
        }
    }

    @Override
    public boolean isZero(){
       return this.getNumerator()==0;
    }

    @Override
    public int getNumber() {
        return numerator / denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
