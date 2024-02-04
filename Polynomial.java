import java.util.*;

public class Polynomial 
{
    int[] coefficients;
    int level;
    ArrayList<Double> mainRoots;
    final static int numberOfIterations = 100000;
    
    public Polynomial(int[] coef)
    {
        this.coefficients = coef;
        this.level = coef.length - 1;
        this.mainRoots = new ArrayList<>();
    }

    // Returns a derivative of a given polynomial
    public static Polynomial makeDerivative(Polynomial p)
    {
        int[] coef = new int[p.level];
        for (int i = 0; i < coef.length; i++)
            coef[i] = p.coefficients[i] * (p.level - i);
        return new Polynomial(coef);
    }

    // Computes and returns the value of a function at a given x
    public double value(double x)
    {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++)
            value += coefficients[level - i] * Math.pow(x, i);
        return value;
    }

    // Performs a certain amount of iterations of the Newton Method.
    // 
    public double iteration(double x0)
    {
        Polynomial d = Polynomial.makeDerivative(this);
        for (int i = 0; i < numberOfIterations; i++)
            x0 = x0 - value(x0) / d.value(x0);
        return x0;
    }

    static void findRoots(Polynomial p) 
    {
    	double[] r = roots(p);
    	for (int i=0; i<r.length; i++)
    		p.mainRoots.add(r[i]);
    	p.mainRoots.removeIf(n -> (p.value(n) > 0.1 || p.value(n) <-0.1));
    }
    
    public static double[] roots(Polynomial p)
    {
        // Exit condition
        if (p.level == 1)
            return new double[] { -(1.0 * p.coefficients[1] / p.coefficients[0]) };

        // Recursion
        double[] extremes = roots(makeDerivative(p));

        // Solving
        double[] roots = new double[p.level];
        for (int i = 0; i < extremes.length; i++)
            roots[i] = p.iteration(extremes[i] - 0.1);
        roots[roots.length - 1] = p.iteration(extremes[extremes.length - 1] + 0.1);
        
        return roots;
    }
      
}
