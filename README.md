# Newton's Method

A root-finding algorithm, written in Java.

Reference:
[Wikipedia](https://en.wikipedia.org/wiki/Newton%27s_method)

In short, this algorithm finds the approximations of the roots of a given real-valued function.
This function must be a polynomial with integer coefficients.

# How to run

You must have java installed.

Then simply run the main file, which is *Newton*.
> java Newton

This will print out the roots.

Currently, you must manually change the starting polynomial function by replacing the coefficients in the Newton.java file and recompile.

Sorry I didn't make it so that you give the coefficients like command-line arguments. It would be a simple fill the arraylist with args.

Here's an idea. You do it. It's not that hard.

# How it works

The file Polynomial.java is the core of the algorithm.

Newton's method works by taking an initial guess and performing some number of iterations to get close to the root.
More iterations means more precision.

Feel free to play around with your own polynomials and the number of iterations.

The formula for the algorithm:

 $`x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}`$

Since Newton's method requires derivatives, and I wanted to do it by myself, there's a function that returns a derivative of a function.

This is also why I only did integer-coefficient polynomials, so I could use the power rule hihi (and addition rules and such).

Refresher: $`f'(x) = n \cdot x^{n-1}`$ if $`f(x) = x^n`$

For the initial guess, we use the extreme points of a function.
Extreme points are found using derivatives (again).

There are also some arbitrarily chosen thresholds and minifixes, like subtracting with 0.1, and I don't really remember why.

Other than that, the code has comments, but for future projects, I see I need more of them to explain technical stuff.
Feel free to dissect the code and roast me.
Or make it better 👍



