package Scalars;

public class Integer implements Scalar {
    private int number;

    public Integer(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%d", number);
    }

    @Override
    public Scalar addition(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar multiplication(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        int num_add = number * s.getDenominator();
        return new Rational(num_add + s.getNumerator(),s.getDenominator()).reduce(); //add reduce
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(number + s.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(number * s.getNumerator(),s.getDenominator()); //add reduce
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(number * s.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new Integer(number ^ exponent);
    }

    @Override
    public Scalar neg() {
        return new Integer(number * (-1));
    }

    @Override
    public int sign() {
        if (number == 0){
            return number;
        }
        else{
            return number / Math.abs(number);
        }
    }
    @Override
    public boolean isZero(){
        return this.getNumber()==0;
    }

    public int getNumber() {
        return number;
    }
}
