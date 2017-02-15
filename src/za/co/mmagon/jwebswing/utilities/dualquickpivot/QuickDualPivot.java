/* 
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.utilities.dualquickpivot;

/**
 * ****************************************************************************
 * Compilation: javac QuickDualPivot.java Execution: java QuickDualPivot &lt; input.txt Dependencies: StdOut.java StdIn.java Data files: http://algs4.cs.princeton.edu/23quicksort/tiny.txt
 * http://algs4.cs.princeton.edu/23quicksort/words3.txt
 * <p>
 * Sorts a sequence of strings from standard input using dual-pivot quicksort.
 * <p>
 * [Warning: not thoroughly tested.]
 * <p>
 * % more tiny.txt S O R T E X A M P L E
 * <p>
 * % java QuickDualPivot &lt; tiny.txt A E E L M O P R S T X [ one string per line ]
 * <p>
 * % more words3.txt bed bug dad yes zoo ... all bad yet
 * <p>
 * % java QuickDualPivot &lt; words3.txt all bad bed bug dad ... yes yet zoo [ one string per line ]
 * <p>
 *****************************************************************************
 */
public class QuickDualPivot
{

    // quicksort the array a[] using dual-pivot quicksort
    public static void sort(Comparable[] a)
    {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo)
        {
            return;
        }

        // make sure a[lo] <= a[hi]
        if (less(a[hi], a[lo]))
        {
            exch(a, lo, hi);
        }

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt)
        {
            if (less(a[i], a[lo]))
            {
                exch(a, lt++, i++);
            }
            else if (less(a[hi], a[i]))
            {
                exch(a, i, gt--);
            }
            else
            {
                i++;
            }
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        sort(a, lo, lt - 1);
        if (less(a[lt], a[gt]))
        {
            sort(a, lt + 1, gt - 1);
        }
        sort(a, gt + 1, hi);

        assert isSorted(a, lo, hi);
    }

    /**
     * *************************************************************************
     * Helper sorting functions. *************************************************************************
     */
    // is v < w ?
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * *************************************************************************
     * Check if array is sorted - useful for debugging. *************************************************************************
     */
    private static boolean isSorted(Comparable[] a)
    {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
        {
            if (less(a[i], a[i - 1]))
            {
                return false;
            }
        }
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args)
    {
        //String[] a = ;// StdIn.readAllStrings();
        QuickDualPivot.sort(args);
        show(args);
    }

}
