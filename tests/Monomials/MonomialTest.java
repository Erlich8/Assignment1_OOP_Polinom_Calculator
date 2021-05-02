package Monomials;

import Scalars.Integer;
import Scalars.Rational;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MonomialTest {
    private Monomial mzero;
    private Monomial coef1, coef2, coef3, coef4;
    private Monomial coef0, coef_neg1, coef_eq_exp;
    private Monomial exp0, exp_lt0, exp_gt0;

    private Monomial rt_coef1, rt_coef3, rt_coef4;
    private Monomial rt_coef0, rt_coef_neg1, rt_coef_eq_exp;
    private Monomial rt_exp0, rt_exp_lt0, rt_exp_gt0;
    private Monomial rt_one, rt_minusOne, rt_minusOne2;

    @BeforeEach
    void setUp() {
        // Integer
        mzero = new Monomial(0, new Integer(0));
        coef1 = new Monomial(2, new Integer(1));
        coef2 = new Monomial(5, new Integer(2));
        coef3 = new Monomial(5, new Integer(6));
        coef4 = new Monomial(5, new Integer(-6));
        coef0 = new Monomial(2, new Integer(0));
        coef_neg1 = new Monomial(2, new Integer(-1));
        coef_eq_exp = new Monomial(3, new Integer(3));
        exp0 = new Monomial(0, new Integer(10));
        exp_lt0 = new Monomial(-2, new Integer(3));
        exp_gt0 = new Monomial(8, new Integer(3));

        // Rational
        rt_coef1 = new Monomial(2, new Rational(0, 2));
        rt_coef3 = new Monomial(5, new Rational(6, 2));
        rt_coef4 = new Monomial(5, new Rational(-6, 20));
        rt_coef0 = new Monomial(2, new Rational(10, -3));
        rt_coef_neg1 = new Monomial(2, new Rational(-1, -8));
        rt_coef_eq_exp = new Monomial(3, new Rational(-11, -3));
        rt_exp0 = new Monomial(0, new Rational(1, 3));
        rt_exp_lt0 = new Monomial(-2, new Rational(1, 3));
        rt_exp_gt0 = new Monomial(8, new Rational(1, 3));
        rt_one = new Monomial(6, new Rational(6,6));
        rt_minusOne = new Monomial(6, new Rational(-6,6));
        rt_minusOne2 = new Monomial(6, new Rational(6,-6));
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("0", mzero.toString());
        Assertions.assertEquals("X^2", coef1.toString());
        Assertions.assertEquals("2X^5", coef2.toString());
        Assertions.assertEquals("6X^5", coef3.toString());
        Assertions.assertEquals("-6X^5", coef4.toString());
        Assertions.assertEquals("0", coef0.toString());
        Assertions.assertEquals("-X^2", coef_neg1.toString());
        Assertions.assertEquals("3X^3", coef_eq_exp.toString());
        Assertions.assertEquals("10", exp0.toString());
        Assertions.assertEquals("3", exp_lt0.toString()); // if we reseting the exponent to be 0 then it behaves like that
        Assertions.assertEquals("3X^8", exp_gt0.toString());
        Assertions.assertEquals("X^2", coef1.toString());
        Assertions.assertEquals("-X^2", coef_neg1.toString());



        Assertions.assertEquals("0", rt_coef1.toString());
        Assertions.assertEquals("3X^5", rt_coef3.toString());
        Assertions.assertEquals("-3/10X^5", rt_coef4.toString());
        Assertions.assertEquals("-10/3X^2", rt_coef0.toString());
        Assertions.assertEquals("1/8X^2", rt_coef_neg1.toString());
        Assertions.assertEquals("11/3X^3", rt_coef_eq_exp.toString());
        Assertions.assertEquals("1/3", rt_exp0.toString());
        Assertions.assertEquals("1/3", rt_exp_lt0.toString());
        Assertions.assertEquals("1/3X^8", rt_exp_gt0.toString());
        Assertions.assertEquals("X^6", rt_one.toString());
        Assertions.assertEquals("-X^6", rt_minusOne.toString());
        Assertions.assertEquals("-X^6", rt_minusOne2.toString());
    }

    @Test
    void addition1() {
        Assertions.assertNull(coef1.add(exp_gt0));
        Assertions.assertNull(rt_coef1.add(rt_exp_gt0));
    }
    @Test
    void addition2() {
        Assertions.assertEquals("0", coef1.add(coef_neg1).toString());
    }
    @Test
    void addition3() {
        Assertions.assertEquals("8X^5", coef2.add(coef3).toString());
    }

    @Test
    void multiplication1() { Assertions.assertEquals("12X^10", coef2.mult(coef3).toString()); }

    @Test
    void evaluate1() {
        Assertions.assertEquals("64", coef2.evaluate(new Integer(2)).toString());
    }
    @Test
    void evaluate2() {
        Assertions.assertEquals("0", coef2.evaluate(new Integer(0)).toString());
    }
    @Test
    void evaluate3() { Assertions.assertEquals("2", coef2.evaluate(new Integer(1)).toString()); }
    @Test
    void evaluate4() {
        Assertions.assertEquals("-64", coef2.evaluate(new Integer(-2)).toString());
    }

    @Test
    void derivative1() { Assertions.assertEquals("30X^4", coef3.derivative().toString()); }
    @Test
    void derivative2() { Assertions.assertEquals("0", mzero.derivative().toString()); }
    @Test
    void derivative3() { Assertions.assertEquals("0", exp0.derivative().toString()); }

    @Test
    void sign1() {
        Assertions.assertEquals(0, mzero.sign());
    }
    @Test
    void sign2() {
        Assertions.assertEquals(1, coef1.sign());
        Assertions.assertEquals(0, rt_coef1.sign());
    }
    @Test
    void sign3() {
        Assertions.assertEquals(1, coef2.sign());
    }
    @Test
    void sign4() {
        Assertions.assertEquals(1, coef3.sign());
        Assertions.assertEquals(1, rt_coef3.sign());
    }
    @Test
    void sign5() {
        Assertions.assertEquals(-1, coef4.sign());
        Assertions.assertEquals(-1, rt_coef4.sign());
    }
    @Test
    void sign6() {
        Assertions.assertEquals(0, coef0.sign());
        Assertions.assertEquals(-1, rt_coef0.sign());
    }
    @Test
    void sign7() {
        Assertions.assertEquals(-1, coef_neg1.sign());
        Assertions.assertEquals(1, rt_coef_neg1.sign());
    }
    @Test
    void sign8() {
        Assertions.assertEquals(1, coef_eq_exp.sign());
        Assertions.assertEquals(1, rt_coef_eq_exp.sign());
    }
    @Test
    void sign9() {
        Assertions.assertEquals(1, exp0.sign());
        Assertions.assertEquals(1, rt_exp0.sign());
    }
    @Test
    void sign10() {
        Assertions.assertEquals(1, exp_lt0.sign());
        Assertions.assertEquals(1, rt_exp_lt0.sign());
    }
    @Test
    void sign11() {
        Assertions.assertEquals(1, exp_gt0.sign());
        Assertions.assertEquals(1, rt_exp_gt0.sign());
    }
}
