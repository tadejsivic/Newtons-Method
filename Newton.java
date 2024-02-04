/** SPREJETO, KONCANO*/

public class Newton
{
    public static void main(String[] args)
    {
    	// Coefficients in order as they appear in a function: x²-2 -> 1, 0, -2
        Polynomial p = new Polynomial(new int[] {1,-4,0,7,-8,3,-4});
        Polynomial.findRoots(p);
        
        System.out.println(p.mainRoots);
        for (double d : p.mainRoots) {
            System.out.printf("%.5f\n", d);
        }   
    }
    
}