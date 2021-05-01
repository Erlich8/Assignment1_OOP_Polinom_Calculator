package Calculator_UI;
import Monomials.Monomial;
import Polynimials.Polynomial;
import Scalars.Integer;
import Scalars.Rational;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void main() {

        Polynomial p1 = Polynomial.build("1/2 1");
        Polynomial p2 = Polynomial.build("1 0 -1 0 1/4");
        Polynomial p3 = Polynomial.build("5 0 -2");
        Polynomial p4 = Polynomial.build("5");
        Polynomial p5 = Polynomial.build("2/-1");
        Polynomial p6 = Polynomial.build("1/2 1 0 8");
        Polynomial p7 = Polynomial.build("0 0 100");
        Polynomial p8 = Polynomial.build("0 -1");
        Polynomial p9 = Polynomial.build("0 -1/-2");
        Polynomial p10 = Polynomial.build("-1 -1");
        Polynomial p11 = Polynomial.build("1 1");
        Polynomial zero = Polynomial.build("0");


        Assertions.assertEquals("1/2+X",p1.toString(),"1/2+X ");
        Assertions.assertEquals("1-X^2+1/4X^4",p2.toString(),"1-X^2+1/4X^4");
        Assertions.assertEquals("5-2X^2",p3.toString(),"5-2X^2");
        Assertions.assertEquals("5",p4.toString(),"5");
        Assertions.assertEquals("-1/2",p5.toString(),"-1/2");
        Assertions.assertEquals("1/2+X+8X^2",p6.toString(),"1/2+X+8X^2");
        Assertions.assertEquals("100X^2",p7.toString(),"100X^2");
        Assertions.assertEquals("-X",p8.toString(),"-X");
        Assertions.assertEquals("1/2X",p9.toString(),"1/2X");
        Assertions.assertEquals("-1-X",p10.toString(),"-1-X");
        // add test
          Assertions.assertEquals("0",p10.add(p11).toString(),"0");
         Assertions.assertEquals("1/2+1X+100X^2+8X^3",p6.add(p7).toString(),"1/2+X+100X^2+8X^3");
         Assertions.assertEquals("1/2+1X+100X^2+8X^3",p7.add(p6).toString(),"1/2+X+100X^2+8X^3");
         Assertions.assertEquals("0",zero.add(zero).toString(),"0");
          //mul test
          Assertions.assertEquals("0",zero.mul(p1),"0");
          Assertions.assertEquals("0",p1.mul(zero),"0");
            //Evaluate Tests
//        Scalar s0 = new Integer(0);
//        Scalar s1 = new Integer(1);
//        Scalar s2 = new Integer(5);
//        Scalar r1 = new Rational(1,2);
//      Assertions.assertEquals("2",p11.evaluate(s0),2);
//        Assertions.assertEquals("0",zero.evaluate(s0),0);
//        Assertions.assertEquals("0",zero.evaluate(r1),0);
//        Assertions.assertEquals("0",zero.evaluate(s1),0);

       Assertions.assertEquals("0",zero.derivative().toString(),"0");
        Assertions.assertEquals("0",p4.derivative().toString(),"0");
        Assertions.assertEquals("-2X+1X^3",p2.derivative().toString(),"-2X+X^3");






    }
}