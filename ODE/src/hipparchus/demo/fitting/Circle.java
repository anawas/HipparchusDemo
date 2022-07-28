package hipparchus.demo.fitting;

import org.hipparchus.ode.OrdinaryDifferentialEquation;

public class Circle implements OrdinaryDifferentialEquation {
  private double[] c;
  private double omega;

  public Circle(double[] c, double omega) {
    this.c = c;
    this.omega = omega;
  }

  @Override
  public int getDimension() {
    return 2;
  }

  @Override
  public double[] computeDerivatives(double t, double[] y) {
    return new double[] {
        omega * (c[1] - y[1]),
        omega * (y[0] - c[0])
    };
  }
}
