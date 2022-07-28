package hipparchus.demo.equationsystem;

import javax.security.sasl.RealmCallback;
import org.hipparchus.linear.Array2DRowRealMatrix;
import org.hipparchus.linear.ArrayRealVector;
import org.hipparchus.linear.DecompositionSolver;
import org.hipparchus.linear.LUDecomposition;
import org.hipparchus.linear.RealMatrix;
import org.hipparchus.linear.RealVector;

// solving
// 2x + 3y - 2z = 1
// -x + 7y + 6z = -2
// 4x - 3y - 5z = 1
public class SystemSolver {
  public static void main(String[] args) {
    RealMatrix coeffs = new Array2DRowRealMatrix(new double[][] {
        {2, 3, -2},
        {-1, 7, 6},
        {4, -3, -5}
    }, false);

    DecompositionSolver solver = new LUDecomposition(coeffs).getSolver();
    RealVector constants = new ArrayRealVector(new double[] {1, -2, 1}, false);
    RealVector solution = solver.solve(constants);

    System.out.format("x = %2.4g%n", solution.getEntry(0));
    System.out.format("y = %2.4g%n", solution.getEntry(1));
    System.out.format("z = %2.4g%n", solution.getEntry(2));
  }
}
