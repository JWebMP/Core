package za.co.mmagon.jwebswing.components.bootstrap.badge;

import za.co.mmagon.jwebswing.components.newcomponents.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class BSBadgeFeature extends Feature<BSBadgeOptions, BSBadgeFeature> implements BSBadgeFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private BSBadgeOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public BSBadgeFeature(Component forComponent)
    {
        super("Blank");
        setComponent(forComponent);
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public BSBadgeOptions getOptions()
    {
        if (options == null)
        {
            options = new BSBadgeOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String requiredString = getComponent().getJQueryID() + "blank(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }
}
