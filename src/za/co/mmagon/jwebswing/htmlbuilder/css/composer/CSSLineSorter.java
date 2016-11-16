
package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import java.util.Comparator;

/**
 * Compares CSS Lines as a comparator
 * @author MMagon
 * @since 07 Apr 2013
 * @version 1.0
 */
public class CSSLineSorter implements Comparator<CSSLine>
{

    /**
     * Orders the CSS Lines by property then Value
     * @param o1 Line 1
     * @param o2 Line 2
     * @return -1 to 1
     */
    @Override
    public int compare(CSSLine o1, CSSLine o2)
    {
        if(o1.getProperty().compareTo(o2.getProperty()) == 0)
        {
            return o1.getValue().compareTo(o2.getValue());
        }
        return o1.getProperty().compareTo(o2.getProperty());
    }
}
