package Scalars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    private Rational rational1;
    private Rational rational2;
    private Rational negrational1;
    private Rational negrational2;
    private Rational int1;
    private Rational zero1;
    private Rational zero2;
    private Integer int2;
    private Rational dans_rational;

    @BeforeEach
    void setUp() {
        rational1 = new Rational(121, 55);
        rational2 = new Rational(24, 35);
        negrational1 = new Rational(-121, 55);
        negrational2 = new Rational(121, -55);
        int1 = new Rational(121, 121);
        zero1 = new Rational(0, 55);
        zero2 = new Rational(121, 0);
        int2 = new Integer(2);
        dans_rational = new Rational(0,2);
    }

    @Test
    void reduce() {
        Assertions.assertEquals("11/5", rational1.reduce().toString());
        Assertions.assertEquals("-11/5", negrational1.reduce().toString());
        Assertions.assertEquals("-11/5", negrational2.reduce().toString());
        Assertions.assertEquals("24/35", rational2.reduce().toString());
        Assertions.assertEquals("1", int1.reduce().toString());
        Assertions.assertEquals("0", zero1.reduce().toString());
        Assertions.assertEquals("0", zero2.reduce().toString());




    }

    @Test
    void addition() {
        Assertions.assertEquals("101/35", rational1.addition(rational2).toString());
        Assertions.assertEquals("0", rational1.addition(negrational1).toString());
        Assertions.assertEquals("0", rational1.addition(negrational2).toString());
        Assertions.assertEquals("-53/35", rational2.addition(negrational2).toString());
        Assertions.assertEquals("-53/35", rational2.addition(negrational1).toString());
        Assertions.assertEquals("-53/35", negrational2.addition(rational2).toString());
        Assertions.assertEquals("11/5", rational1.addition(zero1).toString());
        Assertions.assertEquals("-11/5", negrational2.addition(zero2).toString());
        Assertions.assertEquals("53/35", rational2.neg().addition(rational1).toString());
        Assertions.assertEquals("-22/5", negrational2.addition(negrational1).toString());
    }
    @Test
    void integer_addition(){
        Assertions.assertEquals("-1/5", negrational1.addition(int2).toString());
        Assertions.assertEquals("-1/5", int2.addition(negrational1).toString());
        Assertions.assertEquals("-1/5", negrational2.addition(int2).toString());
        Assertions.assertEquals("94/35", rational2.addition(int2).toString());
        Assertions.assertEquals("3", int1.addition(int2).toString());
        Assertions.assertEquals("2", zero1.addition(int2).toString());
    }

    @Test
    void multiplication() {
        Assertions.assertEquals("264/175", rational1.multiplication(rational2).toString());
        Assertions.assertEquals("-121/25", rational1.multiplication(negrational1).toString());
        Assertions.assertEquals("-121/25", rational1.multiplication(negrational2).toString());
        Assertions.assertEquals("-264/175", rational2.multiplication(negrational2).toString());
        Assertions.assertEquals("-264/175", rational2.multiplication(negrational1).toString());
        Assertions.assertEquals("-264/175", negrational2.multiplication(rational2).toString());
        Assertions.assertEquals("0", rational1.multiplication(zero1).toString());
        Assertions.assertEquals("0", negrational2.multiplication(zero2).toString());
        Assertions.assertEquals("-11/5", negrational2.multiplication(int1).toString());
    }

    @Test
    void integer_multipication(){
        Assertions.assertEquals("-22/5", negrational1.multiplication(int2).toString());
        Assertions.assertEquals("-22/5", int2.multiplication(negrational1).toString());
        Assertions.assertEquals("-22/5", negrational2.multiplication(int2).toString());
        Assertions.assertEquals("48/35", rational2.multiplication(int2).toString());
        Assertions.assertEquals("2", int1.multiplication(int2).toString());
        Assertions.assertEquals("0", zero1.multiplication(int2).toString());
    }

    @Test
    void power() {
        Assertions.assertEquals("1", rational1.power(0).toString());
        Assertions.assertEquals("1", negrational1.power(0).toString());
        Assertions.assertEquals("11/5", rational1.power(1).toString());
        Assertions.assertEquals("-11/5", negrational1.power(1).toString());
        Assertions.assertEquals("121/25", rational1.power(2).toString());
        Assertions.assertEquals("0", dans_rational.power(2).toString());

    }

    @Test
    void neg() {
        Assertions.assertEquals("-11/5", rational1.neg().toString());
        Assertions.assertEquals("11/5", negrational1.neg().toString());
        Assertions.assertEquals("11/5", negrational2.neg().toString());
        Assertions.assertEquals("-24/35", rational2.neg().toString());
        Assertions.assertEquals("-1", int1.neg().toString());
        Assertions.assertEquals("0", zero1.neg().toString());
    }

    @Test
    void sign() {
        Assertions.assertEquals(1, rational1.sign());
        Assertions.assertEquals(-1, negrational1.sign());
        Assertions.assertEquals(-1, negrational2.sign());
        Assertions.assertEquals(1, rational2.sign());
        Assertions.assertEquals(1, int1.sign());
        Assertions.assertEquals(0, zero1.sign());
        Assertions.assertEquals(0, dans_rational.sign());
    }
}