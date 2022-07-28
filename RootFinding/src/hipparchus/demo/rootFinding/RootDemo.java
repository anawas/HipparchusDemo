package hipparchus.demo.rootFinding;

import org.hipparchus.analysis.UnivariateFunction;
import org.hipparchus.analysis.differentiation.FiniteDifferencesDifferentiator;
import org.hipparchus.analysis.differentiation.UnivariateDifferentiableFunction;
import org.hipparchus.analysis.solvers.BracketingNthOrderBrentSolver;
import org.hipparchus.analysis.solvers.NewtonRaphsonSolver;
import org.hipparchus.analysis.solvers.RegulaFalsiSolver;
import org.hipparchus.analysis.solvers.UnivariateSolver;



public class RootDemo {
  public static void main(String[] args) {
    UnivariateFunction function = x -> 2*x*x-5.0;
    final double low = 0.0;
    final double high = 5.0;

    System.out.println("Bracketing Solver");
    bracketingSolverDemo(function, low, high);

    System.out.println("\nRegula Falsi Solver");
    regulaFalsiDemo(function, low, high);

    System.out.println("\nNewton-Raphson Solver");
    newtonRaphsonDemo(function, low, high);
  }

  private static void newtonRaphsonDemo(UnivariateFunction func, double low, double hi) {
    int numOfPoints = 10;
    double stepSize = (hi - low) / numOfPoints;

    FiniteDifferencesDifferentiator diff = new FiniteDifferencesDifferentiator(numOfPoints, stepSize, low, hi);
    UnivariateDifferentiableFunction diffFunc = diff.differentiate(func);
    NewtonRaphsonSolver solver = new NewtonRaphsonSolver();
    double c = solver.solve(100, diffFunc, low, hi);
    System.out.println("Solution (Newton-Raphson Solver) = " + c);
  }

  private static void bracketingSolverDemo(UnivariateFunction function, double low, double hi) {
    final double relativeAccuracy = 1.0e-12;
    final double absoluteAccuracy = 1.0e-8;
    final int    maxOrder         = 5;

    UnivariateSolver solver = new BracketingNthOrderBrentSolver(relativeAccuracy, absoluteAccuracy, maxOrder);
    double c = solver.solve(100, function, low, hi);
    System.out.println("Solution (Brent Solver) = " + c);
  }

  private static void regulaFalsiDemo(UnivariateFunction function, double low, double hi) {
    final double relativeAccuracy = 1.0e-12;
    final double absoluteAccuracy = 1.0e-8;

    UnivariateSolver solver = new RegulaFalsiSolver(relativeAccuracy, absoluteAccuracy);
    double c = solver.solve(100, function, low, hi);
    System.out.println("Solution (Regula Falsi Solver) = " + c);
  }
}
