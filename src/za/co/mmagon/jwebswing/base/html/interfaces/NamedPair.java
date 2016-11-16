package za.co.mmagon.jwebswing.base.html.interfaces;

/**
 * @param <S> The Left Field Type
 * @param <T> The Right Field Typ
 * Denotes a named pair
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 * 
 */

public interface NamedPair<S,T>
{
    /**
     * Returns the left value
     * @return 
     */
    public S getLeft();
    
    /**
     * returns the right value
     * @return 
     */
    public T getRight();
}
