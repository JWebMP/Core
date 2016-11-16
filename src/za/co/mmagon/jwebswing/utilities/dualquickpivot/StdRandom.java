/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.utilities.dualquickpivot;

/**
 * ****************************************************************************
 * Compilation: javac StdRandom.java
 * Execution: java StdRandom
 * Dependencies: StdOut.java
 * <p>
 * A library of static methods to generate pseudo-random numbers from
 * different distributions (bernoulli, uniform, gaussian, discrete,
 * and exponential). Also includes a method for shuffling an array.
 * <p>
 * <p>
 * % java StdRandom 5
 * seed = 1316600602069
 * 59 16.81826 true 8.83954 0
 * 32 91.32098 true 9.11026 0
 * 35 10.11874 true 8.95396 3
 * 92 32.88401 true 8.87089 0
 * 72 92.55791 true 9.46241 0
 * <p>
 * % java StdRandom 5
 * seed = 1316600616575
 * 96 60.17070 true 8.72821 0
 * 79 32.01607 true 8.58159 0
 * 81 59.49065 true 9.10423 1
 * 96 51.65818 true 9.02102 0
 * 99 17.55771 true 8.99762 0
 * <p>
 * % java StdRandom 5 1316600616575
 * seed = 1316600616575
 * 96 60.17070 true 8.72821 0
 * 79 32.01607 true 8.58159 0
 * 81 59.49065 true 9.10423 1
 * 96 51.65818 true 9.02102 0
 * 99 17.55771 true 8.99762 0
 * <p>
 * <p>
 * Remark
 * ------
 * - Relies on randomness of nextDouble() method in java.util.Random
 * to generate pseudorandom numbers in [0, 1).
 * <p>
 * - This library allows you to set and get the pseudorandom number seed.
 * <p>
 * - See http://www.honeylocust.com/RngPack/ for an industrial
 * strength random number generator in Java.
 * <p>
 *****************************************************************************
 */
import java.util.Random;

