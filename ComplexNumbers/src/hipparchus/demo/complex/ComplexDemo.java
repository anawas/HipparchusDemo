package hipparchus.demo.complex;

import org.hipparchus.complex.Complex;
import org.hipparchus.complex.ComplexFormat;

public class ComplexDemo {
  public static void main(String[] args) {
    Complex z1 = new Complex(1.0, 2.0);  // z1 = 1 + 2i
    Complex z2 = new Complex(1.0, -1.0);  // z2 = 1 - i

    ComplexFormat cf = new ComplexFormat();
    Complex z3 = cf.parse("-1.11 + 3.13i");
    Complex answer = z1.add(z2);
    System.out.println("z1 + z2 = " + answer);
    System.out.println("|z1| = " + z1.abs().getRealPart());
    System.out.println("|z3| = " + z3.abs().getRealPart());
    System.out.println("log(z2) = " + z2.log());
  }
}
