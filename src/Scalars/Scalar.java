package Scalars;

public interface Scalar {
    public Scalar addition(Scalar s);
    public Scalar multiplication(Scalar s);
    public Scalar addRational(Rational s);
    public Scalar addInteger(Integer s);
    public Scalar mulRational(Rational s);
    public Scalar mulInteger(Integer s);
    public Scalar power(int exponent);
    public Scalar neg();
    public int sign();
    public boolean isZero();
    public int getNumber();
}
