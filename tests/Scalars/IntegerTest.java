package Scalars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    private Integer int1;
    private Integer minus1;
    private Integer zero;
    private Integer int2;
    private Integer int3;
    private Rational rational1;

    @BeforeEach
    void setUp() {
         int1 = new Integer(1);
         minus1 = new Integer(-1);
         zero = new Integer(0);
         int2 = new Integer(2);
         int3 = new Integer(3);
         rational1 = new Rational(121, 55);
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("1", int1.toString());
        Assertions.assertEquals("2", int2.toString());
        Assertions.assertEquals("3", int3.toString());
        Assertions.assertEquals("-1", minus1.toString());
        Assertions.assertEquals("0", zero.toString());
    }

    @Test
    void addition1() {
        Assertions.assertEquals("3", int1.addition(int2).toString());
    }
    @Test
    void addition2() {
        Assertions.assertEquals("3", int3.addition(zero).toString());
    }
    @Test
    void addition_rational(){
        Assertions.assertEquals("26/5", int3.addition(rational1).toString());
        Assertions.assertEquals("26/5", rational1.addition(int3).toString());
        Assertions.assertEquals("11/5", zero.addition(rational1).toString());
        Assertions.assertEquals("6/5", minus1.addition(rational1).toString());
        Assertions.assertEquals("16/5", int1.addition(rational1).toString());
        Assertions.assertEquals("-16/5", minus1.addition(rational1.neg()).toString());
    }

    @Test
    void multiplication1() {
        Assertions.assertEquals("2", int2.multiplication(int1).toString());
    }
    @Test
    void multiplication_rational() {
        Assertions.assertEquals("22/5", int2.multiplication(rational1).toString());
        Assertions.assertEquals("22/5", rational1.multiplication(int2).toString());
        Assertions.assertEquals("11/5", int1.multiplication(rational1).toString());
        Assertions.assertEquals("0", zero.multiplication(rational1).toString());
        Assertions.assertEquals("-11/5", minus1.multiplication(rational1).toString());
    }

    @Test
    void multiplication2() {
        Assertions.assertEquals("0", int2.multiplication(zero).toString());
    }

    @Test
    void power1() {
        Assertions.assertEquals("2", int2.power(1).toString());
    }
    @Test
    void power2() {
        Assertions.assertEquals("1", int2.power(0).toString());
    }

    @Test
    void neg1() {
            Assertions.assertEquals("-2", int2.neg().toString());
    }

    @Test
    void neg2() {
        Assertions.assertEquals("0", zero.neg().toString());
    }

    @Test
    void sign1() {
        Assertions.assertEquals(0, zero.sign());
    }

    @Test
    void sign2() {
        Assertions.assertEquals(1, int3.sign());
        Assertions.assertEquals(-1, int3.neg().sign());
    }
}