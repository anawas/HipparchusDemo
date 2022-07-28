package hipparchus.demo.rootFinding;

import org.hipparchus.analysis.UnivariateFunction;
import org.hipparchus.analysis.solvers.AllowedSolution;
import org.hipparchus.analysis.solvers.BracketingNthOrderBrentSolver;
import org.hipparchus.analysis.solvers.UnivariateSolver;

public class RootDemo {

  public static void main(String[] args) {
    UnivariateFunction function = x -> 2*x*x-5.0;
    final double relativeAccuracy = 1.0e-12;
    final double absoluteAccuracy = 1.0e-8;
    final int    maxOrder         = 5;
    UnivariateSolver solver = new BracketingNthOrderBrentSolver(relativeAccuracy, absoluteAccuracy, maxOrder);
    double c = solver.solve(100, function, 0.0, 5.0);
    System.out.println(c);
  }
}
