package hipparchos.demo.fitting;

import java.util.Arrays;
import java.util.List;
import org.hipparchus.fitting.PolynomialCurveFitter;
import org.hipparchus.fitting.WeightedObservedPoint;
import org.hipparchus.fitting.WeightedObservedPoints;
import org.hipparchus.stat.descriptive.DescriptiveStatistics;

public class FittingDemo {

  public static void main(String[] args) {
    System.out.println("Statistic Demo");
    statisticsDemo();

    System.out.println("Fitting Demo");
    fittingDemo();
  }

  private static void statisticsDemo() {
    DescriptiveStatistics stats = new DescriptiveStatistics();
    for (int i = 0; i < 10; i++) {
      stats.addValue(Math.random()*10.0);
    }

    System.out.format("Mean   : %3.3g%n", stats.getMean());
    System.out.format("Std    : %3.3g%n", stats.getStandardDeviation());
    System.out.format("Median : %3.3g%n", stats.getPercentile(50));
  }

  private static void fittingDemo() {
    final WeightedObservedPoints obs = new WeightedObservedPoints();

    for (int i = 0; i < 10; i++) {
      double x = 2.0*Math.random()-1.0;
      obs.add(x, y(x)+(Math.random()*0.1-0.05));
    }

    // Instantiate a third-degree polynomial fitter.
    final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);

    // Retrieve fitted parameters (coefficients of the polynomial function).
    final double[] coeff = fitter.fit(obs.toList());
    System.out.println("Parameters:");
    Arrays.stream(coeff).forEach(System.out::println);

    List<WeightedObservedPoint> datapoints = obs.toList();
    for (WeightedObservedPoint pt : datapoints) {
      double x = pt.getX();
      double y = coeff[0] + coeff[1]*x + coeff[2]*x*x + coeff[3]*Math.pow(x, 3);
      double diff = Math.abs(pt.getY() - y);
      System.out.println("x = " + x + " --> y = " + y + " (± " + diff + ")");
    }
  }

  static double y(double x) {
    return -340d - 350d*x + 345d * Math.pow(x, 2) + 350d * Math.pow(x, 3);
  }
}
