package hipparchus.demo.fitting;

import java.util.Locale;
import org.hipparchus.ode.ODEIntegrator;
import org.hipparchus.ode.ODEState;
import org.hipparchus.ode.ODEStateAndDerivative;
import org.hipparchus.ode.OrdinaryDifferentialEquation;
import org.hipparchus.ode.nonstiff.DormandPrince853Integrator;

public class OdeDemo {

  public static void main(String[] args) {
    ODEIntegrator dp853        = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
    OrdinaryDifferentialEquation ode          = new Circle(new double[] { 1.0, 1.0 }, 0.1);
    ODEState initialState = new ODEState(0.0, new double[] { 0.0, 1.0 });
    ODEStateAndDerivative finalState   = dp853.integrate(ode, initialState, 16.0);
    double                       t            = finalState.getTime();
    double[]                     y            = finalState.getPrimaryState();
    System.out.format(Locale.US, "final state at %4.1f: %6.3f %6.3f%n", t, y[0], y[1]);
  }

}
