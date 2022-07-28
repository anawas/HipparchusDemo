package hipparchus.demo.distribution;

import org.hipparchus.distribution.continuous.NormalDistribution;
import org.hipparchus.distribution.continuous.TriangularDistribution;

public class DistributionsDemo {

  public static void main(String[] args) {
    System.out.println("Normal Distribution");
    normalDistributionDemo();

    System.out.println("\nTriangular Distribution");
    trianagularDistributionDemo();
  }

  private static void trianagularDistributionDemo() {
    TriangularDistribution td = new TriangularDistribution(0, 1, 2);
    System.out.println("Mean = " + td.getNumericalMean());
    System.out.println("P(X <= 0.5) = " + td.cumulativeProbability(0.5));
  }

  private static void normalDistributionDemo() {
    NormalDistribution nd = new NormalDistribution(2.5, 0.5);
    System.out.println("Mean = " + nd.getMean());
    System.out.println("P(1.0 < x <= 2.0) = " + nd.probability(1.0, 2.0));
  }
}
