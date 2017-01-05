package za.co.mmagon.jwebswing.generics;

import java.io.Serializable;
import java.util.Comparator;
import za.co.mmagon.jwebswing.base.html.interfaces.NamedPair;

/**
 * Denotes a pair of anything. Left side master right side is slave
 *
 * @param <L> Left Side Type
 * @param <R> Right Side Type
 *
 * @since
 * @version
 * @author MMagon
 */
public class Pair<L extends Serializable, R extends Serializable> implements NamedPair<L, R>, Serializable, Comparable<Pair>, Comparator<Pair>
{

    private static final long serialVersionUID = 1L;
    /**
     * The left side
     */
    protected final L left;
    /**
     * The right side
     */
    protected final R right;

    private static boolean leftOnly = true;

    /**
     * Constructs a new pair
     *
     * @param left
     * @param right
     */
    public Pair(L left, R right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compare(Pair o1, Pair o2)
    {
        return o1.left.toString().compareTo(o2.left.toString());
    }

    @Override
    public int compareTo(Pair o)
    {
        if (o == null)
        {
            return -1;
        }
        return left.toString().compareTo(o.left.toString());
    }

    /**
     * Gets the left side
     *
     * @return
     */
    @Override
    public L getLeft()
    {
        return left;
    }

    /**
     * Gets the right side
     *
     * @return
     */
    @Override
    public R getRight()
    {
        return right;
    }

    @Override
    public int hashCode()
    {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (!(o instanceof Pair))
        {
            return false;
        }
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft())
                && this.right.equals(pairo.getRight());
    }

    /**
     * Returns if this pair is set to validate on the left field only
     * <p>
     * @return
     */
    public static boolean isLeftOnly()
    {
        return leftOnly;
    }

    /**
     * Sets if this pair should validate on the left pair only
     * <p>
     * @param leftOnly
     */
    public static void setLeftOnly(boolean leftOnly)
    {
        Pair.leftOnly = leftOnly;
    }

}
