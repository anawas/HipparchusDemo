package hipparchus.demo.rootFinding;

import org.hipparchus.analysis.UnivariateFunction;
import org.hipparchus.analysis.solvers.BracketingNthOrderBrentSolver;
import org.hipparchus.analysis.solvers.RegulaFalsiSolver;
import org.hipparchus.analysis.solvers.UnivariateSolver;

public class RootDemo {
  public static void main(String[] args) {
    UnivariateFunction function = x -> 2*x*x-5.0;

    System.out.println("Bracketing Solver");
    bracketingSolverDemo(function);

    System.out.println("\nRegula Falsi Solver");
    regulaFalsiDemo(function);
  }

  private static void bracketingSolverDemo(UnivariateFunction function) {
    final double relativeAccuracy = 1.0e-12;
    final double absoluteAccuracy = 1.0e-8;
    final int    maxOrder         = 5;

    UnivariateSolver solver = new BracketingNthOrderBrentSolver(relativeAccuracy, absoluteAccuracy, maxOrder);
    double c = solver.solve(100, function, 0.0, 5.0);
    System.out.println("Solution (Brent Solver) = " + c);
  }

  private static void regulaFalsiDemo(UnivariateFunction function) {
    final double relativeAccuracy = 1.0e-12;
    final double absoluteAccuracy = 1.0e-8;

    UnivariateSolver solver = new RegulaFalsiSolver(relativeAccuracy, absoluteAccuracy);
    double c = solver.solve(100, function, 0.0, 5.0);
    System.out.println("Solution (Regula Falsi Solver) = " + c);

  }
}
