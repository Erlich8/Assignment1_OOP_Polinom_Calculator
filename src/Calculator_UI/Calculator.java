package Calculator_UI;
import Polynimials.Polynomial;
import Scalars.Scalar;

public class Calculator {
    private static void printTitle(String s) {
        System.out.println("\n========== " + s + " ==========");
    }

    private static void printAdd(Polynomial p1, Polynomial p2, Polynomial res) {
        System.out.println("[" + p1 + "]+[" + p2 + "]=" + res);
    }

    private static void printMul(Polynomial p1, Polynomial p2, Polynomial res) {
        System.out.println("[" + p1 + "]*[" + p2 + "]=" + res);
    }

    private static void printEval(Polynomial p, Scalar s, Scalar res) {
        System.out.println("eval(" + p + "," + s + ")=" + res);
    }

    private static void printDerivate(Polynomial p, Polynomial d) {
        System.out.println("derivate(" + p + ")=" + d);
    }

    public static void main(String[] args) {

        Polynomial p1 = Polynomial.build("1/2 1");
        Polynomial p2 = Polynomial.build("1 0 -1 0 1/4");
        Polynomial p3 = Polynomial.build("5 0 -2");
        Polynomial p4 = Polynomial.build("5");
        Polynomial p5 = Polynomial.build("2/-1");
        Polynomial p6 = Polynomial.build("1/2 1 0 8");
        Polynomial p7 = Polynomial.build("0 0 100");
        Polynomial p8 = Polynomial.build("0 -1");
        Polynomial p9 = Polynomial.build("0 -1/-2");
    }
}