/**
 * The {@code StdRandom} class provides static methods for generating
 * random number from various discrete and continuous distributions,
 * including Bernoulli, uniform, Gaussian, exponential, pareto,
 * Poisson, and Cauchy. It also provides method for shuffling an
 * array or subarray.
 * &lt;p&gt;
 * For additional documentation,
 * see &lt;a href="http://introcs.cs.princeton.edu/22library"&gt;Section 2.2&lt;/a&gt; of
 * &lt;i&gt;Introduction to Programming in Java: An Interdisciplinary Approach&lt;/i&gt;
 * by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public final class StdRandom
{

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static
    {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    // don't instantiate
    private StdRandom()
    {
    }

    /**
     * Sets the seed of the pseudorandom number generator.
     * This method enables you to produce the same sequence of "random"
     * number for each execution of the program.
     * Ordinarily, you should call this method at most once per program.
     *
     * @param s the seed
     */
    public static void setSeed(long s)
    {
        seed = s;
        random = new Random(seed);
    }

    /**
     * Returns the seed of the pseudorandom number generator.
     *
     * @return the seed
     */
    public static long getSeed()
    {
        return seed;
    }

    /**
     * Returns a random real number uniformly in [0, 1).
     *
     * @return a random real number uniformly in [0, 1)
     */
    public static double uniform()
    {
        return random.nextDouble();
    }

    /**
     * Returns a random integer uniformly in [0, n).
     *
     * @param n number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and &lt;tt&gt;N&lt;/tt&gt; (exclusive)
     *
     * @throws IllegalArgumentException if &lt;tt&gt;n &lt;= 0&lt;/tt&gt;
     */
    public static int uniform(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("Parameter N must be positive");
        }
        return random.nextInt(n);
    }

    ///////////////////////////////////////////////////////////////////////////
    //  STATIC METHODS BELOW RELY ON JAVA.UTIL.RANDOM ONLY INDIRECTLY VIA
    //  THE STATIC METHODS ABOVE.
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Returns a random real number uniformly in [0, 1).
     *
     * @return a random real number uniformly in [0, 1)
     *
     * @deprecated Replaced by {@link #uniform()}.
     */
    public static double random()
    {
        return uniform();
    }

    /**
     * Returns a random integer uniformly in [a, b).
     *
     * @param a the left endpoint
     * @param b the right endpoint
     * @return a random integer uniformly in [a, b)
     *
     * @throws IllegalArgumentException if &gt;tt&gt;b &gt;= a&gt;/tt&gt;
     * @throws IllegalArgumentException if &gt;tt&gt;b - a &gt;= Integer.MAX_VALUE&gt;/tt&gt;
     */
    public static int uniform(int a, int b)
    {
        if (b <= a)
        {
            throw new IllegalArgumentException("Invalid range");
        }
        if ((long) b - a >= Integer.MAX_VALUE)
        {
            throw new IllegalArgumentException("Invalid range");
        }
        return a + uniform(b - a);
    }

    /**
     * Returns a random real number uniformly in [a, b).
     *
     * @param a the left endpoint
     * @param b the right endpoint
     * @return a random real number uniformly in [a, b)
     *
     * @throws IllegalArgumentException unless &lt;tt&gt;a &lt; b&lt;/tt&gt;
     */
    public static double uniform(double a, double b)
    {
        if (!(a < b))
        {
            throw new IllegalArgumentException("Invalid range");
        }
        return a + uniform() * (b - a);
    }

    /**
     * Returns a random boolean from a Bernoulli distribution with success
     * probability &lt;em&gt;p&lt;/em&gt;.
     *
     * @param p the probability of returning &lt;tt&gt;true&lt;/tt&gt;
     * @return &lt;tt&gt;true&lt;/tt&gt; with probability &lt;tt&gt;p&lt;/tt&gt; and
     *         &lt;tt&gt;false&lt;/tt&gt; with probability &lt;tt&gt;p&lt;/tt&gt;
     *
     * @throws IllegalArgumentException unless &lt;tt&gt;p &gt;= 0.0&lt;/tt&gt; and &lt;tt&gt;p &lt;= 1.0&lt;/tt&gt;
     */
    public static boolean bernoulli(double p)
    {
        if (!(p >= 0.0 && p <= 1.0))
        {
            throw new IllegalArgumentException(" Probability must be between 0.0 and 1.0");
        }
        return uniform() < p;
    }

    /**
     * Returns a random boolean from a Bernoulli distribution with success
     * probability 1/2.
     *
     * @return &lt;tt&gt;true&lt;/tt&gt; with probability 1/2 and
     *         &lt;tt&gt;false&lt;/tt&gt; with probability 1/2
     */
    public static boolean bernoulli()
    {
        return bernoulli(0.5);
    }

    /**
     * Returns a random real number from a standard Gaussian distribution.
     *
     * @return a random real number from a standard Gaussian distribution
     *         (mean 0 and standard deviation 1).
     */
    public static double gaussian()
    {
        // use the polar form of the Box-Muller transform
        double r, x, y;
        do
        {
            x = uniform(-1.0, 1.0);
            y = uniform(-1.0, 1.0);
            r = x * x + y * y;
        } while (r >= 1.0 || r == 0.0);
        return x * Math.sqrt(-2 * Math.log(r) / r);

        // Remark:  y * Math.sqrt(-2 * Math.log(r) / r)
        // is an independent random gaussian
    }

    /**
     * Returns a random real number from a Gaussian distribution with mean &mu;
     * and standard deviation &sigma;.
     *
     * @param mu    the mean
     * @param sigma the standard deviation
     * @return a real number distributed according to the Gaussian distribution
     *         with mean &lt;tt&gt;mu&lt;/tt&gt; and standard deviation &lt;tt&gt;sigma&lt;/tt&gt;
     */
    public static double gaussian(double mu, double sigma)
    {
        return mu + sigma * gaussian();
    }

    /**
     * Returns a random integer from a geometric distribution with success
     * probability &lt;em&lt;p&lt;/em&lt;.
     *
     * @param p the parameter of the geometric distribution
     * @return a random integer from a geometric distribution with success
     *         probability &lt;tt&lt;p&lt;/tt&lt;
     *
     * @throws IllegalArgumentException unless &lt;tt&lt;p &lt;= 0.0&lt;/tt&lt; and &lt;tt&lt;p &lt;= 1.0&lt;/tt&lt;
     */
    public static int geometric(double p)
    {
        if (!(p >= 0.0 && p <= 1.0))
        {
            throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        }
        // using algorithm given by Knuth
        return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
    }

    /**
     * Returns a random integer from a Poisson distribution with mean &lambda;.
     *
     * @param lambda the mean of the Poisson distribution
     * @return a random integer from a Poisson distribution with mean &lt;tt&gt;lambda&lt;/tt&gt;
     *
     * @throws IllegalArgumentException unless &lt;tt&gt;lambda &gt; 0.0&lt;/tt&gt; and not infinite
     */
    public static int poisson(double lambda)
    {
        if (!(lambda > 0.0))
        {
            throw new IllegalArgumentException("Parameter lambda must be positive");
        }
        if (Double.isInfinite(lambda))
        {
            throw new IllegalArgumentException("Parameter lambda must not be infinite");
        }
        // using algorithm given by Knuth
        // see http://en.wikipedia.org/wiki/Poisson_distribution
        int k = 0;
        double p = 1.0;
        double L = Math.exp(-lambda);
        do
        {
            k++;
            p *= uniform();
        } while (p >= L);
        return k - 1;
    }

    /**
     * Returns a random real number from the standard Pareto distribution.
     *
     * @return a random real number from the standard Pareto distribution
     */
    public static double pareto()
    {
        return pareto(1.0);
    }

    /**
     * Returns a random real number from a Pareto distribution with
     * shape parameter &alpha;.
     *
     * @param alpha shape parameter
     * @return a random real number from a Pareto distribution with shape
     *         parameter &lt;tt&gt;alpha&lt;/tt&gt;
     *
     * @throws IllegalArgumentException unless &lt;tt&gt;alpha &gt; 0.0&lt;/tt&gt;
     */
    public static double pareto(double alpha)
    {
        if (!(alpha > 0.0))
        {
            throw new IllegalArgumentException("Shape parameter alpha must be positive");
        }
        return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
    }

    /**
     * Returns a random real number from the Cauchy distribution.
     *
     * @return a random real number from the Cauchy distribution.
     */
    public static double cauchy()
    {
        return Math.tan(Math.PI * (uniform() - 0.5));
    }

    /**
     * Returns a random integer from the specified discrete distribution.
     *
     * @param probabilities the probability of occurrence of each integer
     * @return a random integer from a discrete distribution:
     *         &lt;tt&gt;i&lt;/tt&gt; with probability &lt;tt&gt;probabilities[i]&lt;/tt&gt;
     *
     * @throws NullPointerException     if &lt;tt&gt;probabilities&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     * @throws IllegalArgumentException if sum of array entries is not (very nearly) equal to &lt;tt&gt;1.0&lt;/tt&gt;
     * @throws IllegalArgumentException unless &lt;tt&gt;probabilities[i] &gt;= 0.0&lt;/tt&gt; for each index &lt;tt&gt;i&lt;/tt&gt;
     */
    public static int discrete(double[] probabilities)
    {
        if (probabilities == null)
        {
            throw new NullPointerException("argument array is null");
        }
        double EPSILON = 1E-14;
        double sum = 0.0;
        for (int i = 0; i < probabilities.length; i++)
        {
            if (!(probabilities[i] >= 0.0))
            {
                throw new IllegalArgumentException("array entry " + i + " must be nonnegative: " + probabilities[i]);
            }
            sum += probabilities[i];
        }
        if (sum > 1.0 + EPSILON || sum < 1.0 - EPSILON)
        {
            throw new IllegalArgumentException("sum of array entries does not approximately equal 1.0: " + sum);
        }

        // the for loop may not return a value when both r is (nearly) 1.0 and when the
        // cumulative sum is less than 1.0 (as a result of floating-point roundoff error)
        while (true)
        {
            double r = uniform();
            sum = 0.0;
            for (int i = 0; i < probabilities.length; i++)
            {
                sum = sum + probabilities[i];
                if (sum > r)
                {
                    return i;
                }
            }
        }
    }

    /**
     * Returns a random integer from the specified discrete distribution.
     *
     * @param frequencies the frequency of occurrence of each integer
     * @return a random integer from a discrete distribution:
     *         &lt;tt&gt;i&lt;/tt&gt; with probability proportional to &lt;tt&gt;frequencies[i]&lt;/tt&gt;
     *
     * @throws NullPointerException     if &lt;tt&gt;frequencies&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     * @throws IllegalArgumentException if all array entries are &lt;tt&gt;0&lt;/tt&gt;
     * @throws IllegalArgumentException if &lt;tt&gt;frequencies[i]&lt;/tt&gt; is negative for any index &lt;tt&gt;i&lt;/tt&gt;
     * @throws IllegalArgumentException if sum of frequencies exceeds &lt;tt&gt;Integer.MAX_VALUE&lt;/tt&gt; (2&lt;sup&gt;31&lt;/sup&gt; - 1)
     */
    public static int discrete(int[] frequencies)
    {
        if (frequencies == null)
        {
            throw new NullPointerException("argument array is null");
        }
        long sum = 0;
        for (int i = 0; i < frequencies.length; i++)
        {
            if (frequencies[i] < 0)
            {
                throw new IllegalArgumentException("array entry " + i + " must be nonnegative: " + frequencies[i]);
            }
            sum += frequencies[i];
        }
        if (sum == 0)
        {
            throw new IllegalArgumentException("at least one array entry must be positive");
        }
        if (sum >= Integer.MAX_VALUE)
        {
            throw new IllegalArgumentException("sum of frequencies overflows an int");
        }

        // pick index i with probabilitity proportional to frequency
        double r = uniform((int) sum);
        sum = 0;
        for (int i = 0; i < frequencies.length; i++)
        {
            sum += frequencies[i];
            if (sum > r)
            {
                return i;
            }
        }

        // can't reach here
        assert false;
        return -1;
    }

    /**
     * Returns a random real number from an exponential distribution
     * with rate &lambda;.
     *
     * @param lambda the rate of the exponential distribution
     * @return a random real number from an exponential distribution with
     *         rate &lt;tt&gt;lambda&lt;/tt&gt;
     *
     * @throws IllegalArgumentException unless &lt;tt&gt;lambda &gt; 0.0&lt;/tt&gt;
     */
    public static double exp(double lambda)
    {
        if (!(lambda > 0.0))
        {
            throw new IllegalArgumentException("Rate lambda must be positive");
        }
        return -Math.log(1 - uniform()) / lambda;
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param a the array to shuffle
     * @throws NullPointerException if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     */
    public static void shuffle(Object[] a)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int r = i + uniform(n - i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param a the array to shuffle
     * @throws NullPointerException if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     */
    public static void shuffle(double[] a)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int r = i + uniform(n - i);     // between i and n-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param a the array to shuffle
     * @throws NullPointerException if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     */
    public static void shuffle(int[] a)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int r = i + uniform(n - i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified subarray in uniformly random order.
     *
     * @param a  the array to shuffle
     * @param lo the left endpoint (inclusive)
     * @param hi the right endpoint (inclusive)
     * @throws NullPointerException      if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     * @throws IndexOutOfBoundsException unless &lt;tt&gt;(0 &lt;= lo) &amp;&amp; (lo &lt;= hi) &amp;&amp; (hi &lt; a.length)&lt;/tt&gt;
     *
     */
    public static void shuffle(Object[] a, int lo, int hi)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        if (lo < 0 || lo > hi || hi >= a.length)
        {
            throw new IndexOutOfBoundsException("Illegal subarray range");
        }
        for (int i = lo; i <= hi; i++)
        {
            int r = i + uniform(hi - i + 1);     // between i and hi
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified subarray in uniformly random order.
     *
     * @param a  the array to shuffle
     * @param lo the left endpoint (inclusive)
     * @param hi the right endpoint (inclusive)
     * @throws NullPointerException      if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     * @throws IndexOutOfBoundsException unless &lt;tt&gt;(0 &lt;= lo) &amp;&amp; (lo &lt;= hi) &amp;&amp; (hi &lt; a.length)&lt;/tt&gt;
     */
    public static void shuffle(double[] a, int lo, int hi)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        if (lo < 0 || lo > hi || hi >= a.length)
        {
            throw new IndexOutOfBoundsException("Illegal subarray range");
        }
        for (int i = lo; i <= hi; i++)
        {
            int r = i + uniform(hi - i + 1);     // between i and hi
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified subarray in uniformly random order.
     *
     * @param a  the array to shuffle
     * @param lo the left endpoint (inclusive)
     * @param hi the right endpoint (inclusive)
     * @throws NullPointerException      if &lt;tt&gt;a&lt;/tt&gt; is &lt;tt&gt;null&lt;/tt&gt;
     * @throws IndexOutOfBoundsException unless &lt;tt&gt;(0 &lt;= lo) &amp;&amp; (lo &lt;= hi) &amp;&amp; (hi &lt; a.length)&lt;/tt&gt;
     */
    public static void shuffle(int[] a, int lo, int hi)
    {
        if (a == null)
        {
            throw new NullPointerException("argument array is null");
        }
        if (lo < 0 || lo > hi || hi >= a.length)
        {
            throw new IndexOutOfBoundsException("Illegal subarray range");
        }
        for (int i = lo; i <= hi; i++)
        {
            int r = i + uniform(hi - i + 1);     // between i and hi
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * Unit test.
     * @param args Args 1 = random, 2 = seed
     */
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        if (args.length == 2)
        {
            StdRandom.setSeed(Long.parseLong(args[1]));
        }
        double[] probabilities =
        {
            0.5, 0.3, 0.1, 0.1
        };
        int[] frequencies =
        {
            5, 3, 1, 1
        };
        String[] a = "A B C D E F G".split(" ");
        System.out.println("");
        System.out.println("seed = " + StdRandom.getSeed());
        for (int i = 0; i < n; i++)
        {
            System.out.printf("%2d ", uniform(100));
            System.out.printf("%8.5f ", uniform(10.0, 99.0));
            System.out.printf("%5b ", bernoulli(0.5));
            System.out.printf("%7.5f ", gaussian(9.0, 0.2));
            System.out.printf("%1d ", discrete(probabilities));
            System.out.printf("%1d ", discrete(frequencies));
            StdRandom.shuffle(a);
            for (String s : a)
            {
                System.out.print(s);
            }
            System.out.println();
        }
    }

}
