package Monomials;

import Scalars.Integer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MonomialTest {
    private Monomial mzero;
    private Monomial coef1, coef2, coef3, coef4;
    private Monomial coef0, coef_neg1, coef_eq_exp;
    private Monomial exp0, exp_lt0, exp_gt0;

    @BeforeEach
    void setUp() {
        mzero = new Monomial(0, new Integer(0));
        coef1 = new Monomial(2, new Integer(1));
        coef2 = new Monomial(5, new Integer(4));
        coef3 = new Monomial(5, new Integer(6));
        coef4 = new Monomial(5, new Integer(-6));
        coef0 = new Monomial(2, new Integer(0));
        coef_neg1 = new Monomial(2, new Integer(-1));
        coef_eq_exp = new Monomial(3, new Integer(3));
        exp0 = new Monomial(0, new Integer(10));
        exp_lt0 = new Monomial(-2, new Integer(3));
        exp_gt0 = new Monomial(8, new Integer(3));
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("0", mzero.toString());
        Assertions.assertEquals("X^2", coef1.toString());
        Assertions.assertEquals("4X^5", coef2.toString());
        Assertions.assertEquals("6X^5", coef3.toString());
        Assertions.assertEquals("-6X^5", coef4.toString());
        Assertions.assertEquals("0", coef0.toString());
        Assertions.assertEquals("-X^2", coef_neg1.toString());
        Assertions.assertEquals("3X^3", coef_eq_exp.toString());
        Assertions.assertEquals("10", exp0.toString());
        Assertions.assertEquals("3", exp_lt0.toString()); // if we reseting the exponent to be 0 then it behaves like that
        Assertions.assertEquals("3X^8", exp_gt0.toString());
    }

    @Test
    void addition1() {
        Assertions.assertNull(coef1.add(exp_gt0));
    }
    @Test
    void addition2() { Assertions.assertEquals("0", coef1.add(coef_neg1).toString()); }
    @Test
    void addition3() {
        Assertions.assertEquals("10X^5", coef2.add(coef3).toString());
    }

    @Test
    void multiplication1() { Assertions.assertEquals("24X^10", coef2.mult(coef3).toString()); }

    @Test
    void evaluate1() {
        Assertions.assertEquals("128", coef2.evaluate(new Integer(2)).toString());
    }
    @Test
    void evaluate2() {
        Assertions.assertEquals("0", coef2.evaluate(new Integer(0)).toString());
    }
    @Test
    void evaluate3() { Assertions.assertEquals("4", coef2.evaluate(new Integer(1)).toString()); }
    @Test
    void evaluate4() {
        Assertions.assertEquals("-128", coef2.evaluate(new Integer(-2)).toString());
    }

    @Test
    void derivative1() { Assertions.assertEquals("30X^4", coef3.derivative().toString()); }
    @Test
    void derivative2() { Assertions.assertEquals("0", mzero.derivative().toString()); }
    @Test
    void derivative3() { Assertions.assertEquals("0", exp0.derivative().toString()); }

    @Test
    void sign1() { Assertions.assertEquals(-1, mzero.sign()); }
    @Test
    void sign2() { Assertions.assertEquals(1, coef1.sign()); }
    @Test
    void sign3() { Assertions.assertEquals(1, coef2.sign()); }
    @Test
    void sign4() { Assertions.assertEquals(1, coef3.sign()); }
    @Test
    void sign5() { Assertions.assertEquals(-1, coef4.sign()); }
    @Test
    void sign6() { Assertions.assertEquals(-1, coef0.sign()); }
    @Test
    void sign7() { Assertions.assertEquals(-1, coef_neg1.sign()); }
    @Test
    void sign8() { Assertions.assertEquals(1, coef_eq_exp.sign()); }
    @Test
    void sign9() { Assertions.assertEquals(1, exp0.sign()); }
    @Test
    void sign10() { Assertions.assertEquals(1, exp_lt0.sign()); }
    @Test
    void sign11() { Assertions.assertEquals(1, exp_gt0.sign()); }
}
